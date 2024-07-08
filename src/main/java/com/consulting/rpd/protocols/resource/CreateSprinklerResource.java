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
public class CreateSprinklerResource {
     @NotNull
    @NotBlank
    @Size(min = 1, max = 50)    
    private String brand;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)   
    private String model;

    @NotNull
    private Integer productionYear;

    @NotNull
    private Integer kFactor;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double temperature;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 80)   
    private String answer;

}
