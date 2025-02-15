package com.test.blog.service;

import com.test.blog.dtos.PostDTO;
import com.test.blog.dtos.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    PostDTO createpost(PostDTO dto);
    PostResponse getAllPosts(int pageNo, int pageSize);
    PostDTO getPostById(Long id);
    PostDTO updatePost(Long id,PostDTO dto);
    String deletePost(Long id);
}
