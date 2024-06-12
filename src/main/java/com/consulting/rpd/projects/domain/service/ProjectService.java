package com.consulting.rpd.projects.domain.service;

import com.consulting.rpd.projects.domain.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    List<Project> getAllByProjectId(Long projectId);
    Page<Project> getAll(Long projectId, Pageable pageable);
    Project getById(Long projectId);
    Project create(Project project);
    Project update(Long projectId,Project project);
    ResponseEntity<?> delete(Long projectId);
}