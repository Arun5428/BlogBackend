package com.Blog.BlogApplication.Services;

import com.Blog.BlogApplication.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    Post savePost(Post post);
    List<Post> getAllPost();
    Post getById(long id);;
    void likePost(long postId);
     List<Post> searchPost(String name);
}
