package com.Blog.BlogApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Contant;
    private Date createdAt;
    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "post-Id",nullable = false)
    private Post post;

}
