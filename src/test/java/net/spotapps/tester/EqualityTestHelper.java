package net.spotapps.tester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class EqualityTestHelper {

    private static final class UnrelatedType {
    }

    private EqualityTestHelper() {
        throw new AssertionError();
    }

    public static <T> void assertEquality(T a, T b) {
        assertEquals(a, b, "Identical objects should be equal");
        assertEquals(b, a, "Equality should be symmetric");
        if (a != null) {
            assertEquals(a, a, "Equality should be reflexive");
        }
    }

    public static <T> void assertInequality(T a, T b) {
        assertNotEquals(a, b, "Different objects should not be equal");
        assertNotEquals(b, a, "Inequality should be symmetric");
    }

    public static <T> void assertDifferentTypeInequality(T a) {
        assertNotNull(a, "Object under test must not be null");
        Object plainObject = new Object();
        Object unrelatedInstance = new UnrelatedType();
        assertNotEquals(a, plainObject, "Object should not equal an instance of Object");
        assertNotEquals(plainObject, a, "Different-type inequality should be symmetric");
        assertNotEquals(a, unrelatedInstance, "Object should not equal an instance of an unrelated class");
        assertNotEquals(unrelatedInstance, a, "Different-type inequality should be symmetric");
    }

    public static <T> void assertHashcodeEquality(T a, T b) {
        assertNotNull(a, "First object must not be null when comparing hash codes");
        assertNotNull(b, "Second object must not be null when comparing hash codes");
        assertEquals(a.hashCode(), b.hashCode(), "Identical objects should have equal hash codes");
    }
}
