package com.mindlink.exceptions.commentExceptions;

public class CommentNotFoundException extends RuntimeException {

    private long commentId;

    public CommentNotFoundException(long commentId) {
        super("Comment not found with ID: "+commentId);
    }

    public long getCommentId() {
        return commentId;
    }
}