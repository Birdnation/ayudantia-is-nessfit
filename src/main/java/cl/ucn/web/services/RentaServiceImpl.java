package cl.ucn.web.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.ucn.web.models.Renta;
import cl.ucn.web.repositories.IRentaRepository;

@Service
public class RentaServiceImpl implements IRentaService {

    @Autowired
    private IRentaRepository rentaRepository;

    @Override
    public void guardar(Renta renta) {
	rentaRepository.save(renta);

    }

    @Override
    public List<Renta> buscarPorInstalacionAndEstado(String instalacion, int estado) {
	return rentaRepository.findByInstalacionNombreAndInstalacionEstado(instalacion, estado);
    }

    @Override
    public Page<Renta> verRentasPorUsuario(String rut, Pageable page) {
	return rentaRepository.findByUsuarioRut(rut, page);
    }

    @Override
    public Page<Renta> verSolicitudesPorEstado(Integer estado, Pageable page) {
	return rentaRepository.findByEstadoOrderByFechaCreacionAsc(estado, page);
    }

    @Override
    public Renta buscarPorId(int id) {
	if (rentaRepository.findById(id).isPresent()) {
	    return rentaRepository.findById(id).get();
	} else {
	    return null;
	}
    }

    @Override
    public List<Renta> buscarPorRangoFecha(Date inicio, Date termino) {
	return rentaRepository.findByFechaCreacionBetween(inicio, termino);
    }

    @Override
    public List<Renta> verRentasPorUsuario(String rut) {
	return rentaRepository.findByUsuarioRut(rut);
    }

}
