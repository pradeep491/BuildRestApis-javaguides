package com.test.blog.service.impl;

import com.test.blog.dtos.CommentDTO;
import com.test.blog.dtos.PostResponse;
import com.test.blog.entity.Comment;
import com.test.blog.entity.Post;
import com.test.blog.exception.BlogAPIException;
import com.test.blog.exception.ResourceNotFoundException;
import com.test.blog.repository.CommentRepository;
import com.test.blog.repository.PostRepository;
import com.test.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDTO createComment(Long postId, CommentDTO dto) {
        Comment comment = mapToEntity(dto);

        //Retrieve POST Entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        //set post to comment entity
        comment.setPost(post);

        //save comment entity to the DB
        Comment savedComment = commentRepository.save(comment);
        return mapToDTO(savedComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(Long postId) {
        //retrieve comments by post id
        List<Comment> comments = commentRepository.findByPostId(postId);
        //convert list of comment entities to a list of comment DTO's
        return comments.stream().map(comment -> mapToDTO(comment)).toList();
    }

    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        //Retrieve POST Entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));

        //Retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
        }
        return mapToDTO(comment);
    }

    @Override
    public CommentDTO updateCommentById(Long postId, Long commentId, CommentDTO dto) {
        //Retrieve POST Entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        //Retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
        }
        comment.setName(dto.getName());
        comment.setEmail(dto.getEmail());
        comment.setBody(dto.getBody());

        Comment updatedEntity = commentRepository.save(comment);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        //Retrieve POST Entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        //Retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
        }

        commentRepository.delete(comment);
    }


    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;
    }

    private Comment mapToEntity(CommentDTO commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
}
