package com.consulting.rpd.profiling.resource;

import com.consulting.rpd.profiling.domain.model.Role;
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
    private Role role;
}
