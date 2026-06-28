package com.exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Exercise 1: Logging Error and Warning Messages
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Exercise 1: Error and Warning
        logger.error("This is an error message");
        logger.warn("This is a warning message");

        // Exercise 2: Parameterized Logging
        String userName = "Alice";
        int userId = 42;
        logger.info("User {} with id {} logged in", userName, userId);
        logger.debug("Processing request for user: {}", userName);

        // Exercise 3: Different log levels with appenders
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }
}
