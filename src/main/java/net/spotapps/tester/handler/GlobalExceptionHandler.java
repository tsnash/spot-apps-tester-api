package net.spotapps.tester.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import net.spotapps.tester.model.exception.BadRequestException;
import net.spotapps.tester.model.exception.TooManyRequestsException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;
import net.spotapps.tester.model.response.Issue;
import net.spotapps.tester.model.response.Metadata;
import net.spotapps.tester.model.response.UserProfileErrorResponse;
import net.spotapps.tester.model.response.UserProfileResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ApiResponse(
        responseCode = "404", 
        description =  "User profile was not found.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }
    )
    @ExceptionHandler({UserProfileNotFoundException.class})
    protected ResponseEntity<UserProfileResponse> userProfileNotFound(
        HttpServletRequest request, RuntimeException e) {        
        return error(HttpStatus.NOT_FOUND, "User profile was not found.", e);
    }

    @ApiResponse(
        responseCode = "400", 
        description =  "Supplied data was invalid.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }
    )
    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity<UserProfileResponse> userProfilePreconditionFailed(
        HttpServletRequest request, RuntimeException e) {
        Metadata metadata = initializeMetadata();
        Issue issue = new Issue();

        metadata.setStatusCode(HttpStatus.BAD_REQUEST.getReasonPhrase());
        metadata.setStatusDescription("Supplied data was invalid.");
        issue.setMessage(e.getMessage());

        UserProfileErrorResponse response = new UserProfileErrorResponse();
        response.setMetadata(metadata);
        response.setIssues(Collections.singletonList(issue));

        return error(HttpStatus.BAD_REQUEST, "Supplied data was invalid." , e);
    }

    @ApiResponse(
        responseCode = "429", 
        description =  "Too many requests.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })
    @ExceptionHandler(value = {TooManyRequestsException.class})
    protected ResponseEntity<UserProfileResponse> tooManyRequests(
        HttpServletRequest request, RuntimeException e) {

        return error(HttpStatus.TOO_MANY_REQUESTS, 
            "The user has sent too many requests in a given amount of time.", e);
    }

    private Metadata initializeMetadata() {
        Metadata metadata = new Metadata();
        metadata.setServiceName("User Profile Service");
        return metadata;
    }

    private ResponseEntity<UserProfileResponse> error(HttpStatus status, String description, RuntimeException exception) {
        Metadata metadata = initializeMetadata();
        metadata.setStatusCode(status.getReasonPhrase());
        metadata.setStatusDescription(description);
        Issue issue = new Issue();
        //TODO: generate correlation ID and log it with the exception message
        //TODO: replace with generic message that contains generated correlation ID
        issue.setMessage(exception.getMessage());
        UserProfileErrorResponse body = new UserProfileErrorResponse();
        body.setMetadata(metadata);
        body.setIssues(Collections.singletonList(issue));
        return new ResponseEntity<>(body, status);
    }
}