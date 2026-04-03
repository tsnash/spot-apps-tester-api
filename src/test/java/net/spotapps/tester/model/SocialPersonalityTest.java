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
        if (testSocialPersonality2 != null) {
            assertNotEquals(testSocialPersonality2, testSocialPersonality1, "Inequality should be symmetric");
        }
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSocialPersonalities")
    public void testSocialPersonalityEquality(SocialPersonality testSocialPersonality1,
            SocialPersonality testSocialPersonality2) {
        assertEquals(testSocialPersonality1, testSocialPersonality2, "Identical social personalities should be equal");
        assertEquals(testSocialPersonality2, testSocialPersonality1, "Equality should be symmetric");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalSocialPersonalities")
    public void testSocialPersonalityHashcodeEquality(SocialPersonality testSocialPersonality1,
            SocialPersonality testSocialPersonality2) {
        assertEquals(testSocialPersonality1.hashCode(), testSocialPersonality2.hashCode(),
                "Identical social personalities should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentSocialPersonalities() {
        SocialPersonality socialPersonality1 = createSocialPersonality(1L, "1", "2", "3", "4", "5");
        SocialPersonality socialPersonality2 = createSocialPersonality(2L, "1", "2", "3", "4", "5");
        SocialPersonality socialPersonalityNull = createSocialPersonality(null, null, null, null, null, null);
        SocialPersonality socialPersonalityNull2 = createSocialPersonality(null, null, null, null, null, null);

        SocialPersonality socialPersonality1AllFields = createSocialPersonality(1L, "1", "2", "3", "4", "5");
        SocialPersonality socialPersonality2AllFields = createSocialPersonality(2L, "1", "2", "3", "4", "5");

        return Stream.of(
                Arguments.of(socialPersonality1, socialPersonality2),
                Arguments.of(socialPersonality1, socialPersonalityNull),
                Arguments.of(socialPersonalityNull, socialPersonalityNull2),
                Arguments.of(socialPersonality1, null),
                Arguments.of(socialPersonality1AllFields, socialPersonality2AllFields));
    }

    private static Stream<Arguments> provideIdenticalSocialPersonalities() {
        SocialPersonality socialPersonality1 = createSocialPersonality(1L, null, null, null, null, null);
        SocialPersonality socialPersonality2 = createSocialPersonality(1L, null, null, null, null, null);
        SocialPersonality socialPersonality1AllFields = createSocialPersonality(1L, "1", "2", "3", "4", "5");

        return Stream.of(
                Arguments.of(socialPersonality1, socialPersonality1),
                Arguments.of(socialPersonality1, socialPersonality2),
                Arguments.of(socialPersonality1, socialPersonality1AllFields));
    }

    private static SocialPersonality createSocialPersonality(Long userId, String openness, String conscientiousness, String extraversion, String agreeableness, String neuroticism) {
        SocialPersonality sp = new SocialPersonality();
        sp.setUserId(userId);
        if (openness != null) sp.setOpenness(new PersonalityScale(openness));
        if (conscientiousness != null) sp.setConscientiousness(new PersonalityScale(conscientiousness));
        if (extraversion != null) sp.setExtraversion(new PersonalityScale(extraversion));
        if (agreeableness != null) sp.setAgreeableness(new PersonalityScale(agreeableness));
        if (neuroticism != null) sp.setNeuroticism(new PersonalityScale(neuroticism));
        return sp;
    }
}
