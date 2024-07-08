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
public class PipeAndAccesoriesResource {
    private Long pipeId;
    private String pipeType;
    private Integer properInstallation;
    private Integer accessoryType;
    private String explanation;
    private Integer pipeCleaned;
    private Integer clearOfResidue;
    private Integer approvedForPressures;
    private Integer nozzlesObstructed;
    private Integer accordingToDrawings;
    private Integer leakageTest;
    private Integer supplierCertificate;
    private String pipesObs;
    private Integer pipeCleaningCertf;
    private Integer oilResidueInspection;
    private Integer pressureApproval;
    private Integer obstructionCheck;
    private Integer complianceWithDrawings;
    private Integer propeInstallationCheck;
}
