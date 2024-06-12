package com.consulting.rpd.projects.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("projectMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ClientMapper clientMapper(){
        return new ClientMapper();
    }

    @Bean
    public ProjectMapper projectMapper(){
        return new ProjectMapper();
    }
}
