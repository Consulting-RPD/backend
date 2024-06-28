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
public class CreateInitialVerificationResource {
    private Integer equipmentListed;
    private Integer oilLevel;
    private Integer coolingValves;
    private Integer batteryLevel;
    private Integer engineHeaters;
    private Integer waterReserve;
    private Integer exhaustLine;
    private Integer pumpBaseGrouted;
    private Integer motorPumpoAligned;
    private Integer traiendPersonnel;
    private String lastPumpStart;
    private String hourmeterReading;
    private Integer partsProtected;
}
