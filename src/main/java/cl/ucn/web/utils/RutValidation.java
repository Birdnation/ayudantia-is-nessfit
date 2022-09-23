package cl.ucn.web.utils;

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

	// errors.reject("msg", "no valido");

    }

}
