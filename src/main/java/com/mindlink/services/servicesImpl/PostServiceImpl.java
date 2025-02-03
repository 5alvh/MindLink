package com.mindlink.services.servicesImpl;

import com.mindlink.exceptions.UserNotFoundException;
import com.mindlink.exceptions.postExceptions.PostDeletionException;
import com.mindlink.exceptions.postExceptions.PostNotFoundException;
import com.mindlink.exceptions.postExceptions.PostUpdateException;
import com.mindlink.models.Post;
import com.mindlink.models.User;
import com.mindlink.models.dtos.postdtos.PostCreateDto;
import com.mindlink.models.dtos.postdtos.PostGetDto;
import com.mindlink.models.dtos.postdtos.PostUpdateDto;
import com.mindlink.repositories.PostRepository;
import com.mindlink.repositories.UserRepository;
import com.mindlink.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private PostGetDto toPostGetDto(Post post) {
        PostGetDto dto = new PostGetDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCategoria(post.getCategoria());
        return dto;
    }

    private List<PostGetDto> toPostGetDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::toPostGetDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostGetDto createPost(PostCreateDto post) {
        User user = userRepository.findById(post.getUserId())
                .orElseThrow(() -> new UserNotFoundException(post.getUserId()));

        Post pst = new Post();
        pst.setTitle(post.getTitle());
        pst.setContent(post.getContent());
        pst.setFechaCreacion(LocalDateTime.now());
        pst.setCategoria(post.getCategory());
        pst.setUser(user);

        return toPostGetDto(postRepository.save(pst));
    }

    @Override
    public PostGetDto updatePost(Long postId, PostUpdateDto post) {
        Optional<Post> postToUpdateOpt = postRepository.findById(postId);
        if (postToUpdateOpt.isPresent()) {
            Post postToUpdate = postToUpdateOpt.get();
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setFechaActualizacion(LocalDateTime.now());
            postToUpdate.setContent(post.getContent());
            postToUpdate.setCategoria(post.getCategory());
            return toPostGetDto(postRepository.save(postToUpdate));
        }else{
            throw new PostUpdateException(postId);
        }

    }

    @Override
    public void deletePost(Long postId) {
        if(!postRepository.existsById(postId)){
            throw new PostDeletionException(postId);
        }
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostGetDto> getAllPosts() {
        return toPostGetDtoList(postRepository.findAll());
    }

    @Override
    public PostGetDto getPostById(Long postId) {
        return postRepository.findById(postId)
                .map(this::toPostGetDto)
                .orElseThrow(()-> new PostNotFoundException(postId));
    }
}
