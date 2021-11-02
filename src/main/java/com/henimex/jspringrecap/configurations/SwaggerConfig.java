package com.henimex.jspringrecap.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.henimex.jspringrecap"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Java SpringBoot Rest API",
                "http://localhost:8080/swagger-ui.html \nUsing PostgreSQL Database by j.Henimex ",
                "a.1.0.21",
                "Terms of Use Free",
                new Contact("Joseph HenimeX", "call: 0543 502 43 26", "henimex@gmail.com"),
                "Free License", "",
                Collections.emptyList()
        );
    }
}
