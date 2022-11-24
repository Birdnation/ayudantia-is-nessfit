package cl.ucn.web.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.ucn.web.models.Usuario;

@SpringBootTest
class IUsuarioRepositoryTest {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Test
    public void guardarUsuario() {
	Usuario nuevo = new Usuario();
	nuevo.setRut("1234");
	assertEquals(usuarioRepository.save(nuevo).getRut(), "1234");
    }

}
