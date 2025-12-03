package net.spotapps.tester.model.exception;

public class InvalidUserIdException extends BadRequestException {
    public InvalidUserIdException(final String message, final String userId) {
        super(String.format(message, userId));
    }
}