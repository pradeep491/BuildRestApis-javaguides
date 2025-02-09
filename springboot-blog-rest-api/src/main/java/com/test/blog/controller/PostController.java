package com.test.blog.controller;

import com.test.blog.dtos.PostDTO;
import com.test.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
    //http://localhost:8088/api/posts
    //create blog post Rest API
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO dto) {
        return new ResponseEntity<>(service.createpost(dto), HttpStatus.CREATED);
    }
    //http://localhost:8088/api/posts
    @GetMapping
    public List<PostDTO> getAllPosts(){
        return service.getAllPosts();
    }
}
