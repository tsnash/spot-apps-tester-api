package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;



public class ContactPreferenceTest {

    @Test
    public void testHashCodeWithSameUserId() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(1L);
        
        assertEquals(cp1.hashCode(), cp2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentUserIds() {
        ContactPreference cp1 = new ContactPreference();
        cp1.setUserId(1L);
        
        ContactPreference cp2 = new ContactPreference();
        cp2.setUserId(2L);
        
        assertNotEquals(cp1.hashCode(), cp2.hashCode());
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