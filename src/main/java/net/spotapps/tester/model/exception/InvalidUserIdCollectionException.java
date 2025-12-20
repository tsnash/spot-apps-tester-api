package net.spotapps.tester.model.exception;

import java.util.IllegalFormatException;
import java.util.List;

import net.spotapps.tester.UserProfileConstants;

public class InvalidUserIdCollectionException extends BadRequestException {
    private static final long serialVersionUID = 1L;
    
    public InvalidUserIdCollectionException(final String message, final List<String> userIds) {
        super(formatMessage(message, userIds));
    }

    private static String formatMessage(final String messageTemplate, final List<String> userIds) {
        if (messageTemplate == null || userIds == null) {
            return UserProfileConstants.GENERIC_EXCEPTION_MESSAGE;
        }
        String message;
        try {
            message = String.format(messageTemplate, String.join(", ", userIds));
        } catch (IllegalFormatException e) {
            message = UserProfileConstants.GENERIC_EXCEPTION_MESSAGE;
        }
        return message;
    }

}
