package com.mindlink.services;

import com.mindlink.models.dtos.postdtos.PostCreateDto;
import com.mindlink.models.dtos.postdtos.PostGetDto;
import com.mindlink.models.dtos.postdtos.PostUpdateDto;

import java.util.List;

public interface PostService {
    PostGetDto createPost(PostCreateDto postDto);
    PostGetDto updatePost(Long postId, PostUpdateDto postDto);
    void deletePost(Long postId);
    List<PostGetDto> getAllPosts();
    PostGetDto getPostById(Long postId);
}
