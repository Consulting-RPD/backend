package com.consulting.rpd.profiling.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class CreateProfileResource {
    @NotNull
    @NotBlank
    @Size(min = 5, max = 30)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 5,max = 30)
    private String lastName;

    @NotNull
    @NotBlank
    private Long roleId;
}
