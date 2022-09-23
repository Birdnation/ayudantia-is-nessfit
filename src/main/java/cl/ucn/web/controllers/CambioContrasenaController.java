package cl.ucn.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ucn.web.services.IUsuarioService;

@Controller
public class CambioContrasenaController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/cambio")
    public String cambiarContrasenaForm() {

	return "cambioContrasena";
    }

    @PostMapping("/cambio")
    public String enviarForm(@RequestParam(name = "nueva-contrasena") String contrasena,
	    @RequestParam(name = "nueva-contrasena-repetir") String confirmarContrasena) {

	// usuario logeado
	// Usuario usuario =
	// usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());

	// validar contraseñas iguales

	// set usuario
	// usuario.setContrasena(passwordEncoder.encode(contrasena));

	// persistencia
	// usuarioService.guardar(usuario);

	return "redirect:/";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
