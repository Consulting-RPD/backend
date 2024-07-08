package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreatePipeAndAccesoriesResource {
    @Size(min = 1, max = 25)
    private String pipeType;

    private Integer properInstallation;

    private Integer accessoryType;

    @Size(min = 1, max = 80)
    private String explanation;

    private Integer pipeCleaned;

    private Integer clearOfResidue;

    private Integer approvedForPressures;

    private Integer nozzlesObstructed;

    private Integer accordingToDrawings;

    private Integer leakageTest;

    private Integer supplierCertificate;

    @Size(min = 1, max = 200)
    private String pipesObs;

    @NotNull
    private Integer pipeCleaningCertf;

    @NotNull
    private Integer oilResidueInspection;

    @NotNull
    private Integer pressureApproval;

    @NotNull
    private Integer obstructionCheck;

    @NotNull
    private Integer complianceWithDrawings;

    @NotNull
    private Integer propeInstallationCheck;
}
