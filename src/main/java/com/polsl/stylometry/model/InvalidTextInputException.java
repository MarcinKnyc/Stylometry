package com.polsl.stylometry.model;

/**
 *
 * @author Marcin Knyć
 * @version 0.1
 * Custom exception class
 */
public class InvalidTextInputException extends Throwable {
    public InvalidTextInputException(String errorMessage) {
        super(errorMessage);
    }
}
