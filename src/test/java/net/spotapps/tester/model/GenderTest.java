package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GenderTest {

    @ParameterizedTest
    @MethodSource("provideDifferentGenders")
    public void testGenderInequality(Gender testGender1, Gender testGender2) {
        assertNotEquals(testGender1, testGender2, "Different genders should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalGenders")
    public void testGenderEquality(Gender testGender1, Gender testGender2) {
        assertEquals(testGender1, testGender2, "Identical genders should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalGenders")
    public void testGenderHashcodeEquality(Gender testGender1, Gender testGender2) {
        assertEquals(testGender1.hashCode(), testGender2.hashCode(),
                "Identical genders should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentGenders() {
        Gender gender1 = new Gender("Man");
        gender1.setGenderId(1L);

        Gender gender2 = new Gender("Woman");
        gender2.setGenderId(2L);

        Gender genderNull = null;

        return Stream.of(
                Arguments.of(gender1, gender2),
                Arguments.of(gender1, genderNull));
    }

    private static Stream<Arguments> provideIdenticalGenders() {
        Gender gender1 = new Gender("Man");
        gender1.setGenderId(1L);

        Gender gender2 = new Gender("Man");
        gender2.setGenderId(2L);

        return Stream.of(
                Arguments.of(gender1, gender1),
                Arguments.of(gender1, gender2));
    }
}
