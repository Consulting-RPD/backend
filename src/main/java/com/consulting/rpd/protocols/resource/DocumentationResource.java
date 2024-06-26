package com.consulting.rpd.protocols.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DocumentationResource {
    private Long documentationId;
    private String observation;
    private Integer approvedPlans;
    private Integer compTechSpec;
    private Integer persTrained;
    private Integer descMemory;
    private Integer asBuilt;
    private Integer techSpecs;
    private Integer userTrainingMinutes;
    private Integer maintenanceMinutes;
    private Integer ventsCalculation;
    private Integer hydroTestCert;
    private Integer pipeCleaningCert;
    private Integer userManual;
    private Integer deviceList;
    private Integer periodicInspections;
    private Integer inspectionMaintenancePlan;
    private Integer qualityControlCert;
    private Integer certificateComplianceAwsb;
    private Integer certificateTrainedStaffAwsb;
    private Integer weldingProcessAwsb;
    private Integer weldersCertificateAwsb;
    private Integer nonDestructiveTesting;
    private Integer exhaustLineCalculated;
    private Integer nfpaMaintenanceManual;
    private Integer pumpRoomVentilation;
    private Integer qualityControlProcedure;
    private Integer batteryCapacityCalculation;
    private Integer labeledDevices;
    private Integer instructionsForComponents;
    private Integer careInstructions;
    private Integer operationManual;
}
