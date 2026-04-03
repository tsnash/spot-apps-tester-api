package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RelationshipPracticeTest {

    @ParameterizedTest
    @MethodSource("provideDifferentRelationshipPractices")
    public void testRelationshipPracticeInequality(RelationshipPractice testRelationshipPractice1, RelationshipPractice testRelationshipPractice2) {
        assertNotEquals(testRelationshipPractice1, testRelationshipPractice2, "Different relationship practices should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipPractices")
    public void testRelationshipPracticeEquality(RelationshipPractice testRelationshipPractice1, RelationshipPractice testRelationshipPractice2) {
        assertEquals(testRelationshipPractice1, testRelationshipPractice2, "Identical relationship practices should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipPractices")
    public void testRelationshipPracticeHashcodeEquality(RelationshipPractice testRelationshipPractice1, RelationshipPractice testRelationshipPractice2) {
        assertEquals(testRelationshipPractice1.hashCode(), testRelationshipPractice2.hashCode(),
                "Identical relationship practices should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentRelationshipPractices() {
        RelationshipPractice relationshipPractice1 = new RelationshipPractice("Monogamy");
        relationshipPractice1.setRelationshipPracticeId(1L);

        RelationshipPractice relationshipPractice2 = new RelationshipPractice("Polyamory");
        relationshipPractice2.setRelationshipPracticeId(2L);

        RelationshipPractice relationshipPracticeNull = null;

        return Stream.of(
                Arguments.of(relationshipPractice1, relationshipPractice2),
                Arguments.of(relationshipPractice1, relationshipPracticeNull));
    }

    private static Stream<Arguments> provideIdenticalRelationshipPractices() {
        RelationshipPractice relationshipPractice1 = new RelationshipPractice("Monogamy");
        relationshipPractice1.setRelationshipPracticeId(1L);

        RelationshipPractice relationshipPractice2 = new RelationshipPractice("Monogamy");
        relationshipPractice2.setRelationshipPracticeId(2L);

        return Stream.of(
                Arguments.of(relationshipPractice1, relationshipPractice1),
                Arguments.of(relationshipPractice1, relationshipPractice2));
    }
}
