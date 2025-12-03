package net.spotapps.tester.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HttpRequestErrorResponseTest {
    private HttpRequestErrorResponse testResponse1;
    private HttpRequestErrorResponse testResponse2;
    private HttpRequestErrorResponse testResponse3;

    @BeforeEach
    public void setUp() throws Exception {
        Metadata sameMetadata = new Metadata();
        sameMetadata.setStatusDescription("same");
        Metadata differentMetadata = new Metadata();
        differentMetadata.setStatusDescription("different");
        testResponse1 = new HttpRequestErrorResponse();
        testResponse1.setMetadata(sameMetadata);
        testResponse2 = new HttpRequestErrorResponse();
        testResponse2.setMetadata(sameMetadata);
        testResponse3 = new HttpRequestErrorResponse();
        testResponse3.setMetadata(differentMetadata);
    }

    @Test
    void testEquals() throws Exception {

        assertEquals(testResponse2, testResponse1, "Identical responses should be equal");
        assertNotEquals(testResponse3, testResponse1, "Different responses should not be equal");

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
            "Different responses should have be equal hashcodes");

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
            
    }
}
