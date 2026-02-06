package org.example.quoraspringboot.controllers;

import lombok.RequiredArgsConstructor;
import org.example.quoraspringboot.dtos.CommentDTO;
import org.example.quoraspringboot.models.Comment;
import org.example.quoraspringboot.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/answer/{answerId}")
    public List<Comment> getCommentsByAnswerId(@PathVariable Long answerId, @PathVariable int page, @PathVariable int size) {
        return commentService.getCommentsByAnswerId(answerId, page, size);
    }

    @GetMapping("/comment/{commentId}")
    public List<Comment> getRepliesByCommentId(@PathVariable Long commentId, @PathVariable int page, @PathVariable int size) {
        return commentService.getRepliesByCommentId(commentId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    };

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO) {
        Comment createdComment = commentService.createComment(commentDTO);
        return ResponseEntity.ok(createdComment);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    };
}
