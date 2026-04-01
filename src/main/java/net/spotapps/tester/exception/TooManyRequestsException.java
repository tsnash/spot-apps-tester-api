package net.spotapps.tester.exception;

public class TooManyRequestsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TooManyRequestsException(final String message) {
        super(message);
    }
}