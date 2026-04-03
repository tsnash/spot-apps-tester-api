package net.spotapps.tester.model;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PetTest {

    @ParameterizedTest
    @MethodSource("provideDifferentPets")
    public void testPetInequality(Pet testPet1, Pet testPet2) {
        ModelTestHelper.assertInequality(testPet1, testPet2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPets")
    public void testPetEquality(Pet testPet1, Pet testPet2) {
        ModelTestHelper.assertEquality(testPet1, testPet2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPets")
    public void testPetHashcodeEquality(Pet testPet1, Pet testPet2) {
        ModelTestHelper.assertHashcodeEquality(testPet1, testPet2);
    }

    private static Stream<Arguments> provideDifferentPets() {
        Pet pet1 = new Pet();
        pet1.setPetId(1L);

        Pet pet2 = new Pet();
        pet2.setPetId(2L);

        Pet petNull = new Pet();
        petNull.setPetId(null);

        Pet petNull2 = new Pet();
        petNull2.setPetId(null);

        Pet pet1AllFields = new Pet();
        pet1AllFields.setPetId(1L);
        pet1AllFields.setPetType(new PetType("Dog"));
        pet1AllFields.setQuantity(2);
        pet1AllFields.setIsAllowed(true);

        Pet pet2AllFields = new Pet();
        pet2AllFields.setPetId(2L);
        pet2AllFields.setPetType(new PetType("Dog"));
        pet2AllFields.setQuantity(2);
        pet2AllFields.setIsAllowed(true);

        return Stream.of(
                Arguments.of(pet1, pet2),
                Arguments.of(pet1, petNull),
                Arguments.of(petNull, petNull2),
                Arguments.of(pet1, null),
                Arguments.of(pet1AllFields, pet2AllFields));
    }

    private static Stream<Arguments> provideIdenticalPets() {
        Pet pet1 = new Pet();
        pet1.setPetId(1L);

        Pet pet2 = new Pet();
        pet2.setPetId(1L);

        Pet pet1AllFields = new Pet();
        pet1AllFields.setPetId(1L);
        pet1AllFields.setPetType(new PetType("Dog"));
        pet1AllFields.setQuantity(2);
        pet1AllFields.setIsAllowed(true);

        return Stream.of(
                Arguments.of(pet1, pet1),
                Arguments.of(pet1, pet2),
                Arguments.of(pet1, pet1AllFields));
    }
}
