package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LanguagePreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentLanguagePreferences")
    public void testLanguagePreferenceInequality(LanguagePreference testLanguagePreference1,
            LanguagePreference testLanguagePreference2) {
        assertNotEquals(testLanguagePreference1, testLanguagePreference2,
                "Different language preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLanguagePreferences")
    public void testLanguagePreferenceEquality(LanguagePreference testLanguagePreference1,
            LanguagePreference testLanguagePreference2) {
        assertEquals(testLanguagePreference1, testLanguagePreference2, "Identical language preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLanguagePreferences")
    public void testLanguagePreferenceHashcodeEquality(LanguagePreference testLanguagePreference1,
            LanguagePreference testLanguagePreference2) {
        assertEquals(testLanguagePreference1.hashCode(), testLanguagePreference2.hashCode(),
                "Identical language preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentLanguagePreferences() {
        LanguagePreference languagePreference1 = new LanguagePreference();
        languagePreference1.setUserId(1L);

        LanguagePreference languagePreference2 = new LanguagePreference();
        languagePreference2.setUserId(2L);

        LanguagePreference languagePreferenceNull = new LanguagePreference();
        languagePreferenceNull.setUserId(null);

        LanguagePreference languagePreference1AllFields = new LanguagePreference();
        languagePreference1AllFields.setUserId(1L);
        languagePreference1AllFields.setImportance(5);

        LanguagePreference languagePreference2AllFields = new LanguagePreference();
        languagePreference2AllFields.setUserId(2L);
        languagePreference2AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(languagePreference1, languagePreference2),
                Arguments.of(languagePreference1, languagePreferenceNull),
                Arguments.of(languagePreference1, null),
                Arguments.of(languagePreference1AllFields, languagePreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalLanguagePreferences() {
        LanguagePreference languagePreference1 = new LanguagePreference();
        languagePreference1.setUserId(1L);

        LanguagePreference languagePreference2 = new LanguagePreference();
        languagePreference2.setUserId(1L);

        LanguagePreference languagePreferenceNull = new LanguagePreference();
        languagePreferenceNull.setUserId(null);

        LanguagePreference languagePreference1AllFields = new LanguagePreference();
        languagePreference1AllFields.setUserId(1L);
        languagePreference1AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(languagePreference1, languagePreference1),
                Arguments.of(languagePreference1, languagePreference2),
                Arguments.of(languagePreferenceNull, languagePreferenceNull),
                Arguments.of(languagePreference1, languagePreference1AllFields));
    }
}
