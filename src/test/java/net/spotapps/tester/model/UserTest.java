package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserTest {

    @ParameterizedTest
    @MethodSource("provideDifferentUsers")
    public void testUserInequality(User user1, User user2) {
        assertNotEquals(user1, user2, "Different users should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUsers")
    public void testUserEquality(User user1, User user2) {
        assertEquals(user1, user2, "Identical users should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUsers")
    public void testUserHashcodeEquality(User user1, User user2) {
        assertEquals(user1.hashCode(), user2.hashCode(), "Identical users should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUsers() {
        User user1 = new User();
        user1.setUserId(1L);

        User user2 = new User();
        user2.setUserId(2L);

        return Stream.of(Arguments.of(user1, user2));
    }

    private static Stream<Arguments> provideIdenticalUsers() {
        User user1 = new User();
        user1.setUserId(1L);

        User user2 = new User();
        user2.setUserId(1L);

        return Stream.of(Arguments.of(user1, user2));
    }
}