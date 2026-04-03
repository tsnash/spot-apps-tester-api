package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LanguageTest {

    @ParameterizedTest
    @MethodSource("provideDifferentLanguages")
    public void testLanguageInequality(Language testLanguage1, Language testLanguage2) {
        assertNotEquals(testLanguage1, testLanguage2, "Different languages should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLanguages")
    public void testLanguageEquality(Language testLanguage1, Language testLanguage2) {
        assertEquals(testLanguage1, testLanguage2, "Identical languages should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLanguages")
    public void testLanguageHashcodeEquality(Language testLanguage1, Language testLanguage2) {
        assertEquals(testLanguage1.hashCode(), testLanguage2.hashCode(),
                "Identical languages should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentLanguages() {
        Language language1 = new Language();
        language1.setLanguageId(1L);

        Language language2 = new Language();
        language2.setLanguageId(2L);

        Language languageNull = new Language();
        languageNull.setLanguageId(null);

        Language language1AllFields = new Language();
        language1AllFields.setLanguageId(1L);
        language1AllFields.setName("English");
        language1AllFields.setFluency(new FluencyLevel("Native"));

        Language language2AllFields = new Language();
        language2AllFields.setLanguageId(2L);
        language2AllFields.setName("English");
        language2AllFields.setFluency(new FluencyLevel("Native"));

        return Stream.of(
                Arguments.of(language1, language2),
                Arguments.of(language1, languageNull),
                Arguments.of(language1, null),
                Arguments.of(language1AllFields, language2AllFields));
    }

    private static Stream<Arguments> provideIdenticalLanguages() {
        Language language1 = new Language();
        language1.setLanguageId(1L);

        Language language2 = new Language();
        language2.setLanguageId(1L);

        Language languageNull = new Language();
        languageNull.setLanguageId(null);

        Language language1AllFields = new Language();
        language1AllFields.setLanguageId(1L);
        language1AllFields.setName("English");
        language1AllFields.setFluency(new FluencyLevel("Native"));

        return Stream.of(
                Arguments.of(language1, language1),
                Arguments.of(language1, language2),
                Arguments.of(languageNull, languageNull),
                Arguments.of(language1, language1AllFields));
    }
}
