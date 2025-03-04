package com.test.blog.controller;

import com.test.blog.dtos.PostDTO;
import com.test.blog.dtos.PostResponse;
import com.test.blog.entity.Post;
import com.test.blog.service.PostService;
import com.test.blog.utils.AppConstants;
import jakarta.validation.Valid;
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
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO dto) {
        return new ResponseEntity<>(service.createpost(dto), HttpStatus.CREATED);
    }

    //http://localhost:8088/api/posts
    //http://localhost:8088/api/posts?pageNo=0
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4&sortBy=id
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4&sortBy=id&sortDir=desc
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    //http://localhost:8088/api/posts/1
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPostById(id));
    }

    //http://localhost:8088/api/posts/7
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable("id") Long id,@Valid @RequestBody PostDTO post) {
        return ResponseEntity.ok(service.updatePost(id, post));
    }

    //http://localhost:8088/api/posts/7
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deletePost(id));
    }
}
