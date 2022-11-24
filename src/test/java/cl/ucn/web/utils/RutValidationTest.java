package cl.ucn.web.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RutValidationTest {

    RutValidation validation = new RutValidation();

    @Test
    @DisplayName("Valida formato de rut")
    public void formatoValido() {
	assertThat(validation.validarFormato("173922825")).isEqualTo(true);
	assertThat(validation.validarFormato("111111111")).isEqualTo(true);
    }

    @Test
    @DisplayName("Valida formato inválido de rut")
    public void formatoNoValido() {
	assertThat(validation.validarFormato("aaaaaa")).isEqualTo(false);
    }

}
