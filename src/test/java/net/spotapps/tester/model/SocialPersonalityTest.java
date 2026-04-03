package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SocialPersonalityTest {

    @ParameterizedTest
    @MethodSource("provideDifferentSocialPersonalities")
    public void testSocialPersonalityInequality(SocialPersonality testSocialPersonality1,
            SocialPersonality testSocialPersonality2) {
        assertNotEquals(testSocialPersonality1, testSocialPersonality2,
                "Different social personalities should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSocialPersonalities")
    public void testSocialPersonalityEquality(SocialPersonality testSocialPersonality1,
            SocialPersonality testSocialPersonality2) {
        assertEquals(testSocialPersonality1, testSocialPersonality2, "Identical social personalities should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSocialPersonalities")
    public void testSocialPersonalityHashcodeEquality(SocialPersonality testSocialPersonality1,
            SocialPersonality testSocialPersonality2) {
        assertEquals(testSocialPersonality1.hashCode(), testSocialPersonality2.hashCode(),
                "Identical social personalities should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentSocialPersonalities() {
        SocialPersonality socialPersonality1 = new SocialPersonality();
        socialPersonality1.setUserId(1L);

        SocialPersonality socialPersonality2 = new SocialPersonality();
        socialPersonality2.setUserId(2L);

        SocialPersonality socialPersonalityNull = new SocialPersonality();
        socialPersonalityNull.setUserId(null);

        SocialPersonality socialPersonality1AllFields = new SocialPersonality();
        socialPersonality1AllFields.setUserId(1L);
        socialPersonality1AllFields.setOpenness(new PersonalityScale("1"));
        socialPersonality1AllFields.setConscientiousness(new PersonalityScale("2"));
        socialPersonality1AllFields.setExtraversion(new PersonalityScale("3"));
        socialPersonality1AllFields.setAgreeableness(new PersonalityScale("4"));
        socialPersonality1AllFields.setNeuroticism(new PersonalityScale("5"));

        SocialPersonality socialPersonality2AllFields = new SocialPersonality();
        socialPersonality2AllFields.setUserId(2L);
        socialPersonality2AllFields.setOpenness(new PersonalityScale("1"));
        socialPersonality2AllFields.setConscientiousness(new PersonalityScale("2"));
        socialPersonality2AllFields.setExtraversion(new PersonalityScale("3"));
        socialPersonality2AllFields.setAgreeableness(new PersonalityScale("4"));
        socialPersonality2AllFields.setNeuroticism(new PersonalityScale("5"));

        return Stream.of(
                Arguments.of(socialPersonality1, socialPersonality2),
                Arguments.of(socialPersonality1, socialPersonalityNull),
                Arguments.of(socialPersonality1, null),
                Arguments.of(socialPersonality1AllFields, socialPersonality2AllFields));
    }

    private static Stream<Arguments> provideIdenticalSocialPersonalities() {
        SocialPersonality socialPersonality1 = new SocialPersonality();
        socialPersonality1.setUserId(1L);

        SocialPersonality socialPersonality2 = new SocialPersonality();
        socialPersonality2.setUserId(1L);

        SocialPersonality socialPersonalityNull = new SocialPersonality();
        socialPersonalityNull.setUserId(null);

        SocialPersonality socialPersonality1AllFields = new SocialPersonality();
        socialPersonality1AllFields.setUserId(1L);
        socialPersonality1AllFields.setOpenness(new PersonalityScale("1"));
        socialPersonality1AllFields.setConscientiousness(new PersonalityScale("2"));
        socialPersonality1AllFields.setExtraversion(new PersonalityScale("3"));
        socialPersonality1AllFields.setAgreeableness(new PersonalityScale("4"));
        socialPersonality1AllFields.setNeuroticism(new PersonalityScale("5"));

        return Stream.of(
                Arguments.of(socialPersonality1, socialPersonality1),
                Arguments.of(socialPersonality1, socialPersonality2),
                Arguments.of(socialPersonalityNull, socialPersonalityNull),
                Arguments.of(socialPersonality1, socialPersonality1AllFields));
    }
}
