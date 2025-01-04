package com.taskexpert.taskexpert.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "todo_dependencies", schema = "todos")
public class TodoDependency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "depends_on_todo_id", nullable = false)
    private Todo dependsOnTodo;

    public Long getId() {
        return id;
    }

    public Todo getTodo() {
        return todo;
    }

    public Todo getDependsOnTodo() {
        return dependsOnTodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoDependency that)) return false;
        return getId().equals(that.getId()) && getTodo().equals(that.getTodo()) && getDependsOnTodo().equals(that.getDependsOnTodo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTodo(), getDependsOnTodo());
    }
}
