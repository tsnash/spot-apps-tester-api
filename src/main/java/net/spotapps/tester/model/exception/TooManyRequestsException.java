package net.spotapps.tester.model.exception;

public class TooManyRequestsException extends RuntimeException {
    public TooManyRequestsException(final String message) {
        super(message);
    }
}