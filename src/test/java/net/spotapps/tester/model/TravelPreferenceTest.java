package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TravelPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentTravelPreferences")
    public void testTravelPreferenceInequality(TravelPreference testTravelPreference1,
            TravelPreference testTravelPreference2) {
        assertNotEquals(testTravelPreference1, testTravelPreference2,
                "Different travel preferences should not be equal");
        if (testTravelPreference2 != null) {
            assertNotEquals(testTravelPreference2, testTravelPreference1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelPreferences")
    public void testTravelPreferenceEquality(TravelPreference testTravelPreference1,
            TravelPreference testTravelPreference2) {
        assertEquals(testTravelPreference1, testTravelPreference2, "Identical travel preferences should be equal");
        assertEquals(testTravelPreference2, testTravelPreference1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalTravelPreferences")
    public void testTravelPreferenceHashcodeEquality(TravelPreference testTravelPreference1,
            TravelPreference testTravelPreference2) {
        assertEquals(testTravelPreference1.hashCode(), testTravelPreference2.hashCode(),
                "Identical travel preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentTravelPreferences() {
        TravelPreference travelPreference1 = new TravelPreference();
        travelPreference1.setUserId(1L);

        TravelPreference travelPreference2 = new TravelPreference();
        travelPreference2.setUserId(2L);

        TravelPreference travelPreferenceNull = new TravelPreference();
        travelPreferenceNull.setUserId(null);

        TravelPreference travelPreferenceNull2 = new TravelPreference();
        travelPreferenceNull2.setUserId(null);

        TravelPreference travelPreference1AllFields = new TravelPreference();
        travelPreference1AllFields.setUserId(1L);
        travelPreference1AllFields.setFrequency(new TravelFrequency("Often"));
        travelPreference1AllFields.setImportance(5);

        TravelPreference travelPreference2AllFields = new TravelPreference();
        travelPreference2AllFields.setUserId(2L);
        travelPreference2AllFields.setFrequency(new TravelFrequency("Often"));
        travelPreference2AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(travelPreference1, travelPreference2),
                Arguments.of(travelPreference1, travelPreferenceNull),
                Arguments.of(travelPreferenceNull, travelPreferenceNull2),
                Arguments.of(travelPreference1, null),
                Arguments.of(travelPreference1AllFields, travelPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalTravelPreferences() {
        TravelPreference travelPreference1 = new TravelPreference();
        travelPreference1.setUserId(1L);

        TravelPreference travelPreference2 = new TravelPreference();
        travelPreference2.setUserId(1L);

        TravelPreference travelPreference1AllFields = new TravelPreference();
        travelPreference1AllFields.setUserId(1L);
        travelPreference1AllFields.setFrequency(new TravelFrequency("Often"));
        travelPreference1AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(travelPreference1, travelPreference1),
                Arguments.of(travelPreference1, travelPreference2),
                Arguments.of(travelPreference1, travelPreference1AllFields));
    }
}
