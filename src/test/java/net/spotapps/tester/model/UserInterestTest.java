package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserInterestTest {

    @ParameterizedTest
    @MethodSource("provideDifferentUserInterests")
    public void testUserInterestInequality(UserInterest testUserInterest1, UserInterest testUserInterest2) {
        assertNotEquals(testUserInterest1, testUserInterest2, "Different user interests should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserInterests")
    public void testUserInterestEquality(UserInterest testUserInterest1, UserInterest testUserInterest2) {
        assertEquals(testUserInterest1, testUserInterest2, "Identical user interests should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserInterests")
    public void testUserInterestHashcodeEquality(UserInterest testUserInterest1, UserInterest testUserInterest2) {
        assertEquals(testUserInterest1.hashCode(), testUserInterest2.hashCode(),
                "Identical user interests should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUserInterests() {
        UserInterest userInterest1 = new UserInterest(1L, "coding");
        UserInterest userInterest2 = new UserInterest(2L, "coding");
        UserInterest userInterest3 = new UserInterest(1L, "swimming");
        UserInterest userInterestNullId = new UserInterest(null, "coding");
        UserInterest userInterestNullStr = new UserInterest(1L, null);

        return Stream.of(
                Arguments.of(userInterest1, userInterest2),
                Arguments.of(userInterest1, userInterest3),
                Arguments.of(userInterest1, userInterestNullId),
                Arguments.of(userInterest1, userInterestNullStr));
    }

    private static Stream<Arguments> provideIdenticalUserInterests() {
        UserInterest userInterest1 = new UserInterest(1L, "coding");
        UserInterest userInterest2 = new UserInterest(1L, "coding");
        UserInterest userInterestNull = new UserInterest();

        return Stream.of(
                Arguments.of(userInterest1, userInterest1),
                Arguments.of(userInterest1, userInterest2),
                Arguments.of(userInterestNull, userInterestNull));
    }
}