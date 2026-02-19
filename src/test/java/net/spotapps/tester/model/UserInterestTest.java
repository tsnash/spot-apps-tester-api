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
    public void testUserInterestInequality(UserInterest interest1, UserInterest interest2) {
        assertNotEquals(interest1, interest2, "Different user interests should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserInterests")
    public void testUserInterestEquality(UserInterest interest1, UserInterest interest2) {
        assertEquals(interest1, interest2, "Identical user interests should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideDifferentUserInterests")
    public void testUserInterestHashcodeInequality(UserInterest interest1, UserInterest interest2) {
        assertNotEquals(interest1.hashCode(), interest2.hashCode(),
                "Different user interests should not have equal hash codes");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserInterests")
    public void testUserInterestHashcodeEquality(UserInterest interest1, UserInterest interest2) {
        assertEquals(interest1.hashCode(), interest2.hashCode(),
                "Identical user interests should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUserInterests() {
        UserInterest int1 = new UserInterest(1L, "coding");
        UserInterest int2 = new UserInterest(2L, "coding");
        UserInterest int3 = new UserInterest(1L, "swimming");
        UserInterest intNullId = new UserInterest(null, "coding");
        UserInterest intNullStr = new UserInterest(1L, null);

        return Stream.of(
                Arguments.of(int1, int2),
                Arguments.of(int1, int3),
                Arguments.of(int1, intNullId),
                Arguments.of(int1, intNullStr));
    }

    private static Stream<Arguments> provideIdenticalUserInterests() {
        UserInterest int1 = new UserInterest(1L, "coding");
        UserInterest int2 = new UserInterest(1L, "coding");
        UserInterest intNulls1 = new UserInterest();
        UserInterest intNulls2 = new UserInterest();

        return Stream.of(
                Arguments.of(int1, int1),
                Arguments.of(int1, int2),
                Arguments.of(intNulls1, intNulls2));
    }
}