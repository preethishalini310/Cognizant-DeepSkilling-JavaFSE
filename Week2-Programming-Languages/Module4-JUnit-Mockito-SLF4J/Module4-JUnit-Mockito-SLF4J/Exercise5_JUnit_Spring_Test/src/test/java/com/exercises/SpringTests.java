package com.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Exercise 1: Basic Unit Test for CalculatorService
class CalculatorServiceTest {
    @Test
    void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        Assertions.assertEquals(5, calculatorService.add(2, 3));
    }
}

// Exercise 3 & 5 & 8: Testing REST Controller with MockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    // Exercise 3: GET endpoint
    @Test
    void testGetUser() throws Exception {
        User user = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(user);
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    // Exercise 5: POST endpoint
    @Test
    void testCreateUser() throws Exception {
        User user = new User(1L, "Bob");
        when(userService.saveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bob"));
    }

    // Exercise 6: Exception handling
    @Test
    void testGetUser_notFound() throws Exception {
        when(userService.getUserById(99L)).thenThrow(new NoSuchElementException());
        mockMvc.perform(get("/users/99"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }

    // Exercise 9: Parameterized Test
    @ParameterizedTest
    @CsvSource({"1, Alice", "2, Bob", "3, Charlie"})
    void testGetUserParameterized(Long id, String name) throws Exception {
        User user = new User(id, name);
        when(userService.getUserById(id)).thenReturn(user);
        mockMvc.perform(get("/users/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));
    }
}
