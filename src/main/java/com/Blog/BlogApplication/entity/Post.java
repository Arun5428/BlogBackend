package com.Blog.BlogApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(length = 5000)
    private String contant;
    private String postedBy;
    private String image;
    private Date date;
    private int LikeCount;
    private int viewCount;
    private List<String> tags;


}
