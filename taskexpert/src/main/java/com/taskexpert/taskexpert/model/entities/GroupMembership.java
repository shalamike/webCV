package com.taskexpert.taskexpert.model.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "group_memberships", schema = "todos")
public class GroupMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    private String hierarchy;

    @Column(nullable = false)
    private int rank;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public int getRank() {
        return rank;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupMembership that)) return false;
        return getRank() == that.getRank() && getId().equals(that.getId()) && getUser().equals(that.getUser()) && getGroup().equals(that.getGroup()) && getHierarchy().equals(that.getHierarchy()) && getCreatedAt().equals(that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getGroup(), getHierarchy(), getRank(), getCreatedAt());
    }
}
