package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAlarmValveDataResource {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String type;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String brand;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String model;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String location;
}
