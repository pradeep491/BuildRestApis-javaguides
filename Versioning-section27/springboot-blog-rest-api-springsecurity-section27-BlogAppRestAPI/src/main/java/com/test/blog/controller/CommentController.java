package com.test.blog.controller;

import com.test.blog.dtos.CommentDTO;
import com.test.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8088/api/posts/21/comments
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") Long id,
                                                    @Valid @RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.createComment(id, dto), HttpStatus.CREATED);
    }

    //http://localhost:8088/api/posts/21/comments
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "postId")
                                                long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    //http://localhost:8088/api/posts/21/comments/1
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "commentId") long commentId) {
        CommentDTO commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    //http://localhost:8088/api/posts/21/comments/1
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateCommentById(@PathVariable(value = "postId") long postId,
                                                        @PathVariable(value = "commentId") long commentId,
                                                        @Valid @RequestBody CommentDTO dto) {
        CommentDTO updatedDto = commentService.updateCommentById(postId, commentId, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    //http://localhost:8088/api/posts/21/comments/1
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "commentId") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully...!", HttpStatus.OK);
    }

}
