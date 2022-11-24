package cl.ucn.web.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

    public Page<Usuario> findByRolIdOrderByEstadoDesc(int rol, Pageable page);

    public Usuario findByRut(String rut);

    public Page<Usuario> findByRutContainingAndRolIdOrderByEstadoDesc(String rut, int rol, Pageable page);

}
