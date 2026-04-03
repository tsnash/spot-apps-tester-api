package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RelationshipStatusTest {

    @ParameterizedTest
    @MethodSource("provideDifferentRelationshipStatuses")
    public void testRelationshipStatusInequality(RelationshipStatus testRelationshipStatus1, RelationshipStatus testRelationshipStatus2) {
        assertNotEquals(testRelationshipStatus1, testRelationshipStatus2, "Different relationship statuses should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipStatuses")
    public void testRelationshipStatusEquality(RelationshipStatus testRelationshipStatus1, RelationshipStatus testRelationshipStatus2) {
        assertEquals(testRelationshipStatus1, testRelationshipStatus2, "Identical relationship statuses should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipStatuses")
    public void testRelationshipStatusHashcodeEquality(RelationshipStatus testRelationshipStatus1, RelationshipStatus testRelationshipStatus2) {
        assertEquals(testRelationshipStatus1.hashCode(), testRelationshipStatus2.hashCode(),
                "Identical relationship statuses should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentRelationshipStatuses() {
        RelationshipStatus relationshipStatus1 = new RelationshipStatus("Single");
        relationshipStatus1.setRelationshipStatusId(1L);

        RelationshipStatus relationshipStatus2 = new RelationshipStatus("Married");
        relationshipStatus2.setRelationshipStatusId(2L);

        RelationshipStatus relationshipStatusNull = null;

        return Stream.of(
                Arguments.of(relationshipStatus1, relationshipStatus2),
                Arguments.of(relationshipStatus1, relationshipStatusNull));
    }

    private static Stream<Arguments> provideIdenticalRelationshipStatuses() {
        RelationshipStatus relationshipStatus1 = new RelationshipStatus("Single");
        relationshipStatus1.setRelationshipStatusId(1L);

        RelationshipStatus relationshipStatus2 = new RelationshipStatus("Single");
        relationshipStatus2.setRelationshipStatusId(2L);

        return Stream.of(
                Arguments.of(relationshipStatus1, relationshipStatus1),
                Arguments.of(relationshipStatus1, relationshipStatus2));
    }
}
