package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EducationPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentEducationPreferences")
    public void testEducationPreferenceInequality(EducationPreference testEducationPreference1,
            EducationPreference testEducationPreference2) {
        assertNotEquals(testEducationPreference1, testEducationPreference2,
                "Different education preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalEducationPreferences")
    public void testEducationPreferenceEquality(EducationPreference testEducationPreference1,
            EducationPreference testEducationPreference2) {
        assertEquals(testEducationPreference1, testEducationPreference2, "Identical education preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalEducationPreferences")
    public void testEducationPreferenceHashcodeEquality(EducationPreference testEducationPreference1,
            EducationPreference testEducationPreference2) {
        assertEquals(testEducationPreference1.hashCode(), testEducationPreference2.hashCode(),
                "Identical education preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentEducationPreferences() {
        EducationPreference educationPreference1 = new EducationPreference();
        educationPreference1.setUserId(1L);

        EducationPreference educationPreference2 = new EducationPreference();
        educationPreference2.setUserId(2L);

        EducationPreference educationPreferenceNull = new EducationPreference();
        educationPreferenceNull.setUserId(null);

        EducationPreference educationPreference1AllFields = new EducationPreference();
        educationPreference1AllFields.setUserId(1L);
        educationPreference1AllFields.setHighestDegree(new EducationDegree("Bachelor"));
        educationPreference1AllFields.setConcentration("Computer Science");
        educationPreference1AllFields.setImportance(5);

        EducationPreference educationPreference2AllFields = new EducationPreference();
        educationPreference2AllFields.setUserId(2L);
        educationPreference2AllFields.setHighestDegree(new EducationDegree("Bachelor"));
        educationPreference2AllFields.setConcentration("Computer Science");
        educationPreference2AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(educationPreference1, educationPreference2),
                Arguments.of(educationPreference1, educationPreferenceNull),
                Arguments.of(educationPreference1, null),
                Arguments.of(educationPreference1AllFields, educationPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalEducationPreferences() {
        EducationPreference educationPreference1 = new EducationPreference();
        educationPreference1.setUserId(1L);

        EducationPreference educationPreference2 = new EducationPreference();
        educationPreference2.setUserId(1L);

        EducationPreference educationPreferenceNull = new EducationPreference();
        educationPreferenceNull.setUserId(null);

        EducationPreference educationPreference1AllFields = new EducationPreference();
        educationPreference1AllFields.setUserId(1L);
        educationPreference1AllFields.setHighestDegree(new EducationDegree("Bachelor"));
        educationPreference1AllFields.setConcentration("Computer Science");
        educationPreference1AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(educationPreference1, educationPreference1),
                Arguments.of(educationPreference1, educationPreference2),
                Arguments.of(educationPreferenceNull, educationPreferenceNull),
                Arguments.of(educationPreference1, educationPreference1AllFields));
    }
}
