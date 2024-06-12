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
    private Integer ruc;

    @NotNull
    private Date registrationDate;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String clientCode;
}
