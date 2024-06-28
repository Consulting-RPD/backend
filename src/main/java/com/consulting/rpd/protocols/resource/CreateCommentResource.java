package com.consulting.rpd.protocols.resource;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateCommentResource {
    @NotNull
    private Date date;

    @Column(nullable = true)
    private Integer triggersConected;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String comments;
}
