package net.spotapps.tester.model.exception;

import java.util.IllegalFormatException;

import net.spotapps.tester.UserProfileConstants;

public class InvalidUserIdException extends BadRequestException {
    public InvalidUserIdException(final String message, final String userId) {
        super(formatMessage(message, userId));
    }

    private static String formatMessage(final String messageTemplate, final String userId) {
        String message;
        try {
            message = String.format(messageTemplate, userId);
        } catch (IllegalFormatException e) {
            message = UserProfileConstants.GENERIC_EXCEPTION_MESSAGE;
        }
        return message;
    }
}