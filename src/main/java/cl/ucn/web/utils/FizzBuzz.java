package cl.ucn.web.utils;

public class FizzBuzz {

    public String calcular(String numero) {

	try {
	    Integer.parseInt(numero);
	} catch (Exception e) {
	    throw e;
	}

	if (Integer.parseInt(numero) % 3 == 0 && Integer.parseInt(numero) % 5 == 0) {
	    return "FizzBuzz";
	}

	if (Integer.parseInt(numero) % 5 == 0) {
	    return "Buzz";
	}

	if (Integer.parseInt(numero) % 3 == 0) {
	    return "Fizz";
	}
	return numero;
    }

}
