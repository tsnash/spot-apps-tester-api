package net.spotapps.tester.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetadataTest {

    private Metadata testIssue1;
    private Metadata testIssue2;
    private Metadata testIssue3;

    @BeforeEach
    public void setUp() throws Exception {
        testIssue1 = new Metadata();
        testIssue1.setStatusDescription("same");
        testIssue2 = new Metadata();
        testIssue2.setStatusDescription("same");
        testIssue3 = new Metadata();
        testIssue3.setStatusDescription("different");
    }

    @Test
    void testEquals() throws Exception {

        assertEquals(testIssue2, testIssue1, "Identical metadata should be equal");
        assertNotEquals(testIssue3, testIssue1, "Different metadata should not be equal");

    }

    @Test
    void testHashCode() throws Exception {

        assertEquals(
                testIssue2.hashCode(),
                testIssue1.hashCode(),
                "Identical metadata should have equal hashcodes");
        assertNotEquals(
                testIssue3.hashCode(),
                testIssue1.hashCode(),
                "Different metadata should have be equal hashcodes");

    }

    @Test
    void testToString() throws Exception {

        assertEquals(
                testIssue2.toString(),
                testIssue1.toString(),
                "Identical metadata should have equal strings");
        assertNotEquals(
                testIssue3.toString(),
                testIssue1.toString(),
                "Different metadata should not have equal strings");

    }
}
