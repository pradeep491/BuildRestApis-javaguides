package com.test.blog.service;

import com.test.blog.dtos.PostDTO;
import org.springframework.stereotype.Service;


public interface PostService {
    PostDTO createpost(PostDTO dto);
}
