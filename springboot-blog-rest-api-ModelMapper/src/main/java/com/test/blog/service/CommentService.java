package com.test.blog.service;

import com.test.blog.dtos.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO createComment(Long postId, CommentDTO dto);

    List<CommentDTO> getCommentsByPostId(Long postId);

    CommentDTO getCommentById(Long postId, Long commentId);

    CommentDTO updateCommentById(Long postId, Long commentId, CommentDTO dto);

    void deleteComment(Long postId, Long commentId);
}
