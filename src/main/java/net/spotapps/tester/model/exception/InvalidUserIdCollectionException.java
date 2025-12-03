package net.spotapps.tester.model.exception;

import java.util.List;

public class InvalidUserIdCollectionException extends BadRequestException {
    public InvalidUserIdCollectionException(final String message, final List<String> userIds) {
        super(String.format(message, String.join(",", userIds)));
    }

}
