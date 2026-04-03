package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChildrenPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentChildrenPreferences")
    public void testChildrenPreferenceInequality(ChildrenPreference testChildrenPreference1,
            ChildrenPreference testChildrenPreference2) {
        assertNotEquals(testChildrenPreference1, testChildrenPreference2,
                "Different children preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildrenPreferences")
    public void testChildrenPreferenceEquality(ChildrenPreference testChildrenPreference1,
            ChildrenPreference testChildrenPreference2) {
        assertEquals(testChildrenPreference1, testChildrenPreference2, "Identical children preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildrenPreferences")
    public void testChildrenPreferenceHashcodeEquality(ChildrenPreference testChildrenPreference1,
            ChildrenPreference testChildrenPreference2) {
        assertEquals(testChildrenPreference1.hashCode(), testChildrenPreference2.hashCode(),
                "Identical children preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentChildrenPreferences() {
        ChildrenPreference childrenPreference1 = new ChildrenPreference();
        childrenPreference1.setUserId(1L);

        ChildrenPreference childrenPreference2 = new ChildrenPreference();
        childrenPreference2.setUserId(2L);

        ChildrenPreference childrenPreferenceNull = new ChildrenPreference();
        childrenPreferenceNull.setUserId(null);

        ChildrenPreference childrenPreference1AllFields = new ChildrenPreference();
        childrenPreference1AllFields.setUserId(1L);
        childrenPreference1AllFields.setMoreChildren(true);

        ChildrenPreference childrenPreference2AllFields = new ChildrenPreference();
        childrenPreference2AllFields.setUserId(2L);
        childrenPreference2AllFields.setMoreChildren(true);

        return Stream.of(
                Arguments.of(childrenPreference1, childrenPreference2),
                Arguments.of(childrenPreference1, childrenPreferenceNull),
                Arguments.of(childrenPreference1, null),
                Arguments.of(childrenPreference1AllFields, childrenPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalChildrenPreferences() {
        ChildrenPreference childrenPreference1 = new ChildrenPreference();
        childrenPreference1.setUserId(1L);

        ChildrenPreference childrenPreference2 = new ChildrenPreference();
        childrenPreference2.setUserId(1L);

        ChildrenPreference childrenPreferenceNull = new ChildrenPreference();
        childrenPreferenceNull.setUserId(null);

        ChildrenPreference childrenPreference1AllFields = new ChildrenPreference();
        childrenPreference1AllFields.setUserId(1L);
        childrenPreference1AllFields.setMoreChildren(true);

        return Stream.of(
                Arguments.of(childrenPreference1, childrenPreference1),
                Arguments.of(childrenPreference1, childrenPreference2),
                Arguments.of(childrenPreferenceNull, childrenPreferenceNull),
                Arguments.of(childrenPreference1, childrenPreference1AllFields));
    }
}
