package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DietPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentDietPreferences")
    public void testDietPreferenceInequality(DietPreference testDietPreference1, DietPreference testDietPreference2) {
        assertNotEquals(testDietPreference1, testDietPreference2, "Different diet preferences should not be equal");
        if (testDietPreference2 != null) {
            assertNotEquals(testDietPreference2, testDietPreference1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalDietPreferences")
    public void testDietPreferenceEquality(DietPreference testDietPreference1, DietPreference testDietPreference2) {
        assertEquals(testDietPreference1, testDietPreference2, "Identical diet preferences should be equal");
        assertEquals(testDietPreference2, testDietPreference1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalDietPreferences")
    public void testDietPreferenceHashcodeEquality(DietPreference testDietPreference1, DietPreference testDietPreference2) {
        assertEquals(testDietPreference1.hashCode(), testDietPreference2.hashCode(),
                "Identical diet preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentDietPreferences() {
        DietPreference dietPreference1 = new DietPreference();
        dietPreference1.setUserId(1L);

        DietPreference dietPreference2 = new DietPreference();
        dietPreference2.setUserId(2L);

        DietPreference dietPreferenceNull = new DietPreference();
        dietPreferenceNull.setUserId(null);

        DietPreference dietPreferenceNull2 = new DietPreference();
        dietPreferenceNull2.setUserId(null);

        DietPreference dietPreference1AllFields = new DietPreference();
        dietPreference1AllFields.setUserId(1L);
        dietPreference1AllFields.setImportance(5);

        DietPreference dietPreference2AllFields = new DietPreference();
        dietPreference2AllFields.setUserId(2L);
        dietPreference2AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(dietPreference1, dietPreference2),
                Arguments.of(dietPreference1, dietPreferenceNull),
                Arguments.of(dietPreferenceNull, dietPreferenceNull2),
                Arguments.of(dietPreference1, null),
                Arguments.of(dietPreference1AllFields, dietPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalDietPreferences() {
        DietPreference dietPreference1 = new DietPreference();
        dietPreference1.setUserId(1L);

        DietPreference dietPreference2 = new DietPreference();
        dietPreference2.setUserId(1L);

        DietPreference dietPreference1AllFields = new DietPreference();
        dietPreference1AllFields.setUserId(1L);
        dietPreference1AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(dietPreference1, dietPreference1),
                Arguments.of(dietPreference1, dietPreference2),
                Arguments.of(dietPreference1, dietPreference1AllFields));
    }
}
