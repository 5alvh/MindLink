package com.mindlink.exceptions.postExceptions;

public class PostNotFoundException extends RuntimeException {
    private Long postId;

    public PostNotFoundException(Long postId) {
        super("Post not found with ID: " + postId);
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}