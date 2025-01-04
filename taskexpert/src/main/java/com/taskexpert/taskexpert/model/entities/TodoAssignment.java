package com.taskexpert.taskexpert.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "todo_assignments", schema = "todos")
public class TodoAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime assignedAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Todo getTodo() {
        return todo;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoAssignment that)) return false;
        return getId().equals(that.getId()) && getTodo().equals(that.getTodo()) && getUser().equals(that.getUser()) && getAssignedAt().equals(that.getAssignedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTodo(), getUser(), getAssignedAt());
    }
}
