package com.consulting.rpd.protocols.resource;

import com.consulting.rpd.projects.resource.ProjectResource;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProtocolHeaderResource {
    private String protocolNumber;
    private String protectedArea;
    private String address;
    private Integer type;
    private Date date;
    private ProjectResource project;
}
