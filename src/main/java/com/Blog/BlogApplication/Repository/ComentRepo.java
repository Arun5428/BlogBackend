package com.Blog.BlogApplication.Repository;

import com.Blog.BlogApplication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentRepo extends JpaRepository<Comment,Long> {

    List<Comment>findByPostId(long postId);
}
