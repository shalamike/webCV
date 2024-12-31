package com.taskexpert.taskexpert.model.repositories;
import com.taskexpert.taskexpert.model.entities.Todo;
import com.taskexpert.taskexpert.model.entities.TodoDependency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoDependencyRepository extends JpaRepository<TodoDependency, Long> {

    // Find all dependencies for a specific to-do
    List<TodoDependency> findByTodo(Todo todo);

    // Find all todos that depend on a specific to-do
    List<TodoDependency> findByDependsOnTodo(Todo dependsOnTodo);
}
