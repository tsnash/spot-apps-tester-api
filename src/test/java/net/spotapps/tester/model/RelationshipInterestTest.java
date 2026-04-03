package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RelationshipInterestTest {

    @ParameterizedTest
    @MethodSource("provideDifferentRelationshipInterests")
    public void testRelationshipInterestInequality(RelationshipInterest testRelationshipInterest1, RelationshipInterest testRelationshipInterest2) {
        assertNotEquals(testRelationshipInterest1, testRelationshipInterest2, "Different relationship interests should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipInterests")
    public void testRelationshipInterestEquality(RelationshipInterest testRelationshipInterest1, RelationshipInterest testRelationshipInterest2) {
        assertEquals(testRelationshipInterest1, testRelationshipInterest2, "Identical relationship interests should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipInterests")
    public void testRelationshipInterestHashcodeEquality(RelationshipInterest testRelationshipInterest1, RelationshipInterest testRelationshipInterest2) {
        assertEquals(testRelationshipInterest1.hashCode(), testRelationshipInterest2.hashCode(),
                "Identical relationship interests should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentRelationshipInterests() {
        RelationshipInterest relationshipInterest1 = new RelationshipInterest("Friendship");
        relationshipInterest1.setRelationshipInterestId(1L);

        RelationshipInterest relationshipInterest2 = new RelationshipInterest("Dating");
        relationshipInterest2.setRelationshipInterestId(2L);

        RelationshipInterest relationshipInterestNull = null;

        return Stream.of(
                Arguments.of(relationshipInterest1, relationshipInterest2),
                Arguments.of(relationshipInterest1, relationshipInterestNull));
    }

    private static Stream<Arguments> provideIdenticalRelationshipInterests() {
        RelationshipInterest relationshipInterest1 = new RelationshipInterest("Friendship");
        relationshipInterest1.setRelationshipInterestId(1L);

        RelationshipInterest relationshipInterest2 = new RelationshipInterest("Friendship");
        relationshipInterest2.setRelationshipInterestId(2L);

        return Stream.of(
                Arguments.of(relationshipInterest1, relationshipInterest1),
                Arguments.of(relationshipInterest1, relationshipInterest2));
    }
}
