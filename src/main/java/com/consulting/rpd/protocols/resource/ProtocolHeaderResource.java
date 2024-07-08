package com.consulting.rpd.protocols.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolHeaderResource {
    private Long protocolId;
    private String protocolNumber;
    private String protectedArea;
    private Date date;
    private String address;
    private Integer type;
    
}
