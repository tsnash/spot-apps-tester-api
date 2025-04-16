package net.spotapps.tester.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssueTest {

    private Issue testIssue1;
    private Issue testIssue2;
    private Issue testIssue3;

    @BeforeEach
    public void setUp() throws Exception {
        testIssue1 = new Issue();
        testIssue1.setMessage("same");
        testIssue2 = new Issue();
        testIssue2.setMessage("same");
        testIssue3 = new Issue();
        testIssue3.setMessage("different");
    }

    @Test
    void testEquals() throws Exception {

        assertEquals(testIssue2, testIssue1, "Identical issues should be equal");
        assertNotEquals(testIssue3, testIssue1, "Different issues should not be equal");

    }

    @Test
    void testHashCode() throws Exception {

        assertEquals(
            testIssue2.hashCode(), 
            testIssue1.hashCode(), 
            "Identical issues should have equal hashcodes");
        assertNotEquals(
            testIssue3.hashCode(), 
            testIssue1.hashCode(), 
            "Different issues should have be equal hashcodes");

    }

    @Test
    void testToString() throws Exception {

        assertEquals(
            testIssue2.toString(), 
            testIssue1.toString(), 
            "Identical issues should have equal strings");
        assertNotEquals(
            testIssue3.toString(), 
            testIssue1.toString(), 
            "Different issues should not have equal strings");
            
    }
}
