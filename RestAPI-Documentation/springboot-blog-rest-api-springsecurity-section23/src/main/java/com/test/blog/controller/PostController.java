package com.test.blog.controller;

import com.test.blog.dtos.PostDTO;
import com.test.blog.dtos.PostResponse;
import com.test.blog.service.PostService;
import com.test.blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(
        name = "CRUD REST APIs for Post Resource",
        description = "Create Post, Update Post, Get All Posts, Get Post By Id, Delete Post"
)
public class PostController {

    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    //http://localhost:8088/api/posts
    //create blog post Rest API
    @Operation(
            summary = "Create Post REST API",
            description = "Create Post REST API is used to save post into database"
    )
    @ApiResponse(responseCode = "201",
            description = "HTTP Status 201 CREATED")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO dto) {
        return new ResponseEntity<>(service.createpost(dto), HttpStatus.CREATED);
    }

    //http://localhost:8088/api/posts
    //http://localhost:8088/api/posts?pageNo=0
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4&sortBy=id
    //http://localhost:8088/api/posts?pageNo=0&pageSize=4&sortBy=id&sortDir=desc
    @Operation(
            summary = "Get All Posts REST API",
            description = "Get All Post REST API is used to Fetch all the posts from the database"
    )
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    //http://localhost:8088/api/posts/1
    @Operation(
            summary = "Get Post REST API by id",
            description = "Get Post by ID REST API is used to get single post from the database"
    )
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPostById(id));
    }

    //http://localhost:8088/api/posts/7
    @Operation(
            summary = "update Post REST API",
            description = "Update Post REST API is used to update particular in the database"
    )
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable("id") Long id, @Valid @RequestBody PostDTO post) {
        return ResponseEntity.ok(service.updatePost(id, post));
    }

    //http://localhost:8088/api/posts/7
    @Operation(
            summary = "Delete Post REST",
            description = "Delete Post REST API is used to delete particular post from the database"
    )
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deletePost(id));
    }

    //Build Get Posts by Category REST API
    //http://localhost:8088/api/posts/category/1
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable("id") Long categoryId) {
        return ResponseEntity.ok(service.getPostsByCategory(categoryId));
    }
}
