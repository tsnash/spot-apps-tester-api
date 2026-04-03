package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public final class ModelTestHelper {

    private ModelTestHelper() {
        throw new AssertionError();
    }

    public static <T> void assertEquality(T a, T b) {
        assertEquals(a, b, "Identical objects should be equal");
        assertEquals(b, a, "Equality should be symmetric");
    }

    public static <T> void assertInequality(T a, T b) {
        assertNotEquals(a, b, "Different objects should not be equal");
        assertNotEquals(b, a, "Inequality should be symmetric");
    }

    public static <T> void assertHashcodeEquality(T a, T b) {
        assertEquals(a.hashCode(), b.hashCode(), "Identical objects should have equal hash codes");
    }
}
