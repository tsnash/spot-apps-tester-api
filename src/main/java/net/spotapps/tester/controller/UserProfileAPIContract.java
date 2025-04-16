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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.UserProfileErrorResponse;
import net.spotapps.tester.model.response.UserProfileResponse;
import net.spotapps.tester.model.response.UserProfileSuccessResponse;

@Api(
        tags = {"user-profile-service"}
)
@RequestMapping("/user-profiles")
public interface UserProfileAPIContract {

    @ApiOperation(
            value = "Fetch multiple user profiles",
            notes = "Use this resource to fetch multiple user profiles from the repository.",
            tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "User profile(s) fetched.", response = UserProfileCollectionResponse.class),
            @ApiResponse(code = 400, message = "User profile fetch failed.", response = UserProfileErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to fetch user profiles.", 
                response = UserProfileErrorResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Unable to fetch user profile(s).", response =
                    UserProfileErrorResponse.class)})
    @GetMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<UserProfileResponse> getUserProfiles(HttpServletRequest request);

    @ApiOperation(
            value = "Fetch a user profile by id",
            notes = "Use this resource to fetch a user profile from the repository.",
            tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "User profile fetched.", response = UserProfileSuccessResponse.class),
            @ApiResponse(code = 400, message = "User profile fetch failed.", response = UserProfileErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to fetch this user profile.", response = 
                UserProfileErrorResponse.class),
            @ApiResponse(code = 404, message = "User profile was not found.", response = 
                UserProfileErrorResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. User profile was not fetched.", response =
                UserProfileErrorResponse.class)})
    @GetMapping(
            value = "/{userId}",
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<UserProfileResponse> getUserProfile(
        @ApiParam(required = true, value = "User ID associated with the user profile")
        @Valid @PathVariable(value = "userId") String userId,
            HttpServletRequest request);

    @ApiOperation(
        value = "Fetch multiple user profiles sourced by user IDs",
        notes = "Use this resource to fetch multiple user profiles from the repository.",
        tags = {"user-profile-service"}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "User profile(s) fetched.", response = UserProfileCollectionResponse.class),
            @ApiResponse(code = 400, message = "User profile fetch failed.", response = UserProfileErrorResponse.class),
            @ApiResponse(code = 403, message = "User is not entitled to fetch user profiles.", 
                response = UserProfileErrorResponse.class),
            @ApiResponse(code = 500, message = "An unexpected error has occurred. Unable to fetch user profile(s).", response =
                    UserProfileErrorResponse.class)})
    @PostMapping(
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_FORM_URLENCODED_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    ResponseEntity<UserProfileResponse> getUserProfiles(
        @ApiParam(required = true, value = "List of user IDs associated with user profiles")
        @Valid @RequestBody List<String> userIds,
            HttpServletRequest request);

}
