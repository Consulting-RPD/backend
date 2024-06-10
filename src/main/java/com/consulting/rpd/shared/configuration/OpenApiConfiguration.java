package com.consulting.rpd.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                new Info()
                        .title("RPD API")
                        .version("1.0")
                        .description("RPD API")
                        .termsOfService("http://www.essac.com.pe")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                        )
                        .contact(
                                new Contact()
                                        .name("Engineering Services & Consulting S.A.C.")
                                        .url("https://www.essac.com.pe")
                        )
        );
    }
}
