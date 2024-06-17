package com.consulting.rpd.projects.resource;

import com.consulting.rpd.projects.domain.model.Project;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    private List<Project> projects;

}
