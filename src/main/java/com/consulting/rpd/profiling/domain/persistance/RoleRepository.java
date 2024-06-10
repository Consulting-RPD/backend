package com.consulting.rpd.profiling.domain.persistance;

import com.consulting.rpd.profiling.domain.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRoleId(Long roleId);
    Page<Role> findByRoleId(Long roleId, Pageable pageable);
    Optional<Role> findByName(String name);
}
