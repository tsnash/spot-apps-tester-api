package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VicePreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentVicePreferences")
    public void testVicePreferenceInequality(VicePreference testVicePreference1,
            VicePreference testVicePreference2) {
        assertNotEquals(testVicePreference1, testVicePreference2,
                "Different vice preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalVicePreferences")
    public void testVicePreferenceEquality(VicePreference testVicePreference1,
            VicePreference testVicePreference2) {
        assertEquals(testVicePreference1, testVicePreference2, "Identical vice preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalVicePreferences")
    public void testVicePreferenceHashcodeEquality(VicePreference testVicePreference1,
            VicePreference testVicePreference2) {
        assertEquals(testVicePreference1.hashCode(), testVicePreference2.hashCode(),
                "Identical vice preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentVicePreferences() {
        VicePreference vicePreference1 = new VicePreference();
        vicePreference1.setUserId(1L);

        VicePreference vicePreference2 = new VicePreference();
        vicePreference2.setUserId(2L);

        VicePreference vicePreferenceNull = new VicePreference();
        vicePreferenceNull.setUserId(null);

        VicePreference vicePreference1AllFields = new VicePreference();
        vicePreference1AllFields.setUserId(1L);
        vicePreference1AllFields.setImportance(5);

        VicePreference vicePreference2AllFields = new VicePreference();
        vicePreference2AllFields.setUserId(2L);
        vicePreference2AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(vicePreference1, vicePreference2),
                Arguments.of(vicePreference1, vicePreferenceNull),
                Arguments.of(vicePreference1, null),
                Arguments.of(vicePreference1AllFields, vicePreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalVicePreferences() {
        VicePreference vicePreference1 = new VicePreference();
        vicePreference1.setUserId(1L);

        VicePreference vicePreference2 = new VicePreference();
        vicePreference2.setUserId(1L);

        VicePreference vicePreferenceNull = new VicePreference();
        vicePreferenceNull.setUserId(null);

        VicePreference vicePreference1AllFields = new VicePreference();
        vicePreference1AllFields.setUserId(1L);
        vicePreference1AllFields.setImportance(5);

        return Stream.of(
                Arguments.of(vicePreference1, vicePreference1),
                Arguments.of(vicePreference1, vicePreference2),
                Arguments.of(vicePreferenceNull, vicePreferenceNull),
                Arguments.of(vicePreference1, vicePreference1AllFields));
    }
}
