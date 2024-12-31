package com.taskexpert.taskexpert.model.repositories;

import com.taskexpert.taskexpert.model.entities.Group;
import com.taskexpert.taskexpert.model.entities.GroupMembership;
import com.taskexpert.taskexpert.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {

    // Find memberships by user
    List<GroupMembership> findByUser(User user);

    // Find memberships by group
    List<GroupMembership> findByGroup(Group group);

    // Find a specific membership
    GroupMembership findByUserAndGroup(User user, Group group);
}
