package com.example.springboot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggableException extends Exception {
    private static final Logger logger = Logger.getLogger(LoggableException.class.getName());

    public LoggableException(String message) {
        super(message);
        logException();
    }

    public LoggableException(String message, Throwable cause) {
        super(message, cause);
        logException();
    }

    private void logException() {
        // Log the exception message and stack trace
        logger.log(Level.SEVERE, this.getMessage(), this);
    }
}