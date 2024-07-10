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
public class CreateAlarmDeviceTestResource {
    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String location;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String supervisedSectorization;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String panelSignal;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String deviceType;

    @NotNull
    private Integer operationTimeMinutes;

    @NotNull
    private Integer operationTimeSeconds;
}
