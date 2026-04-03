package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChildTest {

    @ParameterizedTest
    @MethodSource("provideDifferentChildren")
    public void testChildInequality(Child testChild1, Child testChild2) {
        assertNotEquals(testChild1, testChild2, "Different children should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildren")
    public void testChildEquality(Child testChild1, Child testChild2) {
        assertEquals(testChild1, testChild2, "Identical children should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalChildren")
    public void testChildHashcodeEquality(Child testChild1, Child testChild2) {
        assertEquals(testChild1.hashCode(), testChild2.hashCode(),
                "Identical children should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentChildren() {
        Child child1 = new Child();
        child1.setChildId(1L);

        Child child2 = new Child();
        child2.setChildId(2L);

        Child childNull = new Child();
        childNull.setChildId(null);

        Child child1AllFields = new Child();
        child1AllFields.setChildId(1L);
        child1AllFields.setLifeStage(new LifeStage());
        child1AllFields.setGender(new ChildGender());
        child1AllFields.setInHousehold(new HouseholdStatus());

        Child child2AllFields = new Child();
        child2AllFields.setChildId(2L);
        child2AllFields.setLifeStage(new LifeStage());
        child2AllFields.setGender(new ChildGender());
        child2AllFields.setInHousehold(new HouseholdStatus());

        return Stream.of(
                Arguments.of(child1, child2),
                Arguments.of(child1, childNull),
                Arguments.of(child1, null),
                Arguments.of(child1AllFields, child2AllFields));
    }

    private static Stream<Arguments> provideIdenticalChildren() {
        Child child1 = new Child();
        child1.setChildId(1L);

        Child child2 = new Child();
        child2.setChildId(1L);

        Child childNull = new Child();
        childNull.setChildId(null);

        Child child1AllFields = new Child();
        child1AllFields.setChildId(1L);
        child1AllFields.setLifeStage(new LifeStage());
        child1AllFields.setGender(new ChildGender());
        child1AllFields.setInHousehold(new HouseholdStatus());

        return Stream.of(
                Arguments.of(child1, child1),
                Arguments.of(child1, child2),
                Arguments.of(childNull, childNull),
                Arguments.of(child1, child1AllFields));
    }
}
