package com.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 4: Exception Testing
public class ExceptionThrowerTest {

    @Test
    public void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException());
    }
}
