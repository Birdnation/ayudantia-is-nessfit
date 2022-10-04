package cl.ucn.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.ucn.web.models.Instalacion;
import cl.ucn.web.repositories.IInstalacionRepository;

@Service
public class InstalacionServiceImpl implements IInstalacionService {

    @Autowired
    private IInstalacionRepository instalacionRepository;

    @Override
    public void guardar(Instalacion instalacion) {
	instalacionRepository.save(instalacion);

    }

    @Override
    public Page<Instalacion> verInstalaciones(Pageable page) {
	return instalacionRepository.findAll(page);
    }

    @Override
    public List<Instalacion> verTodasLasInstalaciones() {
	return instalacionRepository.findAll();
    }

    @Override
    public Instalacion buscarPorNombre(String nombre) {
	if (instalacionRepository.findById(nombre).isPresent()) {
	    return instalacionRepository.findById(nombre).get();
	} else {
	    return null;
	}
    }

}
