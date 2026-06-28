package com.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

// Exercise 5: Timeout and Performance Testing
public class PerformanceTesterTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testPerformTask() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}
