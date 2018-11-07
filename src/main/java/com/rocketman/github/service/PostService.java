package com.rocketman.github.service;

import com.rocketman.github.entity.Post;
import com.rocketman.github.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
}
