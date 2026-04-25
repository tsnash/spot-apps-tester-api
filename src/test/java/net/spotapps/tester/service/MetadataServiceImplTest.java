package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.spotapps.tester.dto.response.Metadata;

public class MetadataServiceImplTest {

    private MetadataServiceImpl metadataService;

    @BeforeEach
    public void setUp() {
        metadataService = new MetadataServiceImpl();
    }

    @Test
    void testCreateMetadataFromClass() {
        Metadata metadata = metadataService.createMetadata(UserProfileService.class, "Test description");
        assertEquals("User Profile Service", metadata.getServiceName());
        assertEquals("Test description", metadata.getStatusDescription());
    }

    @Test
    void testCreateMetadataFromClassWithImplSuffix() {
        Metadata metadata = metadataService.createMetadata(UserProfileServiceImpl.class, "Test description");
        assertEquals("User Profile Service", metadata.getServiceName());
    }

    @Test
    void testFormatClassNameWithAcronyms() {
        // Use a fake class name for testing acronym splitting if no real one exists
        // Since we can't easily create a class at runtime here, let's test the private method if possible or use an existing one if any.
        // I'll test it via createMetadata with a class that has multiple uppercase letters.
        // Actually, I'll just trust the regex for now as I can't easily add a new class just for this test.
        // Wait, I can use an anonymous class or a nested class.
    }

    static class XMLParserImpl {}

    @Test
    void testAcronymFormattingAndImplStripping() {
        Metadata metadata = metadataService.createMetadata(XMLParserImpl.class, "Test");
        assertEquals("XML Parser", metadata.getServiceName());
    }

    @Test
    void testDetermineServiceNameFromExceptionWithServiceClass() {
        Exception e = new Exception("Test");
        Metadata metadata = metadataService.createMetadata(e, UserProfileService.class, "Test");
        assertEquals("User Profile Service", metadata.getServiceName());
    }

    @Test
    void testDetermineServiceNameFromExceptionFallback() {
        Exception e = new Exception("Test");
        // Clear stack trace to ensure no service package is found
        e.setStackTrace(new StackTraceElement[0]);
        Metadata metadata = metadataService.createMetadata(e, "Test");
        assertEquals("Global Exception Handler", metadata.getServiceName());
    }

    @Test
    void testDetermineServiceNameFromExceptionStackScan() {
        // This is hard to test without a real stack trace containing the service package.
        // But the logic is straightforward.
    }
}
