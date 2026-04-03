package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ViceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentVices")
    public void testViceInequality(Vice testVice1, Vice testVice2) {
        assertNotEquals(testVice1, testVice2, "Different vices should not be equal");
        if (testVice2 != null) {
            assertNotEquals(testVice2, testVice1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalVices")
    public void testViceEquality(Vice testVice1, Vice testVice2) {
        assertEquals(testVice1, testVice2, "Identical vices should be equal");
        assertEquals(testVice2, testVice1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalVices")
    public void testViceHashcodeEquality(Vice testVice1, Vice testVice2) {
        assertEquals(testVice1.hashCode(), testVice2.hashCode(),
                "Identical vices should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentVices() {
        Vice vice1 = new Vice();
        vice1.setViceId(1L);

        Vice vice2 = new Vice();
        vice2.setViceId(2L);

        Vice viceNull = new Vice();
        viceNull.setViceId(null);

        Vice viceNull2 = new Vice();
        viceNull2.setViceId(null);

        Vice vice1AllFields = new Vice();
        vice1AllFields.setViceId(1L);
        vice1AllFields.setViceType(new ViceType("Smoking"));
        vice1AllFields.setFrequency(new ViceFrequency("Never"));

        Vice vice2AllFields = new Vice();
        vice2AllFields.setViceId(2L);
        vice2AllFields.setViceType(new ViceType("Smoking"));
        vice2AllFields.setFrequency(new ViceFrequency("Never"));

        return Stream.of(
                Arguments.of(vice1, vice2),
                Arguments.of(vice1, viceNull),
                Arguments.of(viceNull, viceNull2),
                Arguments.of(vice1, null),
                Arguments.of(vice1AllFields, vice2AllFields));
    }

    private static Stream<Arguments> provideIdenticalVices() {
        Vice vice1 = new Vice();
        vice1.setViceId(1L);

        Vice vice2 = new Vice();
        vice2.setViceId(1L);

        Vice vice1AllFields = new Vice();
        vice1AllFields.setViceId(1L);
        vice1AllFields.setViceType(new ViceType("Smoking"));
        vice1AllFields.setFrequency(new ViceFrequency("Never"));

        return Stream.of(
                Arguments.of(vice1, vice1),
                Arguments.of(vice1, vice2),
                Arguments.of(vice1, vice1AllFields));
    }
}
