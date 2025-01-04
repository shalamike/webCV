package com.taskexpert.taskexpert.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "groups", schema = "todos")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return getId().equals(group.getId()) && getName().equals(group.getName()) && getCreatedAt().equals(group.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreatedAt());
    }
}
