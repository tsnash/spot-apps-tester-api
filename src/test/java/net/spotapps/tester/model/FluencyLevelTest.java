package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FluencyLevelTest {

    @ParameterizedTest
    @MethodSource("provideDifferentFluencyLevels")
    public void testFluencyLevelInequality(FluencyLevel testFluencyLevel1, FluencyLevel testFluencyLevel2) {
        assertNotEquals(testFluencyLevel1, testFluencyLevel2, "Different fluency levels should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalFluencyLevels")
    public void testFluencyLevelEquality(FluencyLevel testFluencyLevel1, FluencyLevel testFluencyLevel2) {
        assertEquals(testFluencyLevel1, testFluencyLevel2, "Identical fluency levels should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalFluencyLevels")
    public void testFluencyLevelHashcodeEquality(FluencyLevel testFluencyLevel1, FluencyLevel testFluencyLevel2) {
        assertEquals(testFluencyLevel1.hashCode(), testFluencyLevel2.hashCode(),
                "Identical fluency levels should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentFluencyLevels() {
        FluencyLevel fluencyLevel1 = new FluencyLevel("Native");
        fluencyLevel1.setFluencyLevelId(1L);

        FluencyLevel fluencyLevel2 = new FluencyLevel("Fluent");
        fluencyLevel2.setFluencyLevelId(2L);

        FluencyLevel fluencyLevelNull = null;

        return Stream.of(
                Arguments.of(fluencyLevel1, fluencyLevel2),
                Arguments.of(fluencyLevel1, fluencyLevelNull));
    }

    private static Stream<Arguments> provideIdenticalFluencyLevels() {
        FluencyLevel fluencyLevel1 = new FluencyLevel("Native");
        fluencyLevel1.setFluencyLevelId(1L);

        FluencyLevel fluencyLevel2 = new FluencyLevel("Native");
        fluencyLevel2.setFluencyLevelId(2L);

        return Stream.of(
                Arguments.of(fluencyLevel1, fluencyLevel1),
                Arguments.of(fluencyLevel1, fluencyLevel2));
    }
}
