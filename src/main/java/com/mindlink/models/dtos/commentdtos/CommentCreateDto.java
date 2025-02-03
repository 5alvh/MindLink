package com.mindlink.models.dtos.commentdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDto {

    @NotBlank(message = "Content cannot be blank.")
    @Size(max = 500, message = "Content must not exceed 500 characters")
    private String content;

    @NotNull(message = "Post ID is required")
    @Positive(message = "Post ID must be greater than 0")
    private Long postId;

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be greater than 0")
    private Long userId;

}