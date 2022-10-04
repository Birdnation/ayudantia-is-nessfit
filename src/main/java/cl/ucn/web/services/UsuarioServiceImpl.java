package cl.ucn.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.ucn.web.models.Usuario;
import cl.ucn.web.repositories.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> verTodosLosUsuarios() {
	return usuarioRepository.findAll();
    }

    @Override
    public Page<Usuario> verAdministrativos(Pageable page) {
	return usuarioRepository.findByRolIdOrderByEstadoDesc(2, page);
    }

    @Override
    public void guardar(Usuario usuario) {
	usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorRut(String rut) {
	Usuario usuario = usuarioRepository.findByRut(rut);
	return usuario;
    }

    @Override
    public Page<Usuario> buscarUsuariosPorRut(String rut, Pageable page, int rol) {
	return usuarioRepository.findByRutContainingAndRolIdOrderByEstadoDesc(rut, rol, page);
    }

    @Override
    public Page<Usuario> verClientes(Pageable page) {
	return usuarioRepository.findByRolIdOrderByEstadoDesc(3, page);
    }

}
