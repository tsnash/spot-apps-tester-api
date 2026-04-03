package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LocationPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentLocationPreferences")
    public void testLocationPreferenceInequality(LocationPreference testLocationPreference1,
            LocationPreference testLocationPreference2) {
        assertNotEquals(testLocationPreference1, testLocationPreference2,
                "Different location preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLocationPreferences")
    public void testLocationPreferenceEquality(LocationPreference testLocationPreference1,
            LocationPreference testLocationPreference2) {
        assertEquals(testLocationPreference1, testLocationPreference2, "Identical location preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLocationPreferences")
    public void testLocationPreferenceHashcodeEquality(LocationPreference testLocationPreference1,
            LocationPreference testLocationPreference2) {
        assertEquals(testLocationPreference1.hashCode(), testLocationPreference2.hashCode(),
                "Identical location preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentLocationPreferences() {
        LocationPreference locationPreference1 = new LocationPreference();
        locationPreference1.setUserId(1L);

        LocationPreference locationPreference2 = new LocationPreference();
        locationPreference2.setUserId(2L);

        LocationPreference locationPreferenceNull = new LocationPreference();
        locationPreferenceNull.setUserId(null);

        LocationPreference locationPreference1AllFields = new LocationPreference();
        locationPreference1AllFields.setUserId(1L);
        locationPreference1AllFields.setUseLocal(true);
        locationPreference1AllFields.setDistanceInMiles(50.0);

        LocationPreference locationPreference2AllFields = new LocationPreference();
        locationPreference2AllFields.setUserId(2L);
        locationPreference2AllFields.setUseLocal(true);
        locationPreference2AllFields.setDistanceInMiles(50.0);

        return Stream.of(
                Arguments.of(locationPreference1, locationPreference2),
                Arguments.of(locationPreference1, locationPreferenceNull),
                Arguments.of(locationPreference1, null),
                Arguments.of(locationPreference1AllFields, locationPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalLocationPreferences() {
        LocationPreference locationPreference1 = new LocationPreference();
        locationPreference1.setUserId(1L);

        LocationPreference locationPreference2 = new LocationPreference();
        locationPreference2.setUserId(1L);

        LocationPreference locationPreferenceNull = new LocationPreference();
        locationPreferenceNull.setUserId(null);

        LocationPreference locationPreference1AllFields = new LocationPreference();
        locationPreference1AllFields.setUserId(1L);
        locationPreference1AllFields.setUseLocal(true);
        locationPreference1AllFields.setDistanceInMiles(50.0);

        return Stream.of(
                Arguments.of(locationPreference1, locationPreference1),
                Arguments.of(locationPreference1, locationPreference2),
                Arguments.of(locationPreferenceNull, locationPreferenceNull),
                Arguments.of(locationPreference1, locationPreference1AllFields));
    }
}
