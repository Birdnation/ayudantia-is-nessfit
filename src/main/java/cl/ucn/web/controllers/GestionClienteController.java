package cl.ucn.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ucn.web.models.Rol;
import cl.ucn.web.models.Usuario;
import cl.ucn.web.services.IUsuarioService;

@Controller
@RequestMapping("/administrativo/gestion-cliente")
public class GestionClienteController {

    /**
     * Inyección del servicio de usuarios
     */
    @Autowired
    private IUsuarioService usuarioService;

    /**
     * Inyección del bean de encriptación de contraseñas
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public String index(Model model, @RequestParam(name = "rut", required = false) String rut, Pageable page) {
	if (rut != null) {
	    model.addAttribute("usuarios", usuarioService.buscarUsuariosPorRut(rut, page, 3));
	} else {
	    model.addAttribute("usuarios", usuarioService.verClientes(page));
	}
	return "administrativo/gestion-clientes";
    }

    @GetMapping("/crear")
    public String formUsuario(Usuario usuario) {
	return "/administrativo/form-crear-cliente";
    }

    @PostMapping("/crear")
    public String formCrearUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {

	// paso 1 validaciones
	// result.rejectValue("rut", null, "rut inválido");
	Usuario existe = usuarioService.buscarPorRut(usuario.getRut());

	if (existe != null) {
	    result.rejectValue("rut", null, "Rut existente en la base de datos");
	}

	if (result.hasErrors()) {
	    return "administrativo/form-crear-cliente";
	}

	// paso 2 set atributos no ingresados por usuario
	usuario.setContrasena(passwordEncoder.encode(usuario.getRut()));
	usuario.setEstado(1);
	Rol rolCliente = new Rol();
	rolCliente.setId(3);
	usuario.setRol(rolCliente);

	// paso 3 persistencia
	usuarioService.guardar(usuario);

	// paso 4 redireccionamiento
	return "redirect:/administrativo/gestion-cliente";
    }

    @GetMapping("/estado/{rut}")
    public String cambiarEstado(@PathVariable(name = "rut") String rut) {
	// Paso 1 Busqueda
	Usuario usuario = usuarioService.buscarPorRut(rut);

	// Paso 2 setEstado
	usuario.setEstado(usuario.getEstado() == 1 ? 0 : 1);

	// Paso 3 Persistencia
	usuarioService.guardar(usuario);

	// Paso 4 redireccionamiento
	return "redirect:/administrativo/gestion-cliente";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	// Usuario usuario =
	// usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());

	return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
