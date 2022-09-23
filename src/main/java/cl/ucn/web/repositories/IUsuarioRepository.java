package cl.ucn.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucn.web.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

    // public List<Usuario> findByRolId(int rol);

    // public Usuario findByRut(String rut);

}
