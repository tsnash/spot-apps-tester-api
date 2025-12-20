package net.spotapps.tester.controller;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.response.Metadata;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.HttpRequestResponse;
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
    public ResponseEntity<HttpRequestResponse> getUserProfiles(final HttpServletRequest request) {
        return buildResponse(userProfileService.getAllProfiles());
    }

    @Override
    @GetMapping(
        value = "/{userId}",
        produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<HttpRequestResponse> getUserProfile(
        @Valid @PathVariable(value = "userId") final String userId, final HttpServletRequest request) {
        return buildResponse(userProfileService.getUserProfile(userId));
    }

    @Override
    @PostMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<HttpRequestResponse> getUserProfiles(@Valid @RequestBody List<String> userIds,
            HttpServletRequest request) {
        return buildResponse(userProfileService.getUserProfileList(userIds));
    }

    private ResponseEntity<HttpRequestResponse> buildResponse(List<UserProfileDto> userProfiles) {
        Metadata metadata = createMetadata("User profile(s) fetched.");
        UserProfileCollectionResponse response = new UserProfileCollectionResponse();
        response.setMetadata(metadata);
        response.setUserProfiles(userProfiles);
        return ResponseEntity.ok(response);
    }

    private ResponseEntity<HttpRequestResponse> buildResponse(UserProfileDto userProfile) {
        Metadata metadata = createMetadata("User profile fetched.");
        UserProfileSuccessResponse response = new UserProfileSuccessResponse();
        response.setMetadata(metadata);
        response.setUserProfile(userProfile);
        return ResponseEntity.ok(response);
    }

    private Metadata createMetadata(String description) {
        Metadata metadata = new Metadata();
        metadata.setServiceName("User Profile Service");
        metadata.setStatusCode(HttpStatus.OK.getReasonPhrase());
        metadata.setStatusDescription(description);
        return metadata;
    }

}
