package cl.ucn.web.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Renta;

public interface IRentaRepository extends JpaRepository<Renta, Integer> {

    public List<Renta> findByInstalacionNombreAndInstalacionEstado(String nombre, int estado);

    public Page<Renta> findByUsuarioRut(String rut, Pageable page);

    public List<Renta> findByUsuarioRut(String rut);

    public Page<Renta> findByEstadoOrderByFechaCreacionAsc(Integer estado, Pageable page);

    public List<Renta> findByFechaCreacionBetween(Date fechaInicio, Date fechaTermino);

}
