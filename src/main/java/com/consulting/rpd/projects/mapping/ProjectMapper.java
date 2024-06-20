package com.consulting.rpd.projects.mapping;

import com.consulting.rpd.projects.domain.model.Project;
import com.consulting.rpd.projects.resource.CreateProjectForClientResource;
import com.consulting.rpd.projects.resource.CreateProjectResource;
import com.consulting.rpd.projects.resource.ProjectResource;
import com.consulting.rpd.projects.resource.UpdateProjectResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectMapper{
    @Autowired
    private EnhancedModelMapper mapper;

    public ProjectResource toResource(Project model) {
        return mapper.map(model, ProjectResource.class);
    }

    public Project toModel(CreateProjectResource resource) {
        return mapper.map(resource, Project.class);
    }

    public Project toModel(UpdateProjectResource resource) {
        return mapper.map(resource, Project.class);
    }

    public Project toModel(CreateProjectForClientResource resource) {
        return mapper.map(resource, Project.class);
    }

    public Page<ProjectResource> modelListPage(List<Project> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProjectResource.class), pageable, modelList.size());
    }
}
