package com.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 1: Parameterized Tests
public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    public void testIsEven_withEvenNumbers(int number) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    public void testIsEven_withOddNumbers(int number) {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(number));
    }
}
