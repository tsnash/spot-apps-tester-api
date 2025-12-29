package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ContactPreferenceTest {

    @ParameterizedTest
    @MethodSource("provideDifferentContactPreferences")
    public void testContactPreferenceInequality(ContactPreference testContactPreference1, ContactPreference testContactPreference2) {
        assertNotEquals(testContactPreference1, testContactPreference2, "Different user profiles should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalContactPreferences")
    public void testContactPreferenceEquality(ContactPreference testContactPreference1, ContactPreference testContactPreference2) {
        assertEquals(testContactPreference1, testContactPreference2, "Identical user profiles should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideDifferentContactPreferences")
    public void testContactPreferenceHashcodeInequality(ContactPreference testContactPreference1, ContactPreference testContactPreference2) {
        assertNotEquals(testContactPreference1.hashCode(), testContactPreference2.hashCode(),
                "Different user profiles should not have equal hash codes");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalContactPreferences")
    public void testContactPreferenceHashcodeEquality(ContactPreference testContactPreference1, ContactPreference testContactPreference2) {
        assertEquals(testContactPreference1.hashCode(), testContactPreference2.hashCode(),
                "Identical user profiles should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentContactPreferences() {
        ContactPreference contactPreference1 = new ContactPreference();
        contactPreference1.setUserId(1L);

        ContactPreference contactPreference2 = new ContactPreference();
        contactPreference2.setUserId(2L);

        ContactPreference contactPreferenceNull = new ContactPreference();
        contactPreferenceNull.setUserId(null);

        ContactPreference contactPreference3AllFields = new ContactPreference();
        contactPreference3AllFields.setUserId(3L);
        contactPreference3AllFields.setFirstName("John");
        contactPreference3AllFields.setLastName("Doe");
        contactPreference3AllFields.setPhoneNumber("1234567890");
        contactPreference3AllFields.setEmailAddress("john.doe@example.com");
        contactPreference3AllFields.setEmailVerified(true);

        ContactPreference contactPreference4AllFields = new ContactPreference();
        contactPreference4AllFields.setUserId(4L);
        contactPreference3AllFields.setFirstName("John");
        contactPreference3AllFields.setLastName("Doe");
        contactPreference3AllFields.setPhoneNumber("1234567890");
        contactPreference3AllFields.setEmailAddress("john.doe@example.com");
        contactPreference3AllFields.setEmailVerified(true);


        return Stream.of(
                Arguments.of(contactPreference1, contactPreference2),
                Arguments.of(contactPreference1, contactPreferenceNull),
                Arguments.of(contactPreference3AllFields, contactPreference4AllFields)
        );
    }

    private static Stream<Arguments> provideIdenticalContactPreferences() {
        ContactPreference contactPreference1 = new ContactPreference();
        contactPreference1.setUserId(1L);

        ContactPreference contactPreference2 = new ContactPreference();
        contactPreference2.setUserId(1L);

        ContactPreference contactPreferenceNull = new ContactPreference();
        contactPreferenceNull.setUserId(null);

        ContactPreference contactPreference1AllFields = new ContactPreference();
        contactPreference1AllFields.setUserId(1L);

        return Stream.of(
                Arguments.of(contactPreference1, contactPreference1),
                Arguments.of(contactPreference1, contactPreference2),
                Arguments.of(contactPreferenceNull, contactPreferenceNull),
                Arguments.of(contactPreference1, contactPreference1AllFields)
        );
    }

    @Test
    public void testHashCodeWithSameUserId() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(1L);
        
        assertEquals(cp1.hashCode(), cp2.hashCode());
    }

    @Test
    public void testEqualsWithSameUserId() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(1L);
        
        assertEquals(cp1, cp2);
    }
    @Test
    public void testEqualsWithDifferentUserId() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(2L);
        
        assertNotEquals(cp1, cp2);
    }

    @Test
    public void testEqualsWithNull() {
        ContactPreference cp = new ContactPreference();
        cp.setUserId(1L);
        
        assertNotEquals(cp, null);
    }

    @Test
    public void testEqualsReflexive() {
        ContactPreference cp = new ContactPreference();
        cp.setUserId(1L);
        
        assertEquals(cp, cp);
    }

    @Test
    public void testHashCodeWithNullUserId() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(null);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(null);
        
        assertEquals(cp1.hashCode(), cp2.hashCode());
    }

    @Test
    public void testHashCodeConsistency() {
        ContactPreference cp = new ContactPreference();
        cp.setUserId(100L);
        
        int hash1 = cp.hashCode();
        int hash2 = cp.hashCode();
        
        assertEquals(hash1, hash2);
    }

    @Test
    public void testHashCodeIgnoresOtherFields() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        cp1.setFirstName("John");
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(1L);
        cp2.setFirstName("Jane");
        
        assertEquals(cp1.hashCode(), cp2.hashCode());
    }
}