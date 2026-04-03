package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReligionPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentReligionPreferences")
    public void testReligionPreferenceInequality(ReligionPreference testReligionPreference1,
            ReligionPreference testReligionPreference2) {
        assertNotEquals(testReligionPreference1, testReligionPreference2,
                "Different religion preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalReligionPreferences")
    public void testReligionPreferenceEquality(ReligionPreference testReligionPreference1,
            ReligionPreference testReligionPreference2) {
        assertEquals(testReligionPreference1, testReligionPreference2, "Identical religion preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalReligionPreferences")
    public void testReligionPreferenceHashcodeEquality(ReligionPreference testReligionPreference1,
            ReligionPreference testReligionPreference2) {
        assertEquals(testReligionPreference1.hashCode(), testReligionPreference2.hashCode(),
                "Identical religion preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentReligionPreferences() {
        ReligionPreference religionPreference1 = new ReligionPreference();
        religionPreference1.setUserId(1L);

        ReligionPreference religionPreference2 = new ReligionPreference();
        religionPreference2.setUserId(2L);

        ReligionPreference religionPreferenceNull = new ReligionPreference();
        religionPreferenceNull.setUserId(null);

        ReligionPreference religionPreference1AllFields = new ReligionPreference();
        religionPreference1AllFields.setUserId(1L);
        religionPreference1AllFields.setReligion(new Religion("Christianity", "Catholic"));
        religionPreference1AllFields.setImportance(5);
        religionPreference1AllFields.setSameReligion(true);

        ReligionPreference religionPreference2AllFields = new ReligionPreference();
        religionPreference2AllFields.setUserId(2L);
        religionPreference2AllFields.setReligion(new Religion("Christianity", "Catholic"));
        religionPreference2AllFields.setImportance(5);
        religionPreference2AllFields.setSameReligion(true);

        return Stream.of(
                Arguments.of(religionPreference1, religionPreference2),
                Arguments.of(religionPreference1, religionPreferenceNull),
                Arguments.of(religionPreference1, null),
                Arguments.of(religionPreference1AllFields, religionPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalReligionPreferences() {
        ReligionPreference religionPreference1 = new ReligionPreference();
        religionPreference1.setUserId(1L);

        ReligionPreference religionPreference2 = new ReligionPreference();
        religionPreference2.setUserId(1L);

        ReligionPreference religionPreferenceNull = new ReligionPreference();
        religionPreferenceNull.setUserId(null);

        ReligionPreference religionPreference1AllFields = new ReligionPreference();
        religionPreference1AllFields.setUserId(1L);
        religionPreference1AllFields.setReligion(new Religion("Christianity", "Catholic"));
        religionPreference1AllFields.setImportance(5);
        religionPreference1AllFields.setSameReligion(true);

        return Stream.of(
                Arguments.of(religionPreference1, religionPreference1),
                Arguments.of(religionPreference1, religionPreference2),
                Arguments.of(religionPreferenceNull, religionPreferenceNull),
                Arguments.of(religionPreference1, religionPreference1AllFields));
    }
}
