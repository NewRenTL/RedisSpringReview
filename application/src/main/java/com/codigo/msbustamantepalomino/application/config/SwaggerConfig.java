package com.codigo.msbustamantepalomino.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Diego Bustamante");
        contact.setEmail("diegor.bpa.02@gmail.com");

        Info information = new Info().title("My First System API")
                .version("1.0")
                .description("This is my first API that make with my own knowledge")
                .contact(contact);


        return new OpenAPI()
                .info(information);
    }
}
