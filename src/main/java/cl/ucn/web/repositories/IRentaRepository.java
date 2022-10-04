package cl.ucn.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Renta;

public interface IRentaRepository extends JpaRepository<Renta, Integer> {

    public List<Renta> findByInstalacionNombre(String nombre);

}
