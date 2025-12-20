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
import net.spotapps.tester.model.exception.NotFoundException;
import net.spotapps.tester.model.exception.TooManyRequestsException;
import net.spotapps.tester.model.response.Issue;
import net.spotapps.tester.model.response.Metadata;
import net.spotapps.tester.model.response.HttpRequestErrorResponse;
import net.spotapps.tester.model.response.HttpRequestResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ApiResponse(
        responseCode = "404", 
        description =  "Requested resource was not found.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) }
    )
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<HttpRequestResponse> notFound(
        HttpServletRequest request, RuntimeException e) {        
        return error(HttpStatus.NOT_FOUND, "Requested resource was not found.", e);
    }

    @ApiResponse(
        responseCode = "400", 
        description =  "Supplied data was invalid.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) }
    )
    @ExceptionHandler({BadRequestException.class})
    protected ResponseEntity<HttpRequestResponse> badRequest(
        HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.BAD_REQUEST, "Supplied data was invalid." , e);
    }

    @ApiResponse(
        responseCode = "429", 
        description = "The user has sent too many requests in a given amount of time.",  
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler(value = {TooManyRequestsException.class})
    protected ResponseEntity<HttpRequestResponse> tooManyRequests(
        HttpServletRequest request, RuntimeException e) {

        return error(HttpStatus.TOO_MANY_REQUESTS, 
            "The user has sent too many requests in a given amount of time.", e);
    }

    @ApiResponse(
        responseCode = "500", 
        description =  "An unexpected error occurred.", 
        content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<HttpRequestResponse> internalServerError(
        HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.", e);
    }

    private Metadata initializeMetadata() {
        Metadata metadata = new Metadata();
        metadata.setServiceName("User Profile Service");
        return metadata;
    }

    private ResponseEntity<HttpRequestResponse> error(HttpStatus status, String description, RuntimeException exception) {
        Metadata metadata = initializeMetadata();
        metadata.setStatusCode(status.getReasonPhrase());
        metadata.setStatusDescription(description);
        Issue issue = new Issue();
        //TODO: generate correlation ID and log it with the exception message
        //TODO: replace with generic message that contains generated correlation ID
        issue.setMessage(exception.getMessage());
        HttpRequestErrorResponse body = new HttpRequestErrorResponse();
        body.setMetadata(metadata);
        body.setIssues(Collections.singletonList(issue));
        return new ResponseEntity<>(body, status);
    }
}