package com.consulting.rpd.profiling.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleResource {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 24)
    private String name;
}
