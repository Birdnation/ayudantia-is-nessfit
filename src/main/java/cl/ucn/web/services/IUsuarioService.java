package cl.ucn.web.services;

import java.util.List;

import cl.ucn.web.models.Usuario;

public interface IUsuarioService {

    public List<Usuario> verTodosLosUsuarios();

    public List<Usuario> verAdministrativos();

    public void guardar(Usuario usuario);

    public Usuario buscarPorRut(String rut);
}
