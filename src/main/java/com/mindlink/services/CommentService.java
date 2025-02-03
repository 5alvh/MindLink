package com.mindlink.services;

import com.mindlink.models.dtos.commentdtos.CommentCreateDto;
import com.mindlink.models.dtos.commentdtos.CommentGetDto;
import com.mindlink.models.dtos.commentdtos.CommentUpdateDto;

import java.util.List;

public interface CommentService {
    CommentGetDto getCommentById(Long id);
    List<CommentGetDto> getAllComments();
    CommentGetDto createComment(CommentCreateDto comment);
    CommentGetDto updateComment(Long id, CommentUpdateDto comment);
    void deleteComment(Long id);
    List<CommentGetDto> getCommentsByPostId(Long postId);
}