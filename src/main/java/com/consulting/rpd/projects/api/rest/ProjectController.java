package com.consulting.rpd.projects.api.rest;

import com.consulting.rpd.projects.domain.model.Project;
import com.consulting.rpd.projects.domain.service.ProjectService;
import com.consulting.rpd.projects.mapping.ProjectMapper;
import com.consulting.rpd.projects.resource.CreateProjectForClientResource;
import com.consulting.rpd.projects.resource.CreateProjectResource;
import com.consulting.rpd.projects.resource.ProjectResource;
import com.consulting.rpd.projects.resource.UpdateProjectResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/projects/project", produces = "application/json")
@Tag(name = "Projects", description = "Create and read projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper mapper;

    @Operation(summary = "Get all projects")
    @GetMapping
    public Page<ProjectResource> getAllProjects(Pageable pageable) {
        return mapper.modelListPage(projectService.getAll(), pageable);
    }

    @Operation(summary = "Get project by ID")
    @GetMapping("{projectId}")
    public ProjectResource getProjectById(@PathVariable Long projectId) {
        return mapper.toResource(projectService.getById(projectId));
    }

    @Operation(summary = "Get projects by client ID")
    @GetMapping("/client/{clientId}")
    public List<Project> getProjectsByClientId(@PathVariable Long clientId) {
        return projectService.getAllByClientId(clientId);
    }
    /* @Operation(summary = "Create project", responses = {
            @ApiResponse(
                    description = "Project succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjectResource.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<ProjectResource> createProject(@RequestBody CreateProjectResource resource) {
        return new ResponseEntity<>(mapper.toResource(projectService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @Operation(summary = "Update project", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Project successfully udpated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjectResource.class)
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
    } */

    @Operation(summary = "Create project for a specific client", responses = {
            @ApiResponse(
                    description = "Project successfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjectResource.class)
                    )
            )
    })
    @PostMapping("/{clientId}")
    public ResponseEntity<ProjectResource> createProjectForClient(@PathVariable Long clientId, @RequestBody CreateProjectForClientResource resource) {
        return new ResponseEntity<>(mapper.toResource(projectService.createForClient(clientId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
