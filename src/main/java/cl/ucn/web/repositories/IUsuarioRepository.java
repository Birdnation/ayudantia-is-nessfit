package cl.ucn.web.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

    // SELECT * FROM usuarios u INNER JOIN r.id ON u.id_rol = r.id;
    public Page<Usuario> findByRolIdOrderByEstadoDesc(int rol, Pageable page);

    // SELECT * FROM usuarios u WHERE u.rut = rut;
    public Usuario findByRut(String rut);

    public Page<Usuario> findByRutContainingAndRolIdOrderByEstadoDesc(String rut, int rol, Pageable page);

}
