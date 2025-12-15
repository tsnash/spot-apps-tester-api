package net.spotapps.tester.model.exception;

public class UserProfileNotFoundException extends NotFoundException {
    public UserProfileNotFoundException(final String message, final Long userId) {
        super(formatMessage(message, userId));
    }

    private static String formatMessage(final String message, final Long userId) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User IDs cannot be null or negative");
        }
        return String.format(message, userId);
    }
}
