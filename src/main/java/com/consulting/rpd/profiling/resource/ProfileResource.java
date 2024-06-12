package com.consulting.rpd.profiling.resource;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileResource {
    private Long id;
    private String firstName;
    private String lastName;
    private RoleResource role;
}
