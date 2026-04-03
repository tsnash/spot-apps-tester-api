package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AgePreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentAgePreferences")
    public void testAgePreferenceInequality(AgePreference testAgePreference1, AgePreference testAgePreference2) {
        assertNotEquals(testAgePreference1, testAgePreference2, "Different age preferences should not be equal");
        if (testAgePreference2 != null) {
            assertNotEquals(testAgePreference2, testAgePreference1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalAgePreferences")
    public void testAgePreferenceEquality(AgePreference testAgePreference1, AgePreference testAgePreference2) {
        assertEquals(testAgePreference1, testAgePreference2, "Identical age preferences should be equal");
        assertEquals(testAgePreference2, testAgePreference1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalAgePreferences")
    public void testAgePreferenceHashcodeEquality(AgePreference testAgePreference1, AgePreference testAgePreference2) {
        assertEquals(testAgePreference1.hashCode(), testAgePreference2.hashCode(),
                "Identical age preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentAgePreferences() {
        AgePreference agePreference1 = new AgePreference();
        agePreference1.setUserId(1L);

        AgePreference agePreference2 = new AgePreference();
        agePreference2.setUserId(2L);

        AgePreference agePreferenceNull = new AgePreference();
        agePreferenceNull.setUserId(null);

        AgePreference agePreferenceNull2 = new AgePreference();
        agePreferenceNull2.setUserId(null);

        AgePreference agePreference1AllFields = new AgePreference();
        agePreference1AllFields.setUserId(1L);
        agePreference1AllFields.setDay("01");
        agePreference1AllFields.setMonth("01");
        agePreference1AllFields.setYear("2000");
        agePreference1AllFields.setMinAge(18);
        agePreference1AllFields.setMaxAge(30);

        AgePreference agePreference2AllFields = new AgePreference();
        agePreference2AllFields.setUserId(2L);
        agePreference2AllFields.setDay("01");
        agePreference2AllFields.setMonth("01");
        agePreference2AllFields.setYear("2000");
        agePreference2AllFields.setMinAge(18);
        agePreference2AllFields.setMaxAge(30);

        return Stream.of(
                Arguments.of(agePreference1, agePreference2),
                Arguments.of(agePreference1, agePreferenceNull),
                Arguments.of(agePreferenceNull, agePreferenceNull2),
                Arguments.of(agePreference1, null),
                Arguments.of(agePreference1AllFields, agePreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalAgePreferences() {
        AgePreference agePreference1 = new AgePreference();
        agePreference1.setUserId(1L);

        AgePreference agePreference2 = new AgePreference();
        agePreference2.setUserId(1L);

        AgePreference agePreference1AllFields = new AgePreference();
        agePreference1AllFields.setUserId(1L);
        agePreference1AllFields.setDay("01");
        agePreference1AllFields.setMonth("01");
        agePreference1AllFields.setYear("2000");
        agePreference1AllFields.setMinAge(18);
        agePreference1AllFields.setMaxAge(30);

        return Stream.of(
                Arguments.of(agePreference1, agePreference1),
                Arguments.of(agePreference1, agePreference2),
                Arguments.of(agePreference1, agePreference1AllFields));
    }
}
