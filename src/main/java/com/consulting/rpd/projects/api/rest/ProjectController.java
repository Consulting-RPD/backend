package com.consulting.rpd.projects.api.rest;

import com.consulting.rpd.projects.domain.service.ProjectService;
import com.consulting.rpd.projects.mapping.ProjectMapper;
import com.consulting.rpd.projects.resource.ClientResource;
import com.consulting.rpd.projects.resource.CreateProjectResource;
import com.consulting.rpd.projects.resource.ProjectResource;
import com.consulting.rpd.projects.resource.UpdateProjectResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/projects/project", produces = "application/json")
@Tag(name = "Projects", description = "Create, read, update and delete projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper mapper;

    public ProjectController(ProjectService projectService, ProjectMapper mapper) {
        this.projectService = projectService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all projects")
    @GetMapping
    public Page<ProjectResource> getAllProjects(Pageable pageable) {
        return mapper.modelListPage(projectService.getAll(), pageable);
    }

    @Operation(summary = "Get profile by ID")
    @GetMapping("{projectId}")
    public ProjectResource getProjectById(@PathVariable Long projectId) {
        return mapper.toResource(projectService.getById(projectId));
    }

    @Operation(summary = "Create project", responses = {
            @ApiResponse(
                    description = "Project succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientResource.class)
                    )
            )
    })
    @PostMapping
    public ProjectResource createProject(@RequestBody CreateProjectResource resource) {
        return mapper.toResource(projectService.create(mapper.toModel(resource)));
    }

    @Operation(summary = "Update project", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Project successfully udpated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientResource.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Project not found"
            )
    })
    @PutMapping("{projectId}")
    public ProjectResource updateProject(@PathVariable Long projectId, @RequestBody UpdateProjectResource resource) {
        return mapper.toResource(projectService.update(projectId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete project", responses = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Project successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Project not found"
            )
    })
    @DeleteMapping("{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectService.delete(projectId);
    }
}
