package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ViceFrequencyTest {

    @ParameterizedTest
    @MethodSource("provideDifferentViceFrequencies")
    public void testViceFrequencyInequality(ViceFrequency testViceFrequency1, ViceFrequency testViceFrequency2) {
        assertNotEquals(testViceFrequency1, testViceFrequency2, "Different vice frequencies should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalViceFrequencies")
    public void testViceFrequencyEquality(ViceFrequency testViceFrequency1, ViceFrequency testViceFrequency2) {
        assertEquals(testViceFrequency1, testViceFrequency2, "Identical vice frequencies should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalViceFrequencies")
    public void testViceFrequencyHashcodeEquality(ViceFrequency testViceFrequency1, ViceFrequency testViceFrequency2) {
        assertEquals(testViceFrequency1.hashCode(), testViceFrequency2.hashCode(),
                "Identical vice frequencies should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentViceFrequencies() {
        ViceFrequency viceFrequency1 = new ViceFrequency("Never");
        viceFrequency1.setViceFrequencyId(1L);

        ViceFrequency viceFrequency2 = new ViceFrequency("Sometimes");
        viceFrequency2.setViceFrequencyId(2L);

        ViceFrequency viceFrequencyNull = null;

        return Stream.of(
                Arguments.of(viceFrequency1, viceFrequency2),
                Arguments.of(viceFrequency1, viceFrequencyNull));
    }

    private static Stream<Arguments> provideIdenticalViceFrequencies() {
        ViceFrequency viceFrequency1 = new ViceFrequency("Never");
        viceFrequency1.setViceFrequencyId(1L);

        ViceFrequency viceFrequency2 = new ViceFrequency("Never");
        viceFrequency2.setViceFrequencyId(2L);

        return Stream.of(
                Arguments.of(viceFrequency1, viceFrequency1),
                Arguments.of(viceFrequency1, viceFrequency2));
    }
}
