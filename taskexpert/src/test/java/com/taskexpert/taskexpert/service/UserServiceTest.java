package com.taskexpert.taskexpert.service;

import com.taskexpert.taskexpert.model.entities.User;
import com.taskexpert.taskexpert.model.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void initialiseMocks(){
        User mockUser1 = mock(User.class);
        String mock1Email = "mock1@fakemail.com";
        String mock1Username = "MockitoUserOne";

        when(mockUser1.getEmail()).thenReturn(mock1Email);
        when(mockUser1.getUsername()).thenReturn(mock1Username);


        //mock repository behaviour
        when(userRepository.findByUsername(mock1Username)).thenReturn(Optional.of(mockUser1));
        when(userRepository.findByEmail(mock1Email)).thenReturn(Optional.of(mockUser1));
    }

    @Test
    public void TestUserIsPresent(){
        Optional<User> mockitoUserOne = userService.findByUsername("MockitoUserOne");

        Assertions.assertTrue(mockitoUserOne.isPresent());
    }

    @Test
    public void testGetUserByUserName(){
        Optional<User> result = userService.findByUsername("MockitoUserOne");

        assertEquals("mock1@fakemail.com", result.get().getEmail());
    }

    @Test
    public void testGetUserByEmail(){
        Optional<User> result = userService.findByEmail("mock1@fakemail.com");

        assertEquals("MockitoUserOne", result.get().getUsername());
    }

}
