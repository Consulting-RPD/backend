package com.consulting.rpd.protocols.resource;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateSignatureResource {
    @NotBlank
    @NotNull
    @Size(min = 1, max = 80)
    private String installerContractor;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 80)
    private String signatureName;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String signatureRepresentative;

    private Date date;
}
