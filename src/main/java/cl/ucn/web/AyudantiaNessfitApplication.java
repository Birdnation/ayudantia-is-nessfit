package cl.ucn.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AyudantiaNessfitApplication {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
	SpringApplication.run(AyudantiaNessfitApplication.class, args);
    }

    @PostConstruct
    public void init() {
	System.out.println(passwordEncoder.encode("123456"));
    }

}
