package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ViceTypeTest {

    @ParameterizedTest
    @MethodSource("provideDifferentViceTypes")
    public void testViceTypeInequality(ViceType testViceType1, ViceType testViceType2) {
        assertNotEquals(testViceType1, testViceType2, "Different vice types should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalViceTypes")
    public void testViceTypeEquality(ViceType testViceType1, ViceType testViceType2) {
        assertEquals(testViceType1, testViceType2, "Identical vice types should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalViceTypes")
    public void testViceTypeHashcodeEquality(ViceType testViceType1, ViceType testViceType2) {
        assertEquals(testViceType1.hashCode(), testViceType2.hashCode(),
                "Identical vice types should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentViceTypes() {
        ViceType viceType1 = new ViceType("Smoking");
        viceType1.setViceTypeId(1L);

        ViceType viceType2 = new ViceType("Drinking");
        viceType2.setViceTypeId(2L);

        ViceType viceTypeNull = null;

        return Stream.of(
                Arguments.of(viceType1, viceType2),
                Arguments.of(viceType1, viceTypeNull));
    }

    private static Stream<Arguments> provideIdenticalViceTypes() {
        ViceType viceType1 = new ViceType("Smoking");
        viceType1.setViceTypeId(1L);

        ViceType viceType2 = new ViceType("Smoking");
        viceType2.setViceTypeId(2L);

        return Stream.of(
                Arguments.of(viceType1, viceType1),
                Arguments.of(viceType1, viceType2));
    }
}
