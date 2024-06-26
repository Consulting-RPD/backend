package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity(name = "documents")
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    @Size(max = 255)
    private String observation;

    @Column(nullable = true)
    private Integer approvedPlans;

    @Column(nullable = true)
    private Integer compTechSpec;

    @Column(nullable = true)
    private Integer persTrained;

    @Column(nullable = true)
    private Integer descMemory;

    @Column(nullable = true)
    private Integer asBuilt;

    @Column(nullable = true)
    private Integer techSpecs;

    @Column(nullable = true)
    private Integer userTrainingMinutes;

    @Column(nullable = true)
    private Integer maintenanceMinutes;

    @Column(nullable = true)
    private Integer ventsCalculation;

    @Column(nullable = true)
    private Integer hydroTestCert;

    @Column(nullable = true)
    private Integer pipeCleaningCert;

    @Column(nullable = true)
    private Integer userManual;

    @Column(nullable = true)
    private Integer deviceList;

    @Column(nullable = true)
    private Integer periodicInspections;

    @Column(nullable = true)
    private Integer inspectionMaintenancePlan;

    @Column(nullable = true)
    private Integer qualityControlCert;

    @Column(nullable = true)
    private Integer certificateComplianceAwsb;

    @Column(nullable = true)
    private Integer certificateTrainedStaffAwsb;

    @Column(nullable = true)
    private Integer weldingProcessAwsb;

    @Column(nullable = true)
    private Integer weldersCertificateAwsb;

    @Column(nullable = true)
    private Integer nonDestructiveTesting;

    @Column(nullable = true)
    private Integer exhaustLineCalculated;

    @Column(nullable = true)
    private Integer nfpaMaintenanceManual;

    @Column(nullable = true)
    private Integer pumpRoomVentilation;

    @Column(nullable = true)
    private Integer qualityControlProcedure;

    @Column(nullable = true)
    private Integer batteryCapacityCalculation;

    @Column(nullable = true)
    private Integer labeledDevices;

    @Column(nullable = true)
    private Integer instructionsForComponents;

    @Column(nullable = true)
    private Integer careInstructions;

    @Column(nullable = true)
    private Integer operationManual;

    //Relationships
    @OneToOne
    @JoinColumn(name = "protocol_header_id")
    private ProtocolHeader protocolHeader;
}
