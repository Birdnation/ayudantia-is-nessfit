package cl.ucn.web.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.ucn.web.models.Usuario;

@Component
public class RutValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	Usuario usuario = (Usuario) target;

	// lógica para validar
	// errors.rejectValue("rut", null, "Formato de rut incorrecto");

    }

    public Boolean validarFormato(String rut) {
	String pattern = "^(\\d{1,2}(\\d{3}){2}[\\dkK])$";
	if (Pattern.matches(pattern, rut)) {
	    return true;
	}
	return false;
    }

}
