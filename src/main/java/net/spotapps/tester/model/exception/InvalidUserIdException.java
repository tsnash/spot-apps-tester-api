package net.spotapps.tester.model.exception;

public class InvalidUserIdException extends BadRequestException {
    public InvalidUserIdException(final String message, final String userId) {
        super(formatMessage(message, userId));
    }

    private static String formatMessage(final String message, final String userId) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User IDs cannot be null or empty");
        }
        return String.format(message, userId);
    }
}