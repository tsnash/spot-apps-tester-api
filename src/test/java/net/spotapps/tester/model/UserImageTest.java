package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserImageTest {

    @ParameterizedTest
    @MethodSource("provideDifferentUserImages")
    public void testUserImageInequality(UserImage testUserImage1, UserImage testUserImage2) {
        assertNotEquals(testUserImage1, testUserImage2, "Different user images should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserImages")
    public void testUserImageEquality(UserImage testUserImage1, UserImage testUserImage2) {
        assertEquals(testUserImage1, testUserImage2, "Identical user images should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserImages")
    public void testUserImageHashcodeEquality(UserImage testUserImage1, UserImage testUserImage2) {
        assertEquals(testUserImage1.hashCode(), testUserImage2.hashCode(), "Identical user images should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUserImages() {
        UserImage userImage1 = new UserImage(1L, "img.png");
        UserImage userImage2 = new UserImage(2L, "img.png");
        UserImage userImaage3 = new UserImage(1L, "other.png");
        UserImage userImageNullId = new UserImage(null, "img.png");
        UserImage userImageNullStr = new UserImage(1L, null);

        return Stream.of(
                Arguments.of(userImage1, userImage2),
                Arguments.of(userImage1, userImaage3),
                Arguments.of(userImage1, userImageNullId),
                Arguments.of(userImage1, userImageNullStr));
    }

    private static Stream<Arguments> provideIdenticalUserImages() {
        UserImage userImage1 = new UserImage(1L, "img.png");
        UserImage userImage2 = new UserImage(1L, "img.png");
        UserImage userImageNull = new UserImage();

        return Stream.of(
                Arguments.of(userImage1, userImage1),
                Arguments.of(userImage1, userImage2),
                Arguments.of(userImageNull, userImageNull));
    }
}