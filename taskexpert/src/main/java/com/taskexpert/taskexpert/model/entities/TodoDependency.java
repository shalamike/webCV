package com.taskexpert.taskexpert.model.entities;

import jakarta.persistence.*;
import lombok.Data;

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
}
