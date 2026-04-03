package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HouseholdStatusTest {

    @ParameterizedTest
    @MethodSource("provideDifferentHouseholdStatuses")
    public void testHouseholdStatusInequality(HouseholdStatus testHouseholdStatus1, HouseholdStatus testHouseholdStatus2) {
        assertNotEquals(testHouseholdStatus1, testHouseholdStatus2, "Different household statuses should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalHouseholdStatuses")
    public void testHouseholdStatusEquality(HouseholdStatus testHouseholdStatus1, HouseholdStatus testHouseholdStatus2) {
        assertEquals(testHouseholdStatus1, testHouseholdStatus2, "Identical household statuses should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalHouseholdStatuses")
    public void testHouseholdStatusHashcodeEquality(HouseholdStatus testHouseholdStatus1, HouseholdStatus testHouseholdStatus2) {
        assertEquals(testHouseholdStatus1.hashCode(), testHouseholdStatus2.hashCode(),
                "Identical household statuses should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentHouseholdStatuses() {
        HouseholdStatus householdStatus1 = new HouseholdStatus("Full-time");
        householdStatus1.setHouseholdStatusId(1L);

        HouseholdStatus householdStatus2 = new HouseholdStatus("Part-time");
        householdStatus2.setHouseholdStatusId(2L);

        HouseholdStatus householdNull = null;

        return Stream.of(
                Arguments.of(householdStatus1, householdStatus2),
                Arguments.of(householdStatus1, householdNull));
    }

    private static Stream<Arguments> provideIdenticalHouseholdStatuses() {
        HouseholdStatus householdStatus1 = new HouseholdStatus("Full-time");
        householdStatus1.setHouseholdStatusId(1L);

        HouseholdStatus householdStatus2 = new HouseholdStatus("Full-time");
        householdStatus2.setHouseholdStatusId(2L);

        return Stream.of(
                Arguments.of(householdStatus1, householdStatus1),
                Arguments.of(householdStatus1, householdStatus2));
    }
}
