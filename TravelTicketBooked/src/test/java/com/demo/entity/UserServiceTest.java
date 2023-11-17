package com.demo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.repository.UserRepository;
import com.demo.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void saveUser_Success() {
        // Arrange
        User userToSave = new User();
        userToSave.setId(1L);
        userToSave.setUsername("testUser");
        userToSave.setEmail("test@example.com");
        userToSave.setPassword("testPassword");

        // Mocking the behavior of the repository's save method
        when(userRepository.save(any(User.class))).thenReturn(userToSave);

        // Act
        User savedUser = userService.saveUser(userToSave);

        // Assert
        assertNotNull(savedUser);
        assertEquals(1L, savedUser.getId());
        assertEquals("testUser", savedUser.getUsername());
        assertEquals("test@example.com", savedUser.getEmail());
        assertEquals("testPassword", savedUser.getPassword());

        // Verify that the save method of the repository was called
        verify(userRepository, times(1)).save(any(User.class));
    }
}