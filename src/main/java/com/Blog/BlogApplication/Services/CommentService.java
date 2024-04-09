package com.Blog.BlogApplication.Services;

import com.Blog.BlogApplication.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment createComment(long postId, String postedBy, String contant);
    List<Comment> getCommentsById(long postId);
}
