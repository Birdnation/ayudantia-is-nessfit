package cl.ucn.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ucn.web.services.IRentaService;

@Controller
@RequestMapping("/administrativo/gestion-solicitud")
public class GestionSolicitudController {

    @Autowired
    private IRentaService rentaService;

    @GetMapping("")
    public String verSolicitudes(Pageable page, Model model) {
	model.addAttribute("solicitudes", rentaService.verSolicitudesPorEstado(0, page));
	return "administrativo/gestion-solicitudes";
    }

    @GetMapping("/{id}")
    public String detalleSolicitud(@PathVariable("id") int id, Model model) {
	model.addAttribute("solicitud", rentaService.buscarPorId(id));
	return "administrativo/ver-solicitud";
    }
}
