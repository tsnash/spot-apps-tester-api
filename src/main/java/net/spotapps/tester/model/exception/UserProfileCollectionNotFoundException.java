package net.spotapps.tester.model.exception;

import java.util.List;

public class UserProfileCollectionNotFoundException extends NotFoundException {
    public UserProfileCollectionNotFoundException(final String message, final List<String> userIds) {
        super(formatMessage(message, userIds));
    }

    private static String formatMessage(final String message, final List<String> userIds) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        if (userIds == null || userIds.isEmpty()) {
            throw new IllegalArgumentException("User IDs cannot be null or empty");
        }
        return String.format(message, String.join(",", userIds));
    }

}
