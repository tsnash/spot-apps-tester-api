package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DietaryRestrictionTest {

    @ParameterizedTest
    @MethodSource("provideDifferentDietaryRestrictions")
    public void testDietaryRestrictionInequality(DietaryRestriction testDietaryRestriction1, DietaryRestriction testDietaryRestriction2) {
        assertNotEquals(testDietaryRestriction1, testDietaryRestriction2, "Different dietary restrictions should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalDietaryRestrictions")
    public void testDietaryRestrictionEquality(DietaryRestriction testDietaryRestriction1, DietaryRestriction testDietaryRestriction2) {
        assertEquals(testDietaryRestriction1, testDietaryRestriction2, "Identical dietary restrictions should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalDietaryRestrictions")
    public void testDietaryRestrictionHashcodeEquality(DietaryRestriction testDietaryRestriction1, DietaryRestriction testDietaryRestriction2) {
        assertEquals(testDietaryRestriction1.hashCode(), testDietaryRestriction2.hashCode(),
                "Identical dietary restrictions should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentDietaryRestrictions() {
        return Stream.of(
                Arguments.of(DietaryRestriction.VEGAN, DietaryRestriction.VEGETARIAN),
                Arguments.of(DietaryRestriction.VEGAN, DietaryRestriction.HALAL),
                Arguments.of(DietaryRestriction.VEGAN, null));
    }

    private static Stream<Arguments> provideIdenticalDietaryRestrictions() {
        return Stream.of(
                Arguments.of(DietaryRestriction.VEGAN, DietaryRestriction.VEGAN),
                Arguments.of(DietaryRestriction.VEGETARIAN, DietaryRestriction.VEGETARIAN));
    }
}
