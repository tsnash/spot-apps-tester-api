package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GenderPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentGenderPreferences")
    public void testGenderPreferenceInequality(GenderPreference testGenderPreference1,
            GenderPreference testGenderPreference2) {
        assertNotEquals(testGenderPreference1, testGenderPreference2, "Different gender preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalGenderPreferences")
    public void testGenderPreferenceEquality(GenderPreference testGenderPreference1,
            GenderPreference testGenderPreference2) {
        assertEquals(testGenderPreference1, testGenderPreference2, "Identical gender preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalGenderPreferences")
    public void testGenderPreferenceHashcodeEquality(GenderPreference testGenderPreference1,
            GenderPreference testGenderPreference2) {
        assertEquals(testGenderPreference1.hashCode(), testGenderPreference2.hashCode(),
                "Identical gender preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentGenderPreferences() {
        GenderPreference genderPreference1 = new GenderPreference();
        genderPreference1.setUserId(1L);

        GenderPreference genderPreference2 = new GenderPreference();
        genderPreference2.setUserId(2L);

        GenderPreference genderPreferenceNull = new GenderPreference();
        genderPreferenceNull.setUserId(null);

        GenderPreference genderPreference1AllFields = new GenderPreference();
        genderPreference1AllFields.setUserId(1L);
        genderPreference1AllFields.setGender(new Gender("Man"));
        genderPreference1AllFields.setTrans(true);
        genderPreference1AllFields.setOrientation(new Orientation("Straight"));

        GenderPreference genderPreference2AllFields = new GenderPreference();
        genderPreference2AllFields.setUserId(2L);
        genderPreference2AllFields.setGender(new Gender("Man"));
        genderPreference2AllFields.setTrans(true);
        genderPreference2AllFields.setOrientation(new Orientation("Straight"));

        return Stream.of(
                Arguments.of(genderPreference1, genderPreference2),
                Arguments.of(genderPreference1, genderPreferenceNull),
                Arguments.of(genderPreference1, null),
                Arguments.of(genderPreference1AllFields, genderPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalGenderPreferences() {
        GenderPreference genderPreference1 = new GenderPreference();
        genderPreference1.setUserId(1L);

        GenderPreference genderPreference2 = new GenderPreference();
        genderPreference2.setUserId(1L);

        GenderPreference genderPreferenceNull = new GenderPreference();
        genderPreferenceNull.setUserId(null);

        GenderPreference genderPreference1AllFields = new GenderPreference();
        genderPreference1AllFields.setUserId(1L);
        genderPreference1AllFields.setGender(new Gender("Man"));
        genderPreference1AllFields.setTrans(true);
        genderPreference1AllFields.setOrientation(new Orientation("Straight"));

        return Stream.of(
                Arguments.of(genderPreference1, genderPreference1),
                Arguments.of(genderPreference1, genderPreference2),
                Arguments.of(genderPreferenceNull, genderPreferenceNull),
                Arguments.of(genderPreference1, genderPreference1AllFields));
    }
}
