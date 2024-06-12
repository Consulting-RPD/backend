package com.consulting.rpd.protocols.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProtocolHeaderResource {
    @NotNull
    @NotBlank
    private String protocolNumber;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 25)
    private String protectedArea;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 250)
    private String address;

    @NotNull
    private Integer type;

    @NotNull
    private Date date;

    @NotNull
    @NotBlank
    private Long projectId;
}
