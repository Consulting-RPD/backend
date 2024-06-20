package com.consulting.rpd.projects.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class CreateProjectForClientResource {
    @NotNull
    @NotBlank
    @Size(max = 10)
    private String projectCode;

    @NotNull
    @NotBlank
    @Size(max = 1)
    private String projectCorrelative;

    @NotNull
    private Date registrationDate;

    @NotNull
    @NotBlank
    private String projectName;
}