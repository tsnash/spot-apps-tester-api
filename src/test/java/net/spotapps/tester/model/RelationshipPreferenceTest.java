package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RelationshipPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentRelationshipPreferences")
    public void testRelationshipPreferenceInequality(RelationshipPreference testRelationshipPreference1,
            RelationshipPreference testRelationshipPreference2) {
        assertNotEquals(testRelationshipPreference1, testRelationshipPreference2,
                "Different relationship preferences should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipPreferences")
    public void testRelationshipPreferenceEquality(RelationshipPreference testRelationshipPreference1,
            RelationshipPreference testRelationshipPreference2) {
        assertEquals(testRelationshipPreference1, testRelationshipPreference2, "Identical relationship preferences should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalRelationshipPreferences")
    public void testRelationshipPreferenceHashcodeEquality(RelationshipPreference testRelationshipPreference1,
            RelationshipPreference testRelationshipPreference2) {
        assertEquals(testRelationshipPreference1.hashCode(), testRelationshipPreference2.hashCode(),
                "Identical relationship preferences should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentRelationshipPreferences() {
        RelationshipPreference relationshipPreference1 = new RelationshipPreference();
        relationshipPreference1.setUserId(1L);

        RelationshipPreference relationshipPreference2 = new RelationshipPreference();
        relationshipPreference2.setUserId(2L);

        RelationshipPreference relationshipPreferenceNull = new RelationshipPreference();
        relationshipPreferenceNull.setUserId(null);

        RelationshipPreference relationshipPreference1AllFields = new RelationshipPreference();
        relationshipPreference1AllFields.setUserId(1L);
        relationshipPreference1AllFields.setRelationshipStatus(new RelationshipStatus("Single"));

        RelationshipPreference relationshipPreference2AllFields = new RelationshipPreference();
        relationshipPreference2AllFields.setUserId(2L);
        relationshipPreference2AllFields.setRelationshipStatus(new RelationshipStatus("Single"));

        return Stream.of(
                Arguments.of(relationshipPreference1, relationshipPreference2),
                Arguments.of(relationshipPreference1, relationshipPreferenceNull),
                Arguments.of(relationshipPreference1, null),
                Arguments.of(relationshipPreference1AllFields, relationshipPreference2AllFields));
    }

    private static Stream<Arguments> provideIdenticalRelationshipPreferences() {
        RelationshipPreference relationshipPreference1 = new RelationshipPreference();
        relationshipPreference1.setUserId(1L);

        RelationshipPreference relationshipPreference2 = new RelationshipPreference();
        relationshipPreference2.setUserId(1L);

        RelationshipPreference relationshipPreferenceNull = new RelationshipPreference();
        relationshipPreferenceNull.setUserId(null);

        RelationshipPreference relationshipPreference1AllFields = new RelationshipPreference();
        relationshipPreference1AllFields.setUserId(1L);
        relationshipPreference1AllFields.setRelationshipStatus(new RelationshipStatus("Single"));

        return Stream.of(
                Arguments.of(relationshipPreference1, relationshipPreference1),
                Arguments.of(relationshipPreference1, relationshipPreference2),
                Arguments.of(relationshipPreferenceNull, relationshipPreferenceNull),
                Arguments.of(relationshipPreference1, relationshipPreference1AllFields));
    }
}
