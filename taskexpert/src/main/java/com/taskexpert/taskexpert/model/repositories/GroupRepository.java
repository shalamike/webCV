package com.taskexpert.taskexpert.model.repositories;
import com.taskexpert.taskexpert.model.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    // Custom query methods
    Optional<Group> findByName(String name);
}
