package cl.ucn.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ucn.web.models.Renta;
import cl.ucn.web.models.Usuario;
import cl.ucn.web.services.IInstalacionService;
import cl.ucn.web.services.IRentaService;
import cl.ucn.web.services.IUsuarioService;

@Controller
@RequestMapping("/cliente/solicitudes")
public class GestionRentaController {

    @Autowired
    IInstalacionService instalacionService;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IRentaService rentaService;

    @GetMapping("/crear")
    public String formSolicitud(Renta renta, Model model,
	    @RequestParam(name = "instalacion", required = false) String instalacion) {

	if (instalacion == null) {
	    model.addAttribute("instalaciones", instalacionService.verTodasLasInstalaciones());
	    return "/cliente/form-crear-solicitud";
	}
	renta.setFechaCreacion(new Date());
	renta.setInstalacion(instalacionService.buscarPorNombre(instalacion));
	Usuario usuario = usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());
	renta.setUsuario(usuario);
	renta.setEstado(0);

	model.addAttribute("rentas", rentaService.buscarPorInstalacion(instalacion));

	return "/cliente/form-crear-solicitud-paso-dos";
    }

    @PostMapping("/crear")
    public String formCrearSolicitud(Renta renta, @RequestParam(name = "dias", required = false) String dias)
	    throws ParseException {

	String[] diasArr = dias.split(",");
	List<Date> diasSolicitud = new ArrayList<Date>();
	for (String dia : diasArr) {
	    System.out.println(dia);
	    diasSolicitud.add(new SimpleDateFormat("dd-MM-yyyy").parse(dia));
	}
	renta.setMonto(diasSolicitud.size() * renta.getInstalacion().getPrecio());
	renta.setDiasSolicitud(diasSolicitud);

	System.out.println(renta.toString());
	rentaService.guardar(renta);
	return "redirect:/";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	// Usuario usuario =
	// usuarioService.buscarPorRut(SecurityContextHolder.getContext().getAuthentication().getName());

	return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
