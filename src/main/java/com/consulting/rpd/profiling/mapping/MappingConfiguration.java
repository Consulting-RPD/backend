package com.consulting.rpd.profiling.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProfileMapper profileMapper() {return new ProfileMapper();}
}
