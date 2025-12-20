package net.spotapps.tester.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HttpRequestErrorResponseTest {
    private HttpRequestErrorResponse testResponse1;
    private HttpRequestErrorResponse testResponse2;
    private HttpRequestErrorResponse testResponse3;
    private HttpRequestErrorResponse testResponse4;

    @BeforeEach
    public void setUp() throws Exception {
        Metadata sameMetadata = new Metadata();
        sameMetadata.setStatusDescription("same");
        Metadata differentMetadata = new Metadata();
        differentMetadata.setStatusDescription("different");

        Issue sameIssue = new Issue();
        sameIssue.setMessage("same");
        Issue differentIssue = new Issue();
        differentIssue.setMessage("different");

        testResponse1 = new HttpRequestErrorResponse();
        testResponse1.setMetadata(sameMetadata);
        testResponse1.setIssues(Arrays.asList(sameIssue));
        testResponse2 = new HttpRequestErrorResponse();
        testResponse2.setMetadata(sameMetadata);
        testResponse2.setIssues(Arrays.asList(sameIssue));
        testResponse3 = new HttpRequestErrorResponse();
        testResponse3.setMetadata(differentMetadata);
        testResponse3.setIssues(Arrays.asList(differentIssue));
        testResponse4 = new HttpRequestErrorResponse();
        testResponse4.setMetadata(sameMetadata);
        testResponse4.setIssues(Arrays.asList(differentIssue));
    }

    @Test
    void testEquals() throws Exception {

        assertEquals(testResponse2, testResponse1, "Identical responses should be equal");
        assertNotEquals(testResponse3, testResponse1, "Different responses should not be equal");
        assertNotEquals(testResponse4, testResponse1, "Responses with different issues should not be equal");

    }

    @Test
    void testHashCode() throws Exception {

        assertEquals(
                testResponse2.hashCode(),
                testResponse1.hashCode(),
                "Identical responses should have equal hashcodes");
        assertNotEquals(
                testResponse3.hashCode(),
                testResponse1.hashCode(),
                "Different responses should not have equal hashcodes");
        assertNotEquals(
                testResponse4.hashCode(),
                testResponse1.hashCode(),
                "Responses with different issues should not have equal hashcodes");

    }

    @Test
    void testToString() throws Exception {

        assertEquals(
                testResponse2.toString(),
                testResponse1.toString(),
                "Identical responses should have equal strings");
        assertNotEquals(
                testResponse3.toString(),
                testResponse1.toString(),
                "Different responses should not have equal strings");
        assertNotEquals(
                testResponse4.toString(),
                testResponse1.toString(),
                "Responses with different issues should not have equal strings");

    }
}
