package com.rocketman.github.repository.security;

import com.rocketman.github.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User repository for CRUD operations.
 */
public interface  UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
