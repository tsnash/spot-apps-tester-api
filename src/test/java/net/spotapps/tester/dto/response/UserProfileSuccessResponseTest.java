package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        UserProfileSuccessResponse userProfileSuccessResponse1 = createUserProfileSuccessResponse(new Metadata("same"));
        UserProfileSuccessResponse userProfileSuccessResponse2 = createUserProfileSuccessResponse(new Metadata("different"));
        UserProfileSuccessResponse userProfileSuccessResponseNull = new UserProfileSuccessResponse();

        return Stream.of(
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse2),
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponseNull),
            Arguments.of(userProfileSuccessResponse1, null));
    }

    private static Stream<Arguments> provideIdenticalSuccessResponses() {
        UserProfileSuccessResponse userProfileSuccessResponse1 = createUserProfileSuccessResponse(new Metadata("same"));
        UserProfileSuccessResponse userProfileSuccessResponse2 = createUserProfileSuccessResponse(new Metadata("same"));
        UserProfileSuccessResponse userProfileSuccessResponseNull = new UserProfileSuccessResponse();

        return Stream.of(
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse1),
            Arguments.of(userProfileSuccessResponse1, userProfileSuccessResponse2),
            Arguments.of(userProfileSuccessResponseNull, userProfileSuccessResponseNull));
    }

    private static UserProfileSuccessResponse createUserProfileSuccessResponse(Metadata metadata) {
        UserProfileSuccessResponse response = new UserProfileSuccessResponse();
        response.setMetadata(metadata);
        return response;
    }
}
