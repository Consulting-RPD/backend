package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.Comment;
import com.consulting.rpd.protocols.domain.persistance.CommentRepository;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.CommentService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private static final String ENTITY = "Comment";

    private final CommentRepository commentRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Comment create(Long protocolId, Comment comment) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(comment);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    comment.setProtocolHeader(protocolHeader);
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header", protocolId));
    }
}
