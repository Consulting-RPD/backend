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
public class AlarmDeviceTestResource {
    private Long id;
    private String location;
    private String supervisedSectorization;
    private String panelSignal;
    private String deviceType;
    private Integer operationTimeMinutes;
    private Integer operationTimeSeconds;
}
