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

    @Bean
    public PipeAndAccesoriesMapper pipeAndAccesoriesMapper(){
        return new PipeAndAccesoriesMapper();
    }

    @Bean
    public SystemLocationMapper systemLocationMapper(){
        return new SystemLocationMapper();
    }

    @Bean
    public SprinklerMapper sprinklerMapper(){
        return new SprinklerMapper();
    }

    @Bean
    public AlarmValveMapper alarmValveMapper(){
        return new AlarmValveMapper();
    }

    @Bean
    public AlarmValveDataMapper alarmValveDataMapper(){
        return new AlarmValveDataMapper();
    }
}
