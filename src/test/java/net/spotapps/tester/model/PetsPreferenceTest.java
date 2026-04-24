package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PetsPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentPetsPreferences")
    public void testPetsPreferenceInequality(PetsPreference testPetsPreference1,
            PetsPreference testPetsPreference2) {
        assertNotEquals(testPetsPreference1, testPetsPreference2,
                "Different pets preferences should not be equal");
        if (testPetsPreference2 != null) {
            assertNotEquals(testPetsPreference2, testPetsPreference1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPetsPreferences")
    public void testPetsPreferenceEquality(PetsPreference testPetsPreference1,
            PetsPreference testPetsPreference2) {
        assertEquals(testPetsPreference1, testPetsPreference2, "Identical pets preferences should be equal");
        assertEquals(testPetsPreference2, testPetsPreference1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPetsPreferences")
    public void testPetsPreferenceHashcodeEquality(PetsPreference testPetsPreference1,
            PetsPreference testPetsPreference2) {
        assertEquals(testPetsPreference1.hashCode(), testPetsPreference2.hashCode(),
                "Identical pets preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentPetsPreferences() {
        PetsPreference petsPreference1 = new PetsPreference();
        petsPreference1.setUserId(1L);

        PetsPreference petsPreference2 = new PetsPreference();
        petsPreference2.setUserId(2L);

        PetsPreference petsPreferenceNull = new PetsPreference();
        petsPreferenceNull.setUserId(null);

        PetsPreference petsPreferenceNull2 = new PetsPreference();
        petsPreferenceNull2.setUserId(null);

        PetsPreference petsPreference1AllFields = new PetsPreference();
        petsPreference1AllFields.setUserId(1L);
        petsPreference1AllFields.setImportance(5);
        petsPreference1AllFields.setIsAllowed(true);

        PetsPreference petsPreference2AllFields = new PetsPreference();
        petsPreference2AllFields.setUserId(2L);
        petsPreference2AllFields.setImportance(5);
        petsPreference2AllFields.setIsAllowed(true);

        return Stream.of(
                Arguments.of(petsPreference1, petsPreference2),
                Arguments.of(petsPreference1, petsPreferenceNull),
                Arguments.of(petsPreferenceNull, petsPreferenceNull2),
                Arguments.of(petsPreference1, null),
                Arguments.of(petsPreference1AllFields, petsPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalPetsPreferences() {
        PetsPreference petsPreference1 = new PetsPreference();
        petsPreference1.setUserId(1L);

        PetsPreference petsPreference2 = new PetsPreference();
        petsPreference2.setUserId(1L);

        PetsPreference petsPreference1AllFields = new PetsPreference();
        petsPreference1AllFields.setUserId(1L);
        petsPreference1AllFields.setImportance(5);
        petsPreference1AllFields.setIsAllowed(true);

        return Stream.of(
                Arguments.of(petsPreference1, petsPreference1),
                Arguments.of(petsPreference1, petsPreference2),
                Arguments.of(petsPreference1, petsPreference1AllFields));
    }
}
