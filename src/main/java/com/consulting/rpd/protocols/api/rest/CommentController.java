package com.consulting.rpd.protocols.api.rest;

import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.Comment;
import com.consulting.rpd.protocols.domain.service.CommentService;
import com.consulting.rpd.protocols.mapping.CommentMapper;
import com.consulting.rpd.protocols.resource.CommentResource;
import com.consulting.rpd.protocols.resource.CreateCommentResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/comment", produces = "application/json")
@Tag(name = "Comment", description = "Create and read comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper mapper;

    @Operation(summary = "Get comment by ID")
    @GetMapping("{commentId}")
    public CommentResource getCommentById(@PathVariable Long commentId) {
        return mapper.toResource(commentService.getById(commentId));
    }

    @Operation(summary = "Create comment for a specific protocol", responses = {
        @ApiResponse(
            description = "Comment succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = CreateCommentResource.class)
            )
        )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<CommentResource> createComment(@PathVariable Long protocolHeaderId, @RequestBody CreateCommentResource resource){
        return new ResponseEntity<>(mapper.toResource(commentService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
