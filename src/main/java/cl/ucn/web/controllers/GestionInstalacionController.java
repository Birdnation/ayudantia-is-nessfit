package cl.ucn.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ucn.web.models.Instalacion;
import cl.ucn.web.models.TipoInstalacion;
import cl.ucn.web.services.IInstalacionService;

@Controller
@RequestMapping("/administrativo/gestion-instalacion")
public class GestionInstalacionController {

    @Autowired
    private IInstalacionService instalacionService;

    @GetMapping("")
    public String index(Model model, Pageable page) {
	model.addAttribute("instalaciones", instalacionService.verInstalaciones(page));
	return "administrativo/gestion-instalaciones";
    }

    @GetMapping("/crear")
    public String formUsuario(Instalacion instalacion) {
	return "administrativo/form-crear-instalacion";
    }

    @PostMapping("/crear")
    public String formCrearUsuario(@Valid Instalacion instalacion, BindingResult result, RedirectAttributes attr) {

	// paso 1 validaciones
	// result.rejectValue("rut", null, "rut inválido");

	if (result.hasErrors()) {
	    return "administrativo/form-crear-instalacion";
	}

	// paso 2 persistencia
	instalacionService.guardar(instalacion);

	// paso 3 redireccionamiento
	return "redirect:/administrativo/gestion-instalacion";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	// Usuario usuario =
	// usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());

	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @ModelAttribute("tiposInstalaciones")
    public TipoInstalacion[] tipos() {
	return TipoInstalacion.values();
    }

}
