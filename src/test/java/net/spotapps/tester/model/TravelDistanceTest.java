package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TravelDistanceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentTravelDistances")
    public void testTravelDistanceInequality(TravelDistance testTravelDistance1, TravelDistance testTravelDistance2) {
        assertNotEquals(testTravelDistance1, testTravelDistance2, "Different travel distances should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelDistances")
    public void testTravelDistanceEquality(TravelDistance testTravelDistance1, TravelDistance testTravelDistance2) {
        assertEquals(testTravelDistance1, testTravelDistance2, "Identical travel distances should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelDistances")
    public void testTravelDistanceHashcodeEquality(TravelDistance testTravelDistance1, TravelDistance testTravelDistance2) {
        assertEquals(testTravelDistance1.hashCode(), testTravelDistance2.hashCode(),
                "Identical travel distances should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentTravelDistances() {
        TravelDistance travelDistance1 = new TravelDistance("Short");
        travelDistance1.setTravelDistanceId(1L);

        TravelDistance travelDistance2 = new TravelDistance("Long");
        travelDistance2.setTravelDistanceId(2L);

        TravelDistance travelDistanceNull = null;

        return Stream.of(
                Arguments.of(travelDistance1, travelDistance2),
                Arguments.of(travelDistance1, travelDistanceNull));
    }

    private static Stream<Arguments> provideIdenticalTravelDistances() {
        TravelDistance travelDistance1 = new TravelDistance("Short");
        travelDistance1.setTravelDistanceId(1L);

        TravelDistance travelDistance2 = new TravelDistance("Short");
        travelDistance2.setTravelDistanceId(2L);

        return Stream.of(
                Arguments.of(travelDistance1, travelDistance1),
                Arguments.of(travelDistance1, travelDistance2));
    }
}
