package net.spotapps.tester.model.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(final String message, final String userId) {
        super(String.format(message, userId));
    }
}
