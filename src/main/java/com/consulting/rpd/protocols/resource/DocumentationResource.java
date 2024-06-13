package com.consulting.rpd.protocols.resource;

import com.consulting.rpd.protocols.domain.model.Documentation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentationResource {
    private String observations;
    private Integer approvedPlans;
    private Integer compTechSpec;
    private Integer persTrained;
    private Integer descMemory;
    private Integer asBuilt;
    private Integer techSpecs;
    private Integer userTrainingMinutes;
    private Integer maintenanceManual;
    private Integer ventsCalculations;
    private Integer hydroTestCert;
    private Integer pipeCleaningCert;
    private Integer userManual;
    private Integer deviceList;
    private Integer periodicsInspectionNfpa;
    private Integer inspectionMaintenancePlan;
    private Integer qualityControlCertificate;
    private Integer certificateComplianceAwsb;
    private Integer certificateTrainedStaffAwsb;
    private Integer weldingProcess;
    private Integer weldersCertificate;
    private Integer nondestructiveTesting;
    private Integer exhaustLineCalculated;
    private Integer nfpaMaintenanceManual;
    private Integer pumpRoomVentilation;
    private Integer qualityControlProcedure;
    private Integer batteryCapacityCalculation;
    private Integer devicesWithLabels;
    private Integer instructionsForComponents;
    private Integer careInstructions;
    private Integer operationManual;
    private Long protocolHeaderId;
}
