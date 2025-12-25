package net.spotapps.tester.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static net.spotapps.tester.UserProfileConstants.INVALID_ID_MESSAGE;
import static net.spotapps.tester.UserProfileConstants.USER_PROFILE_NOT_FOUND_MESSAGE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.restassured.path.json.JsonPath;
import net.spotapps.tester.UserProfileConstants;
import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserInterest;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidUserIdCollectionException;
import net.spotapps.tester.model.exception.InvalidUserIdException;
import net.spotapps.tester.model.exception.UserProfileCollectionNotFoundException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.HttpRequestErrorResponse;
import net.spotapps.tester.model.response.UserProfileSuccessResponse;
import net.spotapps.tester.service.UserProfileService;

@WebMvcTest(value = UserProfileAPIContractImpl.class)
public class UserProfileAPIContractRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserProfileService userProfileService;

    private UserProfile testUserProfile1;
    private UserProfile testUserProfile2;
    private UserProfileDto testUserProfileDto1;
    private UserProfileDto testUserProfileDto2;

    @BeforeEach
    public void setUp() {

        testUserProfile1 = new UserProfile();
        testUserProfile1.setUserId(1L);
        testUserProfile1.setImages(Arrays.asList(
                new UserImage(1L, "four"),
                new UserImage(2L, "images"),
                new UserImage(3L, "only"),
                new UserImage(4L, "please")));
        testUserProfile1.setInterests(Arrays.asList(
                new UserInterest(1L, "up"),
                new UserInterest(2L, "to"),
                new UserInterest(3L, "six"),
                new UserInterest(4L, "of"),
                new UserInterest(5L, "these"),
                new UserInterest(6L, "allowed")));

        testUserProfileDto1 = UserProfileDto.convertUserProfileToDto(testUserProfile1);

        testUserProfile2 = new UserProfile();
        testUserProfile2.setUserId(2L);
        testUserProfile2.setImages(Arrays.asList(
                new UserImage(5L, "just"),
                new UserImage(6L, "these"),
                new UserImage(7L, "four"),
                new UserImage(8L, "images")));
        testUserProfile2.setInterests(Arrays.asList(
                new UserInterest(7L, "you"),
                new UserInterest(8L, "can"),
                new UserInterest(9L, "vary"),
                new UserInterest(10L, "this"),
                new UserInterest(11L, "amount")));

        testUserProfileDto2 = UserProfileDto.convertUserProfileToDto(testUserProfile2);

    }

    @Test
    void testGetUserProfiles() throws Exception {

        when(userProfileService.getAllProfiles())
                .thenReturn(Arrays.asList(new UserProfileDto[] { testUserProfileDto1, testUserProfileDto2 }));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user-profiles")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String responseContent = result.getResponse().getContentAsString();
        UserProfileCollectionResponse actual = JsonPath.from(responseContent)
                .getObject("", UserProfileCollectionResponse.class);

        assertEquals(
                2,
                actual.getUserProfiles().size(),
                "There should be two total user profiles");
        assertEquals(
                testUserProfileDto2,
                actual.getUserProfiles().get(1),
                "The second profile should match");
        assertEquals(
                HttpStatus.OK.getReasonPhrase(),
                actual.getMetadata().getStatusCode(),
                "The metadata should reflect the OK status");
        assertEquals(
                HttpStatus.OK.value(),
                result.getResponse().getStatus(),
                "The response should reflect the OK status");
        verify(userProfileService).getAllProfiles();
    }

    @Test
    void testGetUserProfileById() throws Exception {

        when(userProfileService.getUserProfile("1"))
                .thenReturn(testUserProfileDto1);

        when(userProfileService.getUserProfile("3"))
                .thenThrow(new UserProfileNotFoundException(USER_PROFILE_NOT_FOUND_MESSAGE, 3L));

        when(userProfileService.getUserProfile("invalidID"))
                .thenThrow(new InvalidUserIdException(INVALID_ID_MESSAGE, "invalidID"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user-profiles/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String responseContent = result.getResponse().getContentAsString();
        UserProfileSuccessResponse actual = JsonPath.from(responseContent)
                .getObject("", UserProfileSuccessResponse.class);

        assertEquals(
                testUserProfileDto1,
                actual.getUserProfile(),
                "The fetched user profile should match the original");
        assertEquals(
                HttpStatus.OK.getReasonPhrase(),
                actual.getMetadata().getStatusCode(),
                "The metadata should reflect the OK status");
        assertEquals(
                HttpStatus.OK.value(),
                result.getResponse().getStatus(),
                "The response should reflect the OK status");
        verify(userProfileService).getUserProfile("1");

        requestBuilder = MockMvcRequestBuilders.get("/user-profiles/3")
                .accept(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        responseContent = result.getResponse().getContentAsString();
        HttpRequestErrorResponse error = JsonPath.from(responseContent)
                .getObject("", HttpRequestErrorResponse.class);

        assertEquals(
                new UserProfileNotFoundException(USER_PROFILE_NOT_FOUND_MESSAGE, 3L).getMessage(),
                error.getIssues().get(0).getMessage(),
                "The issue should have a matching User Profile Not Found message");
        assertEquals(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                error.getMetadata().getStatusCode(),
                "The metadata should reflect the NOT FOUND status");
        assertEquals(
                HttpStatus.NOT_FOUND.value(),
                result.getResponse().getStatus(),
                "The response should reflect the NOT FOUND status");
        verify(userProfileService).getUserProfile("3");

        requestBuilder = MockMvcRequestBuilders.get("/user-profiles/invalidID")
                .accept(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        responseContent = result.getResponse().getContentAsString();
        error = JsonPath.from(responseContent)
                .getObject("", HttpRequestErrorResponse.class);

        assertEquals(
                new InvalidUserIdException(INVALID_ID_MESSAGE, "invalidID").getMessage(),
                error.getIssues().get(0).getMessage(),
                "The issue should have a matching Invalid ID message");
        assertEquals(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                error.getMetadata().getStatusCode(),
                "The metadata should reflect the BAD REQUEST status");
        assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                result.getResponse().getStatus(),
                "The response should reflect the BAD REQUEST status");
        verify(userProfileService).getUserProfile("invalidID");
    }

    @Test
    void testGetUserProfilesContainingIds() throws Exception {

        when(userProfileService.getUserProfileList(Arrays.asList("1", "2")))
                .thenReturn(Arrays.asList(new UserProfileDto[] { testUserProfileDto1, testUserProfileDto2 }));
        
        when(userProfileService.getUserProfileList(Arrays.asList("invalidID", "2")))
                .thenThrow(new InvalidUserIdCollectionException(
                    UserProfileConstants.INVALID_ID_COLLECTION_MESSAGE, Collections.singletonList("invalidID")));

        when(userProfileService.getUserProfileList(Collections.emptyList()))
                .thenThrow(new InvalidUserIdCollectionException(
                    UserProfileConstants.INVALID_ID_COLLECTION_MESSAGE, List.of("<empty>")));

        when(userProfileService.getUserProfileList(Arrays.asList("3", "4")))
                .thenThrow(new UserProfileCollectionNotFoundException(
                    UserProfileConstants.USER_PROFILE_COLLECTION_NOT_FOUND_MESSAGE, Arrays.asList("3", "4")));


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user-profiles")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\"1\", \"2\"]")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String responseContent = result.getResponse().getContentAsString();
        UserProfileCollectionResponse actual = JsonPath.from(responseContent)
                .getObject("", UserProfileCollectionResponse.class);

        assertEquals(
                2,
                actual.getUserProfiles().size(),
                "There should be 2 user profiles");
        assertEquals(
                testUserProfileDto1,
                actual.getUserProfiles().get(0),
                "The first profile should match");
        assertEquals(
                HttpStatus.OK.getReasonPhrase(),
                actual.getMetadata().getStatusCode(),
                "The metadata should reflect the OK status");
        assertEquals(
                HttpStatus.OK.value(),
                result.getResponse().getStatus(),
                "The response should reflect the OK status");
        verify(userProfileService).getUserProfileList(Arrays.asList("1", "2"));

        requestBuilder = MockMvcRequestBuilders.post("/user-profiles")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\"invalidID\", \"2\"]")
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        responseContent = result.getResponse().getContentAsString();
        HttpRequestErrorResponse error = JsonPath.from(responseContent)
                .getObject("", HttpRequestErrorResponse.class);

        assertEquals(
                new InvalidUserIdCollectionException(
                    UserProfileConstants.INVALID_ID_COLLECTION_MESSAGE, Collections.singletonList("invalidID")).getMessage(),
                error.getIssues().get(0).getMessage(),
                "The issue should have a matching Invalid ID message");
        assertEquals(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                error.getMetadata().getStatusCode(),
                "The metadata should reflect the BAD REQUEST status");
        assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                result.getResponse().getStatus(),
                "The response should reflect the BAD REQUEST status");
        verify(userProfileService).getUserProfileList(Arrays.asList("invalidID", "2"));

        requestBuilder = MockMvcRequestBuilders.post("/user-profiles")
                .accept(MediaType.APPLICATION_JSON)
                .content("[]")
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        responseContent = result.getResponse().getContentAsString();
        error = JsonPath.from(responseContent)
                .getObject("", HttpRequestErrorResponse.class);

        assertEquals(
                new InvalidUserIdCollectionException(
                    UserProfileConstants.INVALID_ID_COLLECTION_MESSAGE, List.of("<empty>")).getMessage(),
                error.getIssues().get(0).getMessage(),
                "The issue should have a matching Invalid ID message");
        assertEquals(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                error.getMetadata().getStatusCode(),
                "The metadata should reflect the BAD REQUEST status");
        assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                result.getResponse().getStatus(),
                "The response should reflect the BAD REQUEST status");
        verify(userProfileService).getUserProfileList(Collections.emptyList());

        requestBuilder = MockMvcRequestBuilders.post("/user-profiles")
                .accept(MediaType.APPLICATION_JSON)
                .content("[\"3\", \"4\"]")
                .contentType(MediaType.APPLICATION_JSON);

        result = mockMvc.perform(requestBuilder).andReturn();
        responseContent = result.getResponse().getContentAsString();
        error = JsonPath.from(responseContent)
                .getObject("", HttpRequestErrorResponse.class);

        assertEquals(
                new UserProfileCollectionNotFoundException(
                    UserProfileConstants.USER_PROFILE_COLLECTION_NOT_FOUND_MESSAGE, Arrays.asList("3", "4")).getMessage(),
                error.getIssues().get(0).getMessage(),
                "The issue should have a matching User Profile Not Found message");
        assertEquals(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                error.getMetadata().getStatusCode(),
                "The metadata should reflect the NOT FOUND status");
        assertEquals(
                HttpStatus.NOT_FOUND.value(),
                result.getResponse().getStatus(),
                "The response should reflect the NOT FOUND status");
        verify(userProfileService).getUserProfileList(Arrays.asList("3", "4"));

    }

}
