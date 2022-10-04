package cl.ucn.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Instalacion;

public interface IInstalacionRepository extends JpaRepository<Instalacion, String> {

}
