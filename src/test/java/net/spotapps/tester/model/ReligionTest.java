package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReligionTest {

    @ParameterizedTest
    @MethodSource("provideDifferentReligions")
    public void testReligionInequality(Religion testReligion1, Religion testReligion2) {
        assertNotEquals(testReligion1, testReligion2, "Different religions should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalReligions")
    public void testReligionEquality(Religion testReligion1, Religion testReligion2) {
        assertEquals(testReligion1, testReligion2, "Identical religions should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalReligions")
    public void testReligionHashcodeEquality(Religion testReligion1, Religion testReligion2) {
        assertEquals(testReligion1.hashCode(), testReligion2.hashCode(),
                "Identical religions should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentReligions() {
        Religion religion1 = new Religion("Christianity", "Catholic");
        religion1.setReligionId(1L);

        Religion religion2 = new Religion("Christianity", "Protestant");
        religion2.setReligionId(2L);

        Religion religion3 = new Religion("Islam", "Sunni");
        religion3.setReligionId(3L);

        Religion religionNull = null;

        return Stream.of(
                Arguments.of(religion1, religion2),
                Arguments.of(religion1, religion3),
                Arguments.of(religion1, religionNull));
    }

    private static Stream<Arguments> provideIdenticalReligions() {
        Religion religion1 = new Religion("Christianity", "Catholic");
        religion1.setReligionId(1L);

        Religion religion2 = new Religion("Christianity", "Catholic");
        religion2.setReligionId(2L);

        return Stream.of(
                Arguments.of(religion1, religion1),
                Arguments.of(religion1, religion2));
    }
}
