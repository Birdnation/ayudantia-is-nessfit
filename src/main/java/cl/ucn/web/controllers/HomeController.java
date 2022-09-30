package cl.ucn.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.ucn.web.models.Usuario;
import cl.ucn.web.services.IUsuarioService;

@Controller
public class HomeController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping({ "/inicio", "/", "" })
    public String index(Model model) {
	return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
	SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	logoutHandler.logout(request, null, null);
	return "redirect:/";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
	Usuario usuario = usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());
	model.addAttribute("usuario", usuario);
	return "perfil";
    }

    @PostMapping("/perfil")
    public String perfilForm(@Valid Usuario usuario, BindingResult result, Model model) {

	Usuario usuarioAuth = usuarioService
		.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());

	// Paso 1.-Validaciones
	if (result.hasErrors()) {
	    return "perfil";
	}

	// Paso 2.- Set´s
	usuarioAuth.setNombre(usuario.getNombre());
	usuarioAuth.setApellido(usuario.getApellido());
	usuarioAuth.setEmail(usuario.getEmail());
	usuarioAuth.setTelefono(usuario.getTelefono());

	// Paso 3.- Persistencia
	usuarioService.guardar(usuarioAuth);

	// Paso 4.- Redireccion
	return "redirect:/";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
