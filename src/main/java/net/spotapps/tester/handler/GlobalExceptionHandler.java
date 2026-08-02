package net.spotapps.tester.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.spotapps.tester.exception.BadRequestException;
import net.spotapps.tester.exception.NotFoundException;
import net.spotapps.tester.exception.TooManyRequestsException;
import net.spotapps.tester.dto.response.Metadata;
import net.spotapps.tester.dto.response.HttpRequestErrorResponse;
import net.spotapps.tester.dto.response.HttpRequestResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ApiResponse(responseCode = "404", description = "Requested resource was not found.", content = {
            @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler({ NotFoundException.class })
    protected ResponseEntity<HttpRequestResponse> notFound(
            HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }

    @ApiResponse(responseCode = "400", description = "Supplied data was invalid.", content = {
            @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler({ BadRequestException.class })
    protected ResponseEntity<HttpRequestResponse> badRequest(
            HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.BAD_REQUEST, e);
    }

    @ApiResponse(responseCode = "429", description = "The user has sent too many requests in a given amount of time.", content = {
            @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler(value = { TooManyRequestsException.class })
    protected ResponseEntity<HttpRequestResponse> tooManyRequests(
            HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.TOO_MANY_REQUESTS, e);
    }

    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.", content = {
            @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpRequestErrorResponse.class)) })
    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<HttpRequestResponse> internalServerError(
            HttpServletRequest request, RuntimeException e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<HttpRequestResponse> error(HttpStatus status, RuntimeException exception) {
        String traceId = UUID.randomUUID().toString();
        // TODO: log exception message along with the generated traceId

        HttpRequestErrorResponse body = new HttpRequestErrorResponse();
        body.setMetadata(new Metadata(traceId));
        return new ResponseEntity<>(body, status);
    }
}