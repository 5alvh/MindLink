package com.mindlink.exceptions.postExceptions;

public class PostDeletionException extends RuntimeException {

    private Long postId;

    public PostDeletionException(Long postId) {
        super("Failed to delete post with ID: " + postId);
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
