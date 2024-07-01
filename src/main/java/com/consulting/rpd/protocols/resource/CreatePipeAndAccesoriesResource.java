package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    private Integer pipeCleaningCertf;

    @NotBlank
    private Integer oilResidueInspection;

    @NotBlank
    private Integer pressureApproval;

    @NotBlank
    private Integer obstructionCheck;

    @NotBlank
    private Integer complianceWithDrawings;

    @NotBlank
    private Integer propeInstallationCheck;
}
