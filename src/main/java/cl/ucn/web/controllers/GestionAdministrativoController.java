package cl.ucn.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ucn.web.models.Rol;
import cl.ucn.web.models.Usuario;
import cl.ucn.web.services.IUsuarioService;

@Controller
//Mapeo de clase (aplica a todas las funciones declaradas.
@RequestMapping("/administrador/gestion-adm")
public class GestionAdministrativoController {

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

    /*
     * @Autowired private RutValidation validation;
     * 
     * @InitBinder public void initBinder(WebDataBinder binder) {
     * binder.addValidators(validation); }
     */

    @GetMapping("")
    public String index(Model model) {
	model.addAttribute("usuarios", usuarioService.verTodosLosUsuarios());
	return "administrador/gestion-adm";
    }

    @GetMapping("/crear")
    public String formUsuario(Usuario usuario) {
	return "/administrador/form-crear-administrativo";
    }

    @PostMapping("/crear")
    public String formCrearUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {

	// paso 1 set atributos no ingresados por usuario
	usuario.setContrasena(passwordEncoder.encode(usuario.getRut()));
	usuario.setEstado(1);
	Rol rolAdministrativo = new Rol();
	rolAdministrativo.setId(2);
	usuario.setRol(rolAdministrativo);

	// paso 2 validaciones
	if (usuario.getRut() == "1") {

	}
	// result.rejectValue("rut", null, "rut inválido");

	if (result.hasErrors()) {
	    return "/administrador/form-crear-administrativo";
	}

	// paso 3 persistencia
	usuarioService.guardar(usuario);

	// paso 4 redireccionamiento
	return "redirect:/administrador/gestion-adm";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
