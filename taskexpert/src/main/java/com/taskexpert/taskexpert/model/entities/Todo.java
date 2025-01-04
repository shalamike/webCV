package com.taskexpert.taskexpert.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "todos", schema = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "completed_by")
    private User completedBy;

    private LocalDateTime completedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public User getCompletedBy() {
        return completedBy;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return isCompleted() == todo.isCompleted() && getId().equals(todo.getId()) && getTitle().equals(todo.getTitle()) && getDescription().equals(todo.getDescription()) && getUser().equals(todo.getUser()) && getGroup().equals(todo.getGroup()) && getCompletedBy().equals(todo.getCompletedBy()) && getCompletedAt().equals(todo.getCompletedAt()) && getCreatedAt().equals(todo.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getUser(), getGroup(), isCompleted(), getCompletedBy(), getCompletedAt(), getCreatedAt());
    }
}
