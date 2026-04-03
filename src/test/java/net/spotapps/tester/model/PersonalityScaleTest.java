package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PersonalityScaleTest {

    @ParameterizedTest
    @MethodSource("provideDifferentPersonalityScales")
    public void testPersonalityScaleInequality(PersonalityScale testPersonalityScale1, PersonalityScale testPersonalityScale2) {
        assertNotEquals(testPersonalityScale1, testPersonalityScale2, "Different personality scales should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPersonalityScales")
    public void testPersonalityScaleEquality(PersonalityScale testPersonalityScale1, PersonalityScale testPersonalityScale2) {
        assertEquals(testPersonalityScale1, testPersonalityScale2, "Identical personality scales should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalPersonalityScales")
    public void testPersonalityScaleHashcodeEquality(PersonalityScale testPersonalityScale1, PersonalityScale testPersonalityScale2) {
        assertEquals(testPersonalityScale1.hashCode(), testPersonalityScale2.hashCode(),
                "Identical personality scales should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentPersonalityScales() {
        PersonalityScale personalityScale1 = new PersonalityScale("1");
        personalityScale1.setPersonalityScaleId(1L);

        PersonalityScale personalityScale2 = new PersonalityScale("2");
        personalityScale2.setPersonalityScaleId(2L);

        PersonalityScale personalityScaleNull = null;

        return Stream.of(
                Arguments.of(personalityScale1, personalityScale2),
                Arguments.of(personalityScale1, personalityScaleNull));
    }

    private static Stream<Arguments> provideIdenticalPersonalityScales() {
        PersonalityScale personalityScale1 = new PersonalityScale("1");
        personalityScale1.setPersonalityScaleId(1L);

        PersonalityScale personalityScale2 = new PersonalityScale("1");
        personalityScale2.setPersonalityScaleId(2L);

        return Stream.of(
                Arguments.of(personalityScale1, personalityScale1),
                Arguments.of(personalityScale1, personalityScale2));
    }
}
