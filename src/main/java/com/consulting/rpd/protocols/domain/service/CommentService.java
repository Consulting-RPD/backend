package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.Comment;

public interface CommentService {
    Comment getById(Long commentId);
    Comment create(Long protocolHeaderId,Comment comment);
    //Comment update(Long commentId,Comment comment);
}
