package com.Blog.BlogApplication.Services;


import com.Blog.BlogApplication.Repository.ComentRepo;
import com.Blog.BlogApplication.Repository.PostRepo;
import com.Blog.BlogApplication.entity.Comment;
import com.Blog.BlogApplication.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServcesImp implements CommentService  {
    @Autowired
    private ComentRepo  comentRepo;
    @Autowired
    private PostRepo postRepo;
    public Comment createComment(long postId,String postedBy,String contant){
        Optional<Post> optionalPost=postRepo.findById(postId);
        if(optionalPost.isPresent()){
            Comment comment=new Comment();
            comment.setPost(optionalPost.get());
            comment.setContant(contant);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            return comentRepo.save(comment);



        }
        throw new EntityNotFoundException("Post not found");
    }

    public List<Comment> getCommentsById(long postId){
        return comentRepo.findByPostId(postId);
    }
}
