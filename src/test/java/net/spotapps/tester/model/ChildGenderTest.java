package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChildGenderTest {

    @ParameterizedTest
    @MethodSource("provideDifferentChildGenders")
    public void testChildGenderInequality(ChildGender testChildGender1, ChildGender testChildGender2) {
        assertNotEquals(testChildGender1, testChildGender2, "Different child genders should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildGenders")
    public void testChildGenderEquality(ChildGender testChildGender1, ChildGender testChildGender2) {
        assertEquals(testChildGender1, testChildGender2, "Identical child genders should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildGenders")
    public void testChildGenderHashcodeEquality(ChildGender testChildGender1, ChildGender testChildGender2) {
        assertEquals(testChildGender1.hashCode(), testChildGender2.hashCode(),
                "Identical child genders should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentChildGenders() {
        ChildGender childGender1 = new ChildGender("Male");
        childGender1.setChildGenderId(1L);

        ChildGender childGender2 = new ChildGender("Female");
        childGender2.setChildGenderId(2L);

        ChildGender childGenderNull = null;

        return Stream.of(
                Arguments.of(childGender1, childGender2),
                Arguments.of(childGender1, childGenderNull));
    }

    private static Stream<Arguments> provideIdenticalChildGenders() {
        ChildGender childGender1 = new ChildGender("Male");
        childGender1.setChildGenderId(1L);

        ChildGender childGender2 = new ChildGender("Male");
        childGender2.setChildGenderId(2L);

        return Stream.of(
                Arguments.of(childGender1, childGender1),
                Arguments.of(childGender1, childGender2));
    }
}
