package com.rocketman.github.controller;

import com.rocketman.github.config.security.CustomUserDetails;
import com.rocketman.github.entity.Post;
import com.rocketman.github.service.PostService;
import com.rocketman.github.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "ilk sayfa";
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        return postService.getPosts();
    }

    @PostMapping("/publish")
    public String publishPost(@RequestBody Post post) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (post.getCreatedDate() == null) {
            post.setCreatedDate(new Date());
        }
        post.setCreator(userService.getUser(userDetails.getUsername() ));
        postService.insert(post);
        return "post was published ";
    }
}
