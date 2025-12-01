package net.spotapps.tester.controller;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.UserProfileErrorResponse;
import net.spotapps.tester.model.response.HttpRequestResponse;
import net.spotapps.tester.model.response.UserProfileSuccessResponse;

@Tag(name = "user-profile-service")
@RestController
@RequestMapping("/user-profiles")
public interface UserProfileAPIContract {

    @Operation(
            summary = "Fetch multiple user profiles",
            description  = "Use this resource to fetch multiple user profiles from the repository.",
            tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(
                responseCode = "200", 
                description = "User profile(s) fetched.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileCollectionResponse.class)) }),
            @ApiResponse(
                responseCode = "400", 
                description = "User profile fetch failed.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "403", 
                description =  "User is not entitled to fetch user profiles.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "500", 
                description =  "An unexpected error has occurred. Unable to fetch user profile(s).", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })})
    @GetMapping(
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<HttpRequestResponse> getUserProfiles(HttpServletRequest request);

    @Operation(
            summary =  "Fetch a user profile by id",
            description =  "Use this resource to fetch a user profile from the repository.",
            tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(
                responseCode = "200", 
                description = "User profile fetched.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileSuccessResponse.class)) }),
            @ApiResponse(
                responseCode = "400", 
                description = "User profile fetch failed.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "403", 
                description =  "User is not entitled to fetch this user profile.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "404", 
                description =  "User profile was not found.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "500", 
                description =  "An unexpected error has occurred. User profile was not fetched.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })})
    @GetMapping(
            value = "/{userId}",
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<HttpRequestResponse> getUserProfile(
        @Parameter(required = true, description = "User ID associated with the user profile")
        @Valid @PathVariable(value = "userId") String userId,
            HttpServletRequest request);

    @Operation(
        summary =  "Fetch multiple user profiles sourced by user IDs",
        description =  "Use this resource to fetch multiple user profiles from the repository.",
        tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(
                responseCode = "200", 
                description = "User profile(s) fetched.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileCollectionResponse.class)) }),
            @ApiResponse(
                responseCode = "400", 
                description = "User profile fetch failed.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "403", 
                description =  "User is not entitled to fetch user profiles.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) }),
            @ApiResponse(
                responseCode = "500", 
                description =  "An unexpected error has occurred. Unable to fetch user profile(s).", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })})
    @PostMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<HttpRequestResponse> getUserProfiles(
        @Parameter(required = true, description =  "List of user IDs associated with user profiles")
        @Valid @RequestBody List<String> userIds,
            HttpServletRequest request);
}
