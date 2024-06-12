package com.consulting.rpd.projects.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UpdateProjectResource {
    @NotNull
    @NotBlank
    @Size(max = 10)
    private String projectCode;

    @NotNull
    @NotBlank
    @Size(max = 1)
    private String projectCorrelative;

    @NotNull
    @NotBlank
    private Date registrationDate;

    @NotNull
    @NotBlank
    private String projectName;

    @NotNull
    @NotBlank
    private Long clientId;
}