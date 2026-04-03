package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TravelDurationTest {

    @ParameterizedTest
    @MethodSource("provideDifferentTravelDurations")
    public void testTravelDurationInequality(TravelDuration testTravelDuration1, TravelDuration testTravelDuration2) {
        assertNotEquals(testTravelDuration1, testTravelDuration2, "Different travel durations should not be equal");
        if (testTravelDuration2 != null) {
            assertNotEquals(testTravelDuration2, testTravelDuration1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelDurations")
    public void testTravelDurationEquality(TravelDuration testTravelDuration1, TravelDuration testTravelDuration2) {
        assertEquals(testTravelDuration1, testTravelDuration2, "Identical travel durations should be equal");
        assertEquals(testTravelDuration2, testTravelDuration1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelDurations")
    public void testTravelDurationHashcodeEquality(TravelDuration testTravelDuration1, TravelDuration testTravelDuration2) {
        assertEquals(testTravelDuration1.hashCode(), testTravelDuration2.hashCode(),
                "Identical travel durations should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentTravelDurations() {
        TravelDuration travelDuration1 = new TravelDuration("Weekend");
        TravelDuration travelDuration2 = new TravelDuration("Week");
        TravelDuration travelDurationNull = null;

        return Stream.of(
                Arguments.of(travelDuration1, travelDuration2),
                Arguments.of(travelDuration1, travelDurationNull));
    }

    private static Stream<Arguments> provideIdenticalTravelDurations() {
        TravelDuration travelDuration1 = new TravelDuration("Weekend");
        travelDuration1.setTravelDurationId(1L);

        TravelDuration travelDuration2 = new TravelDuration("Weekend");
        travelDuration2.setTravelDurationId(2L);

        return Stream.of(
                Arguments.of(travelDuration1, travelDuration1),
                Arguments.of(travelDuration1, travelDuration2));
    }
}
