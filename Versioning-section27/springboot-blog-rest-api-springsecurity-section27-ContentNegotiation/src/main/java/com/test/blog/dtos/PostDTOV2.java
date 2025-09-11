package com.test.blog.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.*;

@Schema(
        description = "PostDTOV2 Model Information"
)
@Data
public class PostDTOV2 {
    private Long id;
    //title should not be empty or null
    //title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "post title should have at least 2 characters")
    @Schema(
            description = "Blog Post Title"
    )
    private String title;

    //description should not be null or empty
    //should have at least 10 characters
    @NotEmpty
    //@Size(min=10,message = "post description should have at least 10 characters")
    @Schema(
            description = "Blog Post Description"
    )
    private String description;

    //content should not be null or empty
    @NotEmpty
    @Schema(
            description = "Blog Post Content"
    )
    private String content;
    private Set<CommentDTO> comments;

    @Schema(
            description = "Blog Post Category ID"
    )
    private Long categoryId;

    private List<String> tags;

}
