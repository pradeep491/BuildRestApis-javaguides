package com.test.blog.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDTO {
    private Long id;
    //title should not be empty or null
    //title should have at least 2 characters
    @NotEmpty
    @Size(min=2,message = "post title should have at least 2 characters")
    private String title;

    //description should not be null or empty
    //should have at least 10 characters
    @NotEmpty
    //@Size(min=10,message = "post description should have at least 10 characters")
    private String description;

    //content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDTO> comments;

    private Long categoryId;

}
