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
    public void testUserImageInequality(UserImage image1, UserImage image2) {
        assertNotEquals(image1, image2, "Different user images should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserImages")
    public void testUserImageEquality(UserImage image1, UserImage image2) {
        assertEquals(image1, image2, "Identical user images should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserImages")
    public void testUserImageHashcodeEquality(UserImage image1, UserImage image2) {
        assertEquals(image1.hashCode(), image2.hashCode(), "Identical user images should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUserImages() {
        UserImage img1 = new UserImage(1L, "img.png");
        UserImage img2 = new UserImage(2L, "img.png");
        UserImage img3 = new UserImage(1L, "other.png");
        UserImage imgNullId = new UserImage(null, "img.png");
        UserImage imgNullStr = new UserImage(1L, null);

        return Stream.of(
                Arguments.of(img1, img2),
                Arguments.of(img1, img3),
                Arguments.of(img1, imgNullId),
                Arguments.of(img1, imgNullStr));
    }

    private static Stream<Arguments> provideIdenticalUserImages() {
        UserImage img1 = new UserImage(1L, "img.png");
        UserImage img2 = new UserImage(1L, "img.png");
        UserImage imgNulls1 = new UserImage();
        UserImage imgNulls2 = new UserImage();

        return Stream.of(
                Arguments.of(img1, img1),
                Arguments.of(img1, img2),
                Arguments.of(imgNulls1, imgNulls2));
    }
}