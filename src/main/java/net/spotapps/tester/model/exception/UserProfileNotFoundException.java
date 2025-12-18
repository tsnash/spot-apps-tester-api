package net.spotapps.tester.model.exception;

import java.util.IllegalFormatException;

import net.spotapps.tester.UserProfileConstants;

public class UserProfileNotFoundException extends NotFoundException {
    public UserProfileNotFoundException(final String message, final Long userId) {
        super(formatMessage(message, userId));
    }

    private static String formatMessage(final String messageTemplate, final Long userId) {
        String message;
        try {
            message = String.format(messageTemplate, userId);
        } catch (IllegalFormatException e) {
            message = UserProfileConstants.GENERIC_EXCEPTION_MESSAGE;
        }
        return message;
    }
}
