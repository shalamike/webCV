package com.taskexpert.taskexpert.model.entities;


import jakarta.persistence.*;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data //automaticlly generates getters and setters and to string methods for us
@Entity
@Table(name = "users", schema = "todos")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
    // Getters and setters...

