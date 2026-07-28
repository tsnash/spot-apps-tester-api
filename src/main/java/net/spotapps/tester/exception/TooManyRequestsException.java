package net.spotapps.tester.exception;

import java.io.Serial;

public class TooManyRequestsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TooManyRequestsException(final String message) {
        super(message);
    }
}