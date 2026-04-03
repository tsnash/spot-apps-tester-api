package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PetTypeTest {

    @ParameterizedTest
    @MethodSource("provideDifferentPetTypes")
    public void testPetTypeInequality(PetType testPetType1, PetType testPetType2) {
        assertNotEquals(testPetType1, testPetType2, "Different pet types should not be equal");
        if (testPetType2 != null) {
            assertNotEquals(testPetType2, testPetType1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPetTypes")
    public void testPetTypeEquality(PetType testPetType1, PetType testPetType2) {
        assertEquals(testPetType1, testPetType2, "Identical pet types should be equal");
        assertEquals(testPetType2, testPetType1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPetTypes")
    public void testPetTypeHashcodeEquality(PetType testPetType1, PetType testPetType2) {
        assertEquals(testPetType1.hashCode(), testPetType2.hashCode(),
                "Identical pet types should have equal hash codes");
    }

    @Test
    public void testEqualsWithDifferentType() {
        PetType petType = new PetType("Dog");
        petType.setPetTypeId(1L);
        assertNotEquals(petType, "Not a PetType");
        assertNotEquals(petType, new Object());
    }

    private static Stream<Arguments> provideDifferentPetTypes() {
        PetType petType1 = new PetType("Dog");
        petType1.setPetTypeId(1L);

        PetType petType2 = new PetType("Cat");
        petType2.setPetTypeId(2L);

        PetType petTypeNull = null;

        return Stream.of(
                Arguments.of(petType1, petType2),
                Arguments.of(petType1, petTypeNull));
    }

    private static Stream<Arguments> provideIdenticalPetTypes() {
        PetType petType1 = new PetType("Dog");
        petType1.setPetTypeId(1L);

        PetType petType2 = new PetType("Dog");
        petType2.setPetTypeId(2L);

        return Stream.of(
                Arguments.of(petType1, petType1),
                Arguments.of(petType1, petType2));
    }
}
