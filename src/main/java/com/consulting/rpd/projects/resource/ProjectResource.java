package com.consulting.rpd.projects.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class ProjectResource {
    private Long id;
    private String projectCode;
    private String projectName;
    private String projectCorrelative;
    private Date registrationDate;
    private ClientResource client;
}
