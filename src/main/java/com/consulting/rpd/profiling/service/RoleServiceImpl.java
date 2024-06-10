package com.consulting.rpd.profiling.service;

import com.consulting.rpd.profiling.domain.model.Role;
import com.consulting.rpd.profiling.domain.persistance.RoleRepository;
import com.consulting.rpd.profiling.domain.service.RoleService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    public static final String ENTITY = "Role";

    private final RoleRepository roleRepository;
    private final Validator validator;

    public RoleServiceImpl(RoleRepository roleRepository, Validator validator) {
        this.roleRepository = roleRepository;
        this.validator = validator;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> getAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role getById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, roleId));
    }

    @Override
    public Role create(Role role) {
        Set<ConstraintViolation<Role>> violations = validator.validate(role);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if (roleRepository.findByName(role.getName()).isPresent())
            throw new ResourceValidationException(ENTITY, "A role with the same name already exists");

        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Set<ConstraintViolation<Role>> violations = validator.validate(role);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Optional<Role> roleWithName = roleRepository.findByName(role.getName());

        if (roleWithName.isPresent() && !roleWithName.get().getId().equals(role.getId()))
            throw new ResourceValidationException(ENTITY, "A role with the same name already exists");

        return roleRepository.findById(id)
                .map(roleToUpdate -> roleRepository.save(roleToUpdate.withName(role.getName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long roleId) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    roleRepository.delete(role);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, roleId));
    }
}
