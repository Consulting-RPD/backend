package com.consulting.rpd.protocols.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("protocolsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProtocolHeaderMapper protocolHeaderMapper() {
        return new ProtocolHeaderMapper();
    }

    @Bean
    public DocumentationMapper documentationMapper(){
        return new DocumentationMapper();
    }
    @Bean
    public SignatureMapper signatureMapper(){
        return new SignatureMapper();
    }

    @Bean
    public CommentMapper commentMapper(){
        return new CommentMapper();
    }

    @Bean
    public InitialVerificationMapper initialVerificationMapper(){
        return new InitialVerificationMapper();
    }
}
