package com.consulting.rpd.projects.domain.persistance;

import com.consulting.rpd.projects.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
   List<Project> findByClientId(Long clientId);
   //List<Project> findByProjectId(Long projectId);
   //Page<Project> findByClientId(Long clientId, Pageable pageable);
}
