package net.spotapps.tester.dto.response;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.EqualityTestHelper;
import net.spotapps.tester.dto.UserImageDto;
import net.spotapps.tester.dto.UserProfileDto;

public class UserProfileSuccessResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentSuccessResponses")
    public void testUserProfileSuccessResponseInequality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        EqualityTestHelper.assertInequality(testUserProfileSuccessResponse1, testUserProfileSuccessResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSuccessResponses")
    public void testUserProfileSuccessResponseEquality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        EqualityTestHelper.assertEquality(testUserProfileSuccessResponse1, testUserProfileSuccessResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSuccessResponses")
    public void testUserProfileSuccessResponseHashcodeEquality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        EqualityTestHelper.assertHashcodeEquality(testUserProfileSuccessResponse1, testUserProfileSuccessResponse2);
    }

    @Test
    public void testUserProfileSuccessResponseDifferentTypeInequality() {
        EqualityTestHelper.assertDifferentTypeInequality(
                createUserProfileSuccessResponse(new Metadata("same"), createUserProfileDto(1L)));
    }

    private static Stream<Arguments> provideDifferentSuccessResponses() {
        UserProfileSuccessResponse response1 = createUserProfileSuccessResponse(
                new Metadata("same"), createUserProfileDto(1L));
        UserProfileSuccessResponse responseDifferentTrace = createUserProfileSuccessResponse(
                new Metadata("different"), createUserProfileDto(1L));
        UserProfileSuccessResponse responseDifferentUserId = createUserProfileSuccessResponse(
                new Metadata("same"), createUserProfileDto(2L));
        UserProfileSuccessResponse responseDifferentUserField = createUserProfileSuccessResponse(
                new Metadata("same"), createUserProfileDto(1L, "avatar.png"));
        UserProfileSuccessResponse responseNullProfile = createUserProfileSuccessResponse(
                new Metadata("same"), null);
        UserProfileSuccessResponse responseNullMetadata = createUserProfileSuccessResponse(
                null, createUserProfileDto(1L));
        UserProfileSuccessResponse responseEmptyMetadata = createUserProfileSuccessResponse(
                new Metadata(null), createUserProfileDto(1L));
        UserProfileSuccessResponse responseAllNull = new UserProfileSuccessResponse();

        return Stream.of(
                Arguments.of(response1, responseDifferentTrace),
                Arguments.of(response1, responseDifferentUserId),
                Arguments.of(response1, responseDifferentUserField),
                Arguments.of(response1, responseNullProfile),
                Arguments.of(response1, responseNullMetadata),
                Arguments.of(responseEmptyMetadata, responseNullMetadata),
                Arguments.of(response1, responseAllNull),
                Arguments.of(response1, null));
    }

    private static Stream<Arguments> provideIdenticalSuccessResponses() {
        UserProfileSuccessResponse response1 = createUserProfileSuccessResponse(
                new Metadata("same"), createUserProfileDto(1L));
        UserProfileSuccessResponse response2 = createUserProfileSuccessResponse(
                new Metadata("same"), createUserProfileDto(1L));
        UserProfileSuccessResponse responseNullMetadata1 = createUserProfileSuccessResponse(
                null, createUserProfileDto(1L));
        UserProfileSuccessResponse responseNullMetadata2 = createUserProfileSuccessResponse(
                null, createUserProfileDto(1L));
        UserProfileSuccessResponse responseNullProfile1 = createUserProfileSuccessResponse(
                new Metadata("same"), null);
        UserProfileSuccessResponse responseNullProfile2 = createUserProfileSuccessResponse(
                new Metadata("same"), null);
        UserProfileSuccessResponse responseEmptyMetadataOnly1 = createUserProfileSuccessResponse(
                new Metadata(null), null);
        UserProfileSuccessResponse responseEmptyMetadataOnly2 = createUserProfileSuccessResponse(
                new Metadata(null), null);
        UserProfileSuccessResponse responseAllNull1 = new UserProfileSuccessResponse();
        UserProfileSuccessResponse responseAllNull2 = new UserProfileSuccessResponse();

        return Stream.of(
                Arguments.of(response1, response1),
                Arguments.of(response1, response2),
                Arguments.of(responseNullMetadata1, responseNullMetadata2),
                Arguments.of(responseNullProfile1, responseNullProfile2),
                Arguments.of(responseEmptyMetadataOnly1, responseEmptyMetadataOnly2),
                Arguments.of(responseAllNull1, responseAllNull2));
    }

    private static UserProfileSuccessResponse createUserProfileSuccessResponse(Metadata metadata,
            UserProfileDto userProfile) {
        UserProfileSuccessResponse response = new UserProfileSuccessResponse();
        response.setMetadata(metadata);
        response.setUserProfile(userProfile);
        return response;
    }

    private static UserProfileDto createUserProfileDto(Long userId) {
        UserProfileDto userProfile = new UserProfileDto();
        userProfile.setUserId(userId);
        return userProfile;
    }

    private static UserProfileDto createUserProfileDto(Long userId, String imageName) {
        UserImageDto image = new UserImageDto();
        image.setImageId(1L);
        image.setImage(imageName);

        UserProfileDto userProfile = createUserProfileDto(userId);
        userProfile.setImages(List.of(image));
        return userProfile;
    }
}
