package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LifeStageTest {

    @ParameterizedTest
    @MethodSource("provideDifferentLifeStages")
    public void testLifeStageInequality(LifeStage testLifeStage1, LifeStage testLifeStage2) {
        assertNotEquals(testLifeStage1, testLifeStage2, "Different life stages should not be equal");
        if (testLifeStage2 != null) {
            assertNotEquals(testLifeStage2, testLifeStage1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLifeStages")
    public void testLifeStageEquality(LifeStage testLifeStage1, LifeStage testLifeStage2) {
        assertEquals(testLifeStage1, testLifeStage2, "Identical life stages should be equal");
        assertEquals(testLifeStage2, testLifeStage1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalLifeStages")
    public void testLifeStageHashcodeEquality(LifeStage testLifeStage1, LifeStage testLifeStage2) {
        assertEquals(testLifeStage1.hashCode(), testLifeStage2.hashCode(),
                "Identical life stages should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentLifeStages() {
        LifeStage lifeStage1 = new LifeStage("Infant");
        lifeStage1.setLifeStageId(1L);

        LifeStage lifeStage2 = new LifeStage("Toddler");
        lifeStage2.setLifeStageId(2L);

        LifeStage lifeStage3 = new LifeStage("Toddler");
        lifeStage3.setLifeStageId(1L);

        LifeStage lifeStageNull = null;

        return Stream.of(
                Arguments.of(lifeStage1, lifeStage2),
                Arguments.of(lifeStage1, lifeStage3),
                Arguments.of(lifeStage1, lifeStageNull));
    }

    private static Stream<Arguments> provideIdenticalLifeStages() {
        LifeStage lifeStage1 = new LifeStage("Infant");
        lifeStage1.setLifeStageId(1L);

        LifeStage lifeStage2 = new LifeStage("Infant");
        lifeStage2.setLifeStageId(2L);

        return Stream.of(
                Arguments.of(lifeStage1, lifeStage1),
                Arguments.of(lifeStage1, lifeStage2));
    }
}
