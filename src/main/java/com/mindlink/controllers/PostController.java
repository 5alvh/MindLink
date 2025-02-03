package com.mindlink.controllers;

import com.mindlink.models.dtos.postdtos.PostCreateDto;
import com.mindlink.models.dtos.postdtos.PostGetDto;
import com.mindlink.models.dtos.postdtos.PostUpdateDto;
import com.mindlink.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public ResponseEntity<PostGetDto> createPost(@Valid @RequestBody PostCreateDto postDto) {
        PostGetDto createdPost = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostGetDto>> getAllPosts() {
        List<PostGetDto> posts = postService.getAllPosts();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostGetDto> getPostById(@PathVariable Long id) {
        PostGetDto post = postService.getPostById(id);
        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostGetDto> updatePost(@PathVariable Long postId, @Valid @RequestBody PostUpdateDto postDto) {
        PostGetDto updatedPost = postService.updatePost(postId, postDto);
        return ResponseEntity.ok().body(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}


