package cl.ucn.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Instalacion;
import cl.ucn.web.models.TipoInstalacion;

public interface IInstalacionRepository extends JpaRepository<Instalacion, String> {

    public List<Instalacion> findByTipo(TipoInstalacion tipo);

}
