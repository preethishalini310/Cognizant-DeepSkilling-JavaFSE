package com.exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Exercise 4: AAA Pattern + @Before/@After
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
        userService.addUser("existingUser");
    }

    @After
    public void tearDown() {
        userService.clear();
        userService = null;
    }

    @Test
    public void testAddUser_withValidName_returnsTrue() {
        // Arrange
        String newUsername = "alice";
        // Act
        boolean result = userService.addUser(newUsername);
        // Assert
        assertTrue(result);
        assertTrue(userService.userExists(newUsername));
    }

    @Test
    public void testAddUser_withNullName_returnsFalse() {
        // Arrange
        String invalidUsername = null;
        // Act
        boolean result = userService.addUser(invalidUsername);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testRemoveUser_existingUser_removesSuccessfully() {
        // Arrange
        String usernameToRemove = "existingUser";
        // Act
        boolean removed = userService.removeUser(usernameToRemove);
        // Assert
        assertTrue(removed);
        assertFalse(userService.userExists(usernameToRemove));
    }
}
