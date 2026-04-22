package com.example.Equipo.Configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API EQUIPO FÚTBOL")
                        .version("1.0")
                        .description("API PARA LA GESTIÓN DE UN EQUIPO DE FÚTBOL")
                        .contact(new Contact()
                                .name("DESARROLLADOR DE API")
                                .email("equipo@futbol.com")));
    }
}