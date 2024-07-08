package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateSystemLocationResource {
        @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 150)
    private String feedingBuilding;
}
