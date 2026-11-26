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

public class UserProfileCollectionResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentCollectionResponses")
    public void testUserProfileCollectionResponseInequality(
            UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        EqualityTestHelper.assertInequality(testUserProfileCollectionResponse1, testUserProfileCollectionResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalCollectionResponses")
    public void testUserProfileCollectionResponseEquality(
            UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        EqualityTestHelper.assertEquality(testUserProfileCollectionResponse1, testUserProfileCollectionResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalCollectionResponses")
    public void testUserProfileCollectionResponseHashcodeEquality(
            UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        EqualityTestHelper.assertHashcodeEquality(testUserProfileCollectionResponse1, testUserProfileCollectionResponse2);
    }

    @Test
    public void testUserProfileCollectionResponseDifferentTypeInequality() {
        EqualityTestHelper.assertDifferentTypeInequality(
                createUserProfileCollectionResponse(new Metadata("same"), List.of(createUserProfileDto(1L))));
    }

    private static Stream<Arguments> provideDifferentCollectionResponses() {
        UserProfileCollectionResponse response1 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseDifferentTrace = createUserProfileCollectionResponse(
                new Metadata("different"), List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseDifferentUserId = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(2L)));
        UserProfileCollectionResponse responseSameIdDifferentImage = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L, "avatar.png")));
        UserProfileCollectionResponse responseSameIdOtherImage = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L, "other.png")));
        UserProfileCollectionResponse responseEmptyList = createUserProfileCollectionResponse(
                new Metadata("same"), List.of());
        UserProfileCollectionResponse responseTwoItems = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L), createUserProfileDto(2L)));
        UserProfileCollectionResponse responseReversedItems = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(2L), createUserProfileDto(1L)));
        UserProfileCollectionResponse responseNullProfiles = createUserProfileCollectionResponse(
                new Metadata("same"), null);
        UserProfileCollectionResponse responseNullMetadata = createUserProfileCollectionResponse(
                null, List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseEmptyMetadata = createUserProfileCollectionResponse(
                new Metadata(null), List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseAllNull = new UserProfileCollectionResponse();

        return Stream.of(
                Arguments.of(response1, responseDifferentTrace),
                Arguments.of(response1, responseDifferentUserId),
                Arguments.of(responseSameIdDifferentImage, responseSameIdOtherImage),
                Arguments.of(response1, responseEmptyList),
                Arguments.of(responseEmptyList, responseNullProfiles),
                Arguments.of(response1, responseTwoItems),
                Arguments.of(responseTwoItems, responseReversedItems),
                Arguments.of(response1, responseNullProfiles),
                Arguments.of(response1, responseNullMetadata),
                Arguments.of(responseEmptyMetadata, responseNullMetadata),
                Arguments.of(response1, responseAllNull),
                Arguments.of(response1, null));
    }

    private static Stream<Arguments> provideIdenticalCollectionResponses() {
        UserProfileCollectionResponse response1 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse response2 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseMulti1 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L), createUserProfileDto(2L)));
        UserProfileCollectionResponse responseMulti2 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of(createUserProfileDto(1L), createUserProfileDto(2L)));
        UserProfileCollectionResponse responseEmptyList1 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of());
        UserProfileCollectionResponse responseEmptyList2 = createUserProfileCollectionResponse(
                new Metadata("same"), List.of());
        UserProfileCollectionResponse responseNullMetadata1 = createUserProfileCollectionResponse(
                null, List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseNullMetadata2 = createUserProfileCollectionResponse(
                null, List.of(createUserProfileDto(1L)));
        UserProfileCollectionResponse responseNullProfiles1 = createUserProfileCollectionResponse(
                new Metadata("same"), null);
        UserProfileCollectionResponse responseNullProfiles2 = createUserProfileCollectionResponse(
                new Metadata("same"), null);
        UserProfileCollectionResponse responseEmptyMetadataOnly1 = createUserProfileCollectionResponse(
                new Metadata(null), null);
        UserProfileCollectionResponse responseEmptyMetadataOnly2 = createUserProfileCollectionResponse(
                new Metadata(null), null);
        UserProfileCollectionResponse responseAllNull1 = new UserProfileCollectionResponse();
        UserProfileCollectionResponse responseAllNull2 = new UserProfileCollectionResponse();

        return Stream.of(
                Arguments.of(response1, response1),
                Arguments.of(response1, response2),
                Arguments.of(responseMulti1, responseMulti2),
                Arguments.of(responseEmptyList1, responseEmptyList2),
                Arguments.of(responseNullMetadata1, responseNullMetadata2),
                Arguments.of(responseNullProfiles1, responseNullProfiles2),
                Arguments.of(responseEmptyMetadataOnly1, responseEmptyMetadataOnly2),
                Arguments.of(responseAllNull1, responseAllNull2));
    }

    private static UserProfileCollectionResponse createUserProfileCollectionResponse(Metadata metadata,
            List<UserProfileDto> userProfiles) {
        UserProfileCollectionResponse response = new UserProfileCollectionResponse();
        response.setMetadata(metadata);
        response.setUserProfiles(userProfiles);
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
