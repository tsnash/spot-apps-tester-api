package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.dto.UserProfileDto;

public class UserProfileSuccessResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentSuccessResponses")
    public void testUserProfileSuccessResponseInequality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        assertNotEquals(testUserProfileSuccessResponse1, testUserProfileSuccessResponse2, "Different responses should not be equal");
    }
    
    @ParameterizedTest
    @MethodSource("provideIdenticalSuccessResponses")
    public void testUserProfileSuccessResponseEquality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        assertEquals(testUserProfileSuccessResponse1, testUserProfileSuccessResponse2, "Identical responses should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSuccessResponses")
    public void testUserProfileSuccessResponseHashcoodeEquality(UserProfileSuccessResponse testUserProfileSuccessResponse1,
            UserProfileSuccessResponse testUserProfileSuccessResponse2) {
        assertEquals(testUserProfileSuccessResponse1.hashCode(), testUserProfileSuccessResponse2.hashCode(), "Identical responses should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentSuccessResponses() {
        UserProfileSuccessResponse userProfileSuccessResponse1 = createUserProfileSuccessResponse("same", 1L);
        UserProfileSuccessResponse userProfileSuccessResponse2 = createUserProfileSuccessResponse("different", 1L);
        UserProfileSuccessResponse userProfileSuccessResponse3 = createUserProfileSuccessResponse("same", 2L);
        UserProfileSuccessResponse userProfileSuccessResponseNull = new UserProfileSuccessResponse();

        return Stream.of(
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse2),
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse3),
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponseNull),
            Arguments.of(userProfileSuccessResponse1, null));
    }

    private static Stream<Arguments> provideIdenticalSuccessResponses() {
        UserProfileSuccessResponse userProfileSuccessResponse1 = createUserProfileSuccessResponse("same", 1L);
        UserProfileSuccessResponse userProfileSuccessResponse2 = createUserProfileSuccessResponse("same", 1L);
        UserProfileSuccessResponse userProfileSuccessResponseNull = new UserProfileSuccessResponse();

        return Stream.of(
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse1),
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse2),
            Arguments.of(userProfileSuccessResponseNull, userProfileSuccessResponseNull));
    }

    private static UserProfileSuccessResponse createUserProfileSuccessResponse(String traceId, Long userId) {
        UserProfileSuccessResponse response = new UserProfileSuccessResponse();
        
        UserProfileDto userProfile = new UserProfileDto();
        userProfile.setUserId(userId);

        response.setMetadata(new Metadata(traceId));
        response.setUserProfile(userProfile);
        return response;
    }
}
