package cl.ucn.web.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import cl.ucn.web.models.Usuario;

@SpringBootTest
class UsuarioServiceImplTest {

    @Autowired
    IUsuarioService service;

    @Test
    public void testUsuarioMayor0() {
	// Given
	List<Usuario> lista = service.verTodosLosUsuarios();

	// When
	// Then
	assertTrue(lista.size() > 0);
    }

    @Test
    public void testVerSoloAdministrativos() {
	// Given
	Page<Usuario> administrativos = service.verAdministrativos(any());
	List<Usuario> listAdministrativos = administrativos.toList();

	// When
	// Then
	for (Usuario usuario : listAdministrativos) {
	    assertEquals(usuario.getRol().getNombre(), "ADMINISTRATIVO");
	}

    }

    @Test
    public void testVerSoloClientes() {
	// Given
	Page<Usuario> clientes = service.verClientes(any());
	List<Usuario> listClientes = clientes.toList();

	// When
	// Then
	for (Usuario usuario : listClientes) {
	    assertEquals(usuario.getRol().getNombre(), "CLIENTE");
	}

    }
}
