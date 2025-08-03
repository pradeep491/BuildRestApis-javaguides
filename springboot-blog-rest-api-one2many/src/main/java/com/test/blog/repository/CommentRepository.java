package com.test.blog.repository;

import com.test.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //@Query()
    List<Comment> findByPostId(Long postId);
}
