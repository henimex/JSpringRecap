package com.henimex.jspringrecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JSpringRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(JSpringRecapApplication.class, args);
        System.out.println("Compile Successful. Listening http://localhost:8080/swagger-ui.html");
    }
}
