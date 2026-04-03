package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TravelFrequencyTest {

    @ParameterizedTest
    @MethodSource("provideDifferentTravelFrequencies")
    public void testTravelFrequencyInequality(TravelFrequency testTravelFrequency1, TravelFrequency testTravelFrequency2) {
        assertNotEquals(testTravelFrequency1, testTravelFrequency2, "Different travel frequencies should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelFrequencies")
    public void testTravelFrequencyEquality(TravelFrequency testTravelFrequency1, TravelFrequency testTravelFrequency2) {
        assertEquals(testTravelFrequency1, testTravelFrequency2, "Identical travel frequencies should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelFrequencies")
    public void testTravelFrequencyHashcodeEquality(TravelFrequency testTravelFrequency1, TravelFrequency testTravelFrequency2) {
        assertEquals(testTravelFrequency1.hashCode(), testTravelFrequency2.hashCode(),
                "Identical travel frequencies should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentTravelFrequencies() {
        TravelFrequency travelFrequency1 = new TravelFrequency("Never");
        travelFrequency1.setTravelFrequencyId(1L);

        TravelFrequency travelFrequency2 = new TravelFrequency("Often");
        travelFrequency2.setTravelFrequencyId(2L);

        TravelFrequency travelFrequencyNull = null;

        return Stream.of(
                Arguments.of(travelFrequency1, travelFrequency2),
                Arguments.of(travelFrequency1, travelFrequencyNull));
    }

    private static Stream<Arguments> provideIdenticalTravelFrequencies() {
        TravelFrequency travelFrequency1 = new TravelFrequency("Never");
        travelFrequency1.setTravelFrequencyId(1L);

        TravelFrequency travelFrequency2 = new TravelFrequency("Never");
        travelFrequency2.setTravelFrequencyId(2L);

        return Stream.of(
                Arguments.of(travelFrequency1, travelFrequency1),
                Arguments.of(travelFrequency1, travelFrequency2));
    }
}
