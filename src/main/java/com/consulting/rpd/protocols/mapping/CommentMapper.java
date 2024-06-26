package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.Comment;
import com.consulting.rpd.protocols.resource.CommentResource;
import com.consulting.rpd.protocols.resource.CreateCommentResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class CommentMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public CommentResource toResource(Comment model) {
        return mapper.map(model, CommentResource.class);
    }

    public Comment toModel(CreateCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    public Page<CommentResource> modelListPage(List<Comment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CommentResource.class), pageable, modelList.size());
    }
}
