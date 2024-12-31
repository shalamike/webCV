package com.taskexpert.taskexpert.model.repositories;
import com.taskexpert.taskexpert.model.entities.Group;
import com.taskexpert.taskexpert.model.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.taskexpert.taskexpert.model.entities.User;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Find todos by user
    List<Todo> findByUser(User user);

    // Find todos by group
    List<Todo> findByGroup(Group group);

    // Find todos by completion status
    List<Todo> findByCompleted(boolean completed);

    // Find todos completed by a specific user
    List<Todo> findByCompletedBy(User user);
}
