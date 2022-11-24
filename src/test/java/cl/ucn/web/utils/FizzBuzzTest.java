package cl.ucn.web.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testNoMultiplo5y3() {
	assertThat(fizzBuzz.calcular("2")).isEqualTo("2");
	assertThat(fizzBuzz.calcular("4")).isEqualTo("4");
    }

    @Test
    public void testMultiplo3() {
	assertThat(fizzBuzz.calcular("3")).isEqualTo("Fizz");
	assertThat(fizzBuzz.calcular("6")).isEqualTo("Fizz");
    }

    @Test
    public void testMultiplo5() {
	assertThat(fizzBuzz.calcular("5")).isEqualTo("Buzz");
	assertThat(fizzBuzz.calcular("10")).isEqualTo("Buzz");
    }

    @Test
    public void testMultiplo3y5() {
	assertThat(fizzBuzz.calcular("15")).isEqualTo("FizzBuzz");
	assertThat(fizzBuzz.calcular("30")).isEqualTo("FizzBuzz");
    }

    @Test
    public void testNoNumero() {
	assertThrows(Exception.class, () -> {
	    fizzBuzz.calcular("hola");
	});
    }

}
