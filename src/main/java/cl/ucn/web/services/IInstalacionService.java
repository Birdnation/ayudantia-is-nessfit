package cl.ucn.web.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.ucn.web.models.Instalacion;
import cl.ucn.web.models.TipoInstalacion;

public interface IInstalacionService {

    public void guardar(Instalacion instalacion);

    public Page<Instalacion> verInstalaciones(Pageable page);

    public List<Instalacion> verTodasLasInstalaciones();

    public List<Instalacion> verInstalacionesPorTipo(TipoInstalacion tipo);

    public Instalacion buscarPorNombre(String nombre);
}
