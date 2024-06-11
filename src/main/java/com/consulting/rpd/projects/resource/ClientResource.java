package com.consulting.rpd.projects.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientResource {
    private Long id;
    private String tradeName;
    private String legalName;
    private Integer ruc;
    private Date registrationDate;
    private String city;
    private String country;
    private String clientCode;

}
