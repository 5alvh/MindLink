package com.mindlink.services.servicesImpl;

import com.mindlink.exceptions.UserNotFoundException;
import com.mindlink.exceptions.commentExceptions.CommentDeletionException;
import com.mindlink.exceptions.commentExceptions.CommentNotFoundException;
import com.mindlink.exceptions.postExceptions.PostNotFoundException;
import com.mindlink.models.Comment;
import com.mindlink.models.Post;
import com.mindlink.models.User;
import com.mindlink.models.dtos.commentdtos.CommentCreateDto;
import com.mindlink.models.dtos.commentdtos.CommentGetDto;
import com.mindlink.models.dtos.commentdtos.CommentUpdateDto;
import com.mindlink.repositories.CommentRepository;
import com.mindlink.repositories.PostRepository;
import com.mindlink.repositories.UserRepository;
import com.mindlink.services.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private CommentGetDto toCommentGetDto(Comment comment) {
        CommentGetDto dto = new CommentGetDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        return dto;
    }

    private List<CommentGetDto> toCommentGetDtoList(List<Comment> comments) {
        return comments.stream()
                .map(this::toCommentGetDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CommentGetDto createComment(CommentCreateDto commentDto) {

        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentDto.getPostId()));

        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(commentDto.getUserId()));

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);
        comment.setUser(user);
        comment.setFechaCreacion(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);
        return toCommentGetDto(savedComment);
    }

    @Override
    public CommentGetDto getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(this::toCommentGetDto)
                .orElseThrow(() -> new CommentNotFoundException(id));
    }

    @Override
    public List<CommentGetDto> getAllComments() {
        return toCommentGetDtoList(commentRepository.findAll());
    }

    @Transactional
    @Override
    public CommentGetDto updateComment(Long id, CommentUpdateDto commentDto) {

        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentDto.getPostId()));

        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(commentDto.getUserId()));

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));

        comment.setContent(commentDto.getContent());

        Comment updatedComment = commentRepository.save(comment);

        return toCommentGetDto(updatedComment);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new CommentDeletionException(id);
        }
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentGetDto> getCommentsByPostId(Long postId) {
        return toCommentGetDtoList(commentRepository.findByPostId(postId));
    }
}
