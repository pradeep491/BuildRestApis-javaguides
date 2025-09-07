package com.test.blog.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    //Name should not empty or not null
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    //email should not empty or not null
    //email validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    //body should not be null or empty
    //comment body should be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "comment body must be minimum 10 characters")
    private String body;
}
