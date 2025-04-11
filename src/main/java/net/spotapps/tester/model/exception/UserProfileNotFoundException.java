package net.spotapps.tester.model.exception;

public class UserProfileNotFoundException extends RuntimeException {
    public UserProfileNotFoundException(final String message, final Long userId) {
        super(String.format(message, userId));
    }
}
