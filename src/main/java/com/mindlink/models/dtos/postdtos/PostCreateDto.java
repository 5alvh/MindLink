package com.mindlink.models.dtos.postdtos;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 10, message = "title > 10 characters")
    private String title;

    @Lob
    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be greater than 0")
    private Long userId;

}
