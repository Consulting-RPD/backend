package com.consulting.rpd.shared.configuration;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Consulting RPD API")
                                .version("1.0")
                                .description("RPD")
                                .license(
                                        new License()
                                                .name("Apache 2.0 License")
                                                .url("https://essac.com.pe")
                                )
                                .contact(
                                        new Contact()
                                                .url("https://essac.com.pe")
                                                .name("Engineering Services & Consulting S.A.C.")
                                )
                );
    }
}
