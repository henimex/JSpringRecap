package com.henimex.jspringrecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class JSpringRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(JSpringRecapApplication.class, args);
        System.out.println("At The End a Spring Project Perfectly Runs With Connected PostgreDB");
    }
}
