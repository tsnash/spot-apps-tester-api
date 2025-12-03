package net.spotapps.tester.model.exception;

import java.util.List;

public class UserProfileCollectionNotFoundException extends NotFoundException {
    public UserProfileCollectionNotFoundException(final String message, final List<String> userIds) {
        super(String.format(message, String.join(",", userIds)));
    }

}
