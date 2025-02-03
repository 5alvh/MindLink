package com.mindlink.services.servicesImpl;

import com.mindlink.exceptions.UserNotFoundException;
import com.mindlink.exceptions.postExceptions.PostNotFoundException;
import com.mindlink.models.Like;
import com.mindlink.models.Post;
import com.mindlink.models.User;
import com.mindlink.models.dtos.likedtos.LikeCreateDto;
import com.mindlink.models.dtos.likedtos.LikeGetDto;
import com.mindlink.repositories.LikeRepository;
import com.mindlink.repositories.PostRepository;
import com.mindlink.repositories.UserRepository;
import com.mindlink.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void likePost(LikeCreateDto likeCreateDto) {

        if (likeRepository.existsByPostIdAndUserId(likeCreateDto.getPostId(), likeCreateDto.getUserId())) {
            likeRepository.deleteByPostIdAndUserId(likeCreateDto.getPostId(), likeCreateDto.getUserId());
        }

        Post post = postRepository.findById(likeCreateDto.getPostId())
                .orElseThrow(()-> new PostNotFoundException(likeCreateDto.getPostId()));

        User user = userRepository.findById(likeCreateDto.getUserId())
                .orElseThrow(()-> new UserNotFoundException(likeCreateDto.getUserId()));

        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        like.setLikedAt(LocalDateTime.now());
        Like savedLike = likeRepository.save(like);

    }


    @Override
    public List<LikeGetDto> getLikesForPost(Long postId) {

        if (!postRepository.existsById(postId)){
            throw new PostNotFoundException(postId);
        }

        return likeRepository.findAll().stream()
                .filter(like -> like.getPost().getId().equals(postId))
                .map(like -> new LikeGetDto(
                        like.getId(),
                        like.getLikedAt(),
                        like.getPost().getId(),
                        like.getUser().getId()
                ))
                .collect(Collectors.toList());
    }
}
