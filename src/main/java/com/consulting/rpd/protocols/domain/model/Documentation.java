package com.consulting.rpd.protocols.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "documentation")
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
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

    //Relationship
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "protocol_header_id", nullable = false)
    @JsonIgnore
    private ProtocolHeader protocolHeader;
}
