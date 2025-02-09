package com.test.blog.service;

import com.test.blog.dtos.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    PostDTO createpost(PostDTO dto);
    List<PostDTO> getAllPosts();
}
