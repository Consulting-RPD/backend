package com.consulting.rpd.profiling.domain.persistance;

import com.consulting.rpd.profiling.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Optional<Role> findByName(String name);
    Optional<Role> findByProfileId(Long profileId);
}
