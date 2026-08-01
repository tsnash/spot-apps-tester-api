package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.dto.UserProfileDto;

public class UserProfileCollectionResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentCollectionsResponses")
    public void testUserProfileCollectionResponseInequality(UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        assertNotEquals(testUserProfileCollectionResponse1, testUserProfileCollectionResponse2, "Different responses should not be equal");
    }
    
    @ParameterizedTest
    @MethodSource("provideIdenticalCollectionsResponses")
    public void testUserProfileCollectionResponseEquality(UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        assertEquals(testUserProfileCollectionResponse1, testUserProfileCollectionResponse2, "Identical responses should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalCollectionsResponses")
    public void testUserProfileCollectionResponseHashcoodeEquality(UserProfileCollectionResponse testUserProfileCollectionResponse1,
            UserProfileCollectionResponse testUserProfileCollectionResponse2) {
        assertEquals(testUserProfileCollectionResponse1.hashCode(), testUserProfileCollectionResponse2.hashCode(), "Identical responses should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentCollectionsResponses() {
        UserProfileCollectionResponse userProfileCollectionResponse1 = createUserProfileCollectionResponse("same", 1L);
        UserProfileCollectionResponse userProfileCollectionResponse2 = createUserProfileCollectionResponse("different", 1L);
        UserProfileCollectionResponse userProfileCollectionResponse3 = createUserProfileCollectionResponse("same", 2L);
        UserProfileCollectionResponse userProfileCollectionResponseNull = new UserProfileCollectionResponse();

        return Stream.of(
            Arguments.of(userProfileCollectionResponse1, userProfileCollectionResponse2),
            Arguments.of(userProfileCollectionResponse1, userProfileCollectionResponse3),
            Arguments.of(userProfileCollectionResponse1, userProfileCollectionResponseNull),
            Arguments.of(userProfileCollectionResponse1, null));
    }

    private static Stream<Arguments> provideIdenticalCollectionsResponses() {
        UserProfileCollectionResponse userProfileCollectionResponse1 = createUserProfileCollectionResponse("same", 1L);
        UserProfileCollectionResponse userProfileCollectionResponse2 = createUserProfileCollectionResponse("same", 1L);
        UserProfileCollectionResponse userProfileCollectionResponseNull = new UserProfileCollectionResponse();

        return Stream.of(
            Arguments.of(userProfileCollectionResponse1, userProfileCollectionResponse1),
            Arguments.of(userProfileCollectionResponse1, userProfileCollectionResponse2),
            Arguments.of(userProfileCollectionResponseNull, userProfileCollectionResponseNull));
    }

    private static UserProfileCollectionResponse createUserProfileCollectionResponse(String traceId, Long userId) {
        UserProfileCollectionResponse response = new UserProfileCollectionResponse();

        UserProfileDto userProfile = new UserProfileDto();
        userProfile.setUserId(userId);

        response.setMetadata(new Metadata(traceId));
        response.setUserProfiles(List.of(userProfile));
        return response;
    }
}
