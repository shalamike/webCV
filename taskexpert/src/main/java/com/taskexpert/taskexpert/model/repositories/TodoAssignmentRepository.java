package com.taskexpert.taskexpert.model.repositories;
import com.taskexpert.taskexpert.model.entities.Todo;
import com.taskexpert.taskexpert.model.entities.TodoAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskexpert.taskexpert.model.entities.User;

import java.util.List;

public interface TodoAssignmentRepository extends JpaRepository<TodoAssignment, Long> {

    // Find all assignments for a specific to-do
    List<TodoAssignment> findByTodo(Todo todo);

    // Find all assignments for a specific user
    List<TodoAssignment> findByUser(User user);

    // Find an assignment by to-do and user
    TodoAssignment findByTodoAndUser(Todo todo, User user);
}
