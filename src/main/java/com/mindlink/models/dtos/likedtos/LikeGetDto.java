package com.mindlink.models.dtos.likedtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeGetDto {
    private Long id;
    private LocalDateTime likedAt;
    private Long postId;
    private Long userId;
}