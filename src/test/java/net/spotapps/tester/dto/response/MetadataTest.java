package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetadataTest {

    private Metadata testMetadata1;
    private Metadata testMetadata2;
    private Metadata testMetadata3;

    @BeforeEach
    public void setUp() throws Exception {
        testMetadata1 = new Metadata();
        testMetadata1.setTraceId("same");
        testMetadata2 = new Metadata();
        testMetadata2.setTraceId("same");
        testMetadata3 = new Metadata();
        testMetadata3.setTraceId("different");
    }

    @Test
    void testEquals() throws Exception {

        assertEquals(testMetadata2, testMetadata1, "Identical metadata should be equal");
        assertNotEquals(testMetadata3, testMetadata1, "Different metadata should not be equal");

    }

    @Test
    void testHashCode() throws Exception {

        assertEquals(
                testMetadata2.hashCode(),
                testMetadata1.hashCode(),
                "Identical metadata should have equal hashcodes");
        assertNotEquals(
                testMetadata3.hashCode(),
                testMetadata1.hashCode(),
                "Different metadata should not have equal hashcodes");

    }

    @Test
    void testToString() throws Exception {

        assertEquals(
                testMetadata2.toString(),
                testMetadata1.toString(),
                "Identical metadata should have equal strings");
        assertNotEquals(
                testMetadata3.toString(),
                testMetadata1.toString(),
                "Different metadata should not have equal strings");

    }
}
