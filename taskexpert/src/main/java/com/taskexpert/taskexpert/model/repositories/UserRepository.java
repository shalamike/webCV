package com.taskexpert.taskexpert.model.repositories;

import com.taskexpert.taskexpert.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
