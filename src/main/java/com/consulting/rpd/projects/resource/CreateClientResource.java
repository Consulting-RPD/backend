package com.consulting.rpd.projects.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class CreateClientResource {
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
    private String clientCode;
}
