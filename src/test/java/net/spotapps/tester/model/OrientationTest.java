package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrientationTest {

    @ParameterizedTest
    @MethodSource("provideDifferentOrientations")
    public void testOrientationInequality(Orientation testOrientation1, Orientation testOrientation2) {
        assertNotEquals(testOrientation1, testOrientation2, "Different orientations should not be equal");
        if (testOrientation2 != null) {
            assertNotEquals(testOrientation2, testOrientation1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalOrientations")
    public void testOrientationEquality(Orientation testOrientation1, Orientation testOrientation2) {
        assertEquals(testOrientation1, testOrientation2, "Identical orientations should be equal");
        assertEquals(testOrientation2, testOrientation1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalOrientations")
    public void testOrientationHashcodeEquality(Orientation testOrientation1, Orientation testOrientation2) {
        assertEquals(testOrientation1.hashCode(), testOrientation2.hashCode(),
                "Identical orientations should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentOrientations() {
        Orientation orientation1 = new Orientation("Straight");
        orientation1.setOrientationId(1L);

        Orientation orientation2 = new Orientation("Gay");
        orientation2.setOrientationId(2L);

        Orientation orientationNull = null;

        return Stream.of(
                Arguments.of(orientation1, orientation2),
                Arguments.of(orientation1, orientationNull));
    }

    private static Stream<Arguments> provideIdenticalOrientations() {
        Orientation orientation1 = new Orientation("Straight");
        orientation1.setOrientationId(1L);

        Orientation orientation2 = new Orientation("DifferentName");
        orientation2.setOrientationId(1L);

        return Stream.of(
                Arguments.of(orientation1, orientation1),
                Arguments.of(orientation1, orientation2));
    }
}
