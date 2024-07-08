package com.consulting.rpd.protocols.resource;

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
public class AlarmValveResource {
    private Long id;
    private Integer alarmValveFlowIndicator;
    private Integer activationFirePump;
}
