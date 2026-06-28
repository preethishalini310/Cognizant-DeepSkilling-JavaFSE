package com.cognizant.ormlearn.service.exception;

/** FILE 1 – Hands-on 6: Custom exception for missing country */
public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
