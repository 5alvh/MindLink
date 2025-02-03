package com.mindlink.services;

import com.mindlink.models.dtos.likedtos.LikeCreateDto;
import com.mindlink.models.dtos.likedtos.LikeGetDto;

import java.util.List;

public interface LikeService {
    void likePost(LikeCreateDto likeCreateDto);
    List<LikeGetDto> getLikesForPost(Long postId);
}
