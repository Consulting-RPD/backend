package com.consulting.rpd.projects.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UpdateClientResource {
    @NotNull
    @NotBlank
    private String tradeName;

    @NotNull
    @NotBlank
    private String legalName;

    @NotNull
    @NotBlank
    private Integer ruc;

    @NotNull
    @NotBlank
    private Date registrationDate;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String clientId;
}
