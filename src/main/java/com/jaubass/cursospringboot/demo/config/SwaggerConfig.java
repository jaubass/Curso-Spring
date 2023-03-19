package com.jaubass.cursospringboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.Collections;

/**
 * Configuracion Swagger para la documentacion de la API REST
 * http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();


    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot API REST",
                "Libraries api rest docs",
                "1.0",
                "http://google.es",
                new Contact("Jau", "http://jaubass.com", "jau@bububass.com"),
                "MIT",
                "http://google.es", Collections.emptyList());
    }

}
