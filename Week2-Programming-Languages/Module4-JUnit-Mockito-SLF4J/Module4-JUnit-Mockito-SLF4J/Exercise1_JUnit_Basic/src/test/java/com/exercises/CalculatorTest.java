package com.exercises;

import org.junit.Test;
import static org.junit.Assert.*;

// Exercise 2: Basic JUnit tests for Calculator
public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(5.0, calculator.divide(10.0, 2.0), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        new Calculator().divide(10.0, 0);
    }
}
