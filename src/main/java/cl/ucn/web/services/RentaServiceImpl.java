package cl.ucn.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Renta> buscarPorInstalacion(String instalacion) {
	return rentaRepository.findByInstalacionNombre(instalacion);
    }

}
