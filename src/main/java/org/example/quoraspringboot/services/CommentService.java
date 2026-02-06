package org.example.quoraspringboot.services;

import org.example.quoraspringboot.dtos.CommentDTO;
import org.example.quoraspringboot.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getCommentsByAnswerId(Long answerId, int page, int size);
    List<Comment> getRepliesByCommentId(Long commentId, int page, int size);
    Optional<Comment> getCommentById(Long id);
    Comment createComment(CommentDTO commentDTO);
    void deleteComment(Long id);
}
