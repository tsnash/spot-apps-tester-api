package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserProfileTest {

    private UserProfile emptyUserProfile;
    private UserProfile testUserProfile1;
    private UserProfile testUserProfile2;

    @BeforeEach
    public void setUp() throws Exception {
        emptyUserProfile = new UserProfile();

        testUserProfile1 = new UserProfile();
        testUserProfile1.setUserId(1L);
        testUserProfile1.setImages(Arrays.asList(
                new UserImage(1L, "four"),
                new UserImage(2L, "images"),
                new UserImage(3L, "only"),
                new UserImage(4L, "please")));
        testUserProfile1.setInterests(Arrays.asList(
                new UserInterest(1L, "up"),
                new UserInterest(2L, "to"),
                new UserInterest(3L, "six"),
                new UserInterest(4L, "of"),
                new UserInterest(5L, "these"),
                new UserInterest(6L, "allowed")));

        testUserProfile2 = new UserProfile();
        testUserProfile2.setUserId(1L);
        testUserProfile2.setImages(Arrays.asList(
                new UserImage(1L, "four"),
                new UserImage(2L, "images"),
                new UserImage(3L, "only"),
                new UserImage(4L, "please")));
        testUserProfile2.setInterests(Arrays.asList(
                new UserInterest(1L, "up"),
                new UserInterest(2L, "to"),
                new UserInterest(3L, "six"),
                new UserInterest(4L, "of"),
                new UserInterest(5L, "these"),
                new UserInterest(6L, "allowed")));
    }

    @Test
    public void testUserProfileInequality() throws Exception {
        assertNotEquals(testUserProfile1, emptyUserProfile, "Different user profiles should not be equal");
    }

    @Test
    public void testUserProfileEquality() throws Exception {
        assertEquals(testUserProfile1, testUserProfile2, "Identical user profiles should be equal");
    }

    @Test
    public void testUserProfileHashcodeInequality() throws Exception {
        assertNotEquals(testUserProfile1.hashCode(), emptyUserProfile.hashCode(),
                "Different user profiles should not have equal hash codes");
    }

    @Test
    public void testUserProfileHashcodeEquality() throws Exception {
        assertEquals(testUserProfile1.hashCode(), testUserProfile2.hashCode(),
                "Identical user profiles should have equal hash codes");
    }

    @Test
    public void testUserProfileToStringInequality() throws Exception {
        assertNotEquals(testUserProfile1.toString(), emptyUserProfile.toString(),
                "Different user profiles should not have equal strings");
    }

    @Test
    public void testUserProfileToStringEquality() throws Exception {
        assertEquals(testUserProfile1.toString(), testUserProfile2.toString());
    }

}