package net.spotapps.tester.controller;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.exception.InvalidIdException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;
import net.spotapps.tester.model.response.Issue;
import net.spotapps.tester.model.response.Metadata;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.UserProfileErrorResponse;
import net.spotapps.tester.model.response.UserProfileResponse;
import net.spotapps.tester.model.response.UserProfileSuccessResponse;
import net.spotapps.tester.service.UserProfileService;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileAPIContractImpl implements UserProfileAPIContract {

    private UserProfileService userProfileService;

    public UserProfileAPIContractImpl(final UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    @GetMapping(
        produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserProfileResponse> getUserProfiles(final HttpServletRequest request) {

        Metadata metadata = initializeMetadata();
        List<UserProfileDto> userProfiles = userProfileService.getAllProfiles();

        metadata.setStatusCode(HttpStatus.OK.getReasonPhrase());
        metadata.setStatusDescription("User profile(s) fetched.");

        UserProfileCollectionResponse response = new UserProfileCollectionResponse();
        response.setMetadata(metadata);
        response.setUserProfiles(userProfiles);

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping(
        value = "/{userId}",
        produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserProfileResponse> getUserProfile(
        @Valid @PathVariable(value = "userId") final String userId, final HttpServletRequest request) {

            Metadata metadata = initializeMetadata();
            UserProfileDto userProfile = userProfileService.getUserProfile(userId);

            metadata.setStatusCode(HttpStatus.OK.getReasonPhrase());
            metadata.setStatusDescription("User profile fetched.");

            UserProfileSuccessResponse response = new UserProfileSuccessResponse();
            response.setMetadata(metadata);
            response.setUserProfile(userProfile);
        
            return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserProfileResponse> getUserProfiles(@Valid @RequestBody List<String> userIds,
            HttpServletRequest request) {

                Metadata metadata = initializeMetadata();
                List<UserProfileDto> userProfiles = userProfileService.getUserProfileList(userIds);

                metadata.setStatusCode(HttpStatus.OK.getReasonPhrase());
                metadata.setStatusDescription("User profile(s) fetched.");
                
                UserProfileCollectionResponse response = new UserProfileCollectionResponse();
                response.setMetadata(metadata);
                response.setUserProfiles(userProfiles);
        
                return ResponseEntity.ok(response);
    }

    @ApiResponse(
                responseCode = "404", 
                description =  "User profile was not found.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })
    @ExceptionHandler({UserProfileNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<UserProfileResponse> userProfileNotFound(
        HttpServletRequest request, RuntimeException e) {
            Metadata metadata = initializeMetadata();
            Issue issue = new Issue();

            metadata.setStatusCode(HttpStatus.NOT_FOUND.getReasonPhrase());
            metadata.setStatusDescription("User profile was not found.");
            issue.setMessage(e.getMessage());

            UserProfileErrorResponse response = new UserProfileErrorResponse();
            response.setMetadata(metadata);
            response.setIssues(Collections.singletonList(issue));
            
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ApiResponse(
                responseCode = "412", 
                description =  "Supplied data was invalid.", 
                content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserProfileErrorResponse.class)) })
    @ExceptionHandler({InvalidIdException.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    private ResponseEntity<UserProfileResponse> userProfilePreconditionFailed(
        HttpServletRequest request, RuntimeException e) {
            Metadata metadata = initializeMetadata();
            Issue issue = new Issue();

            metadata.setStatusCode(HttpStatus.PRECONDITION_FAILED.getReasonPhrase());
            metadata.setStatusDescription("User ID supplied was invalid.");
            issue.setMessage(e.getMessage());

            UserProfileErrorResponse response = new UserProfileErrorResponse();
            response.setMetadata(metadata);
            response.setIssues(Collections.singletonList(issue));

            return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
        }

    private Metadata initializeMetadata() {
        Metadata metadata = new Metadata();
        metadata.setServiceName("User Profile Service");
        return metadata;
    }

}
