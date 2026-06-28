package com.exercises;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 3: Test Execution Order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("First test executed");
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Second test executed");
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Third test executed");
        assertNotNull("hello");
    }
}
