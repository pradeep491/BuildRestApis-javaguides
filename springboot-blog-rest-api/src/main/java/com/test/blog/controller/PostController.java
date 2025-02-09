package com.test.blog.controller;

import com.test.blog.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    
}
