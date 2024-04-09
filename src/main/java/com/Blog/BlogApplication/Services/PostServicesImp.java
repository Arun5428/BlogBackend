package com.Blog.BlogApplication.Services;

import com.Blog.BlogApplication.Repository.PostRepo;
import com.Blog.BlogApplication.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServicesImp implements PostServices{
    @Autowired
    private PostRepo postRepo;

    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepo.save(post);

    }

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }



    public Post  getById(long id){
        Optional<Post> op=postRepo.findById(id);
        if(op.isPresent()){
            Post post=op.get();
            post.setViewCount(post.getViewCount()+1);
            return postRepo.save(post);
        }else{
            throw new EntityNotFoundException();
        }
    }

    public void likePost(long postId){
        Optional<Post> op=postRepo.findById(postId);
        if(op.isPresent()){

            Post post=op.get();
            post.setLikeCount(post.getLikeCount()+1);

            postRepo.save(post);
        }else{
            throw new EntityNotFoundException("post not found "+postId);
        }
    }

    public List<Post> searchPost(String name){
        return postRepo.findAllByNameContaining(name);
    }
}
