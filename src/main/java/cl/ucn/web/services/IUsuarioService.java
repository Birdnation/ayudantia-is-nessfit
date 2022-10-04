package cl.ucn.web.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.ucn.web.models.Usuario;

public interface IUsuarioService {

    public List<Usuario> verTodosLosUsuarios();

    public Page<Usuario> verAdministrativos(Pageable page);

    public Page<Usuario> verClientes(Pageable page);

    public void guardar(Usuario usuario);

    public Usuario buscarPorRut(String rut);

    public Page<Usuario> buscarUsuariosPorRut(String rut, Pageable page, int rol);

}