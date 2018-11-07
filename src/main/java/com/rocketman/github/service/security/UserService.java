package com.rocketman.github.service.security;

import com.rocketman.github.entity.security.User;
import com.rocketman.github.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public User getUser(String username){
        return repo.findByUsername(username).get();
    }
}
