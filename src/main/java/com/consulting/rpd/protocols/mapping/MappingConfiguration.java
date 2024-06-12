package com.consulting.rpd.protocols.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("protocolsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProtocolHeaderMapper protocolHeaderMapper() {return new ProtocolHeaderMapper();}


}
