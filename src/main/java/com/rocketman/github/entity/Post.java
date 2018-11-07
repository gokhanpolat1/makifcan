package com.rocketman.github.entity;

import com.rocketman.github.entity.security.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String body;
    private Date createdDate;

    // MANY post can be created by ONE creator
    @ManyToOne
    private User creator;

    public Post() {
    }
}
