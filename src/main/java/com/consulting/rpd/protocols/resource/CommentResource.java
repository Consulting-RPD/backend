package com.consulting.rpd.protocols.resource;

import java.util.Date;

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
public class CommentResource {
    private Long commentId;
    private String comment;
    private Date date;
    private Integer triggersConected;
}
