package com.consulting.rpd.protocols.resource;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class SignatureResource {
    private Long signatureId;
    private String installerContractor;
    private String signatureName;
    private String signatureRepresentative;
    private Date date;
}
