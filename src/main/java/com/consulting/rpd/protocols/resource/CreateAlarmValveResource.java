package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotNull;
import lombok.With;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateAlarmValveResource {
    @NotNull
    private Integer alarmValveFlowIndicator;

    @NotNull
    private Integer activationFirePump;
}