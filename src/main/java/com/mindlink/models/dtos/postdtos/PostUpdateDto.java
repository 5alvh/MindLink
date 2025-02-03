package com.mindlink.models.dtos.postdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDto {

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 10, message = "title > 10 characters")
    private String title;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotBlank(message = "Category must not be blank")
    private String category;

}
