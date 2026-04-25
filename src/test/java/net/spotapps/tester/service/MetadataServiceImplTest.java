package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.spotapps.tester.dto.response.Metadata;

class MetadataServiceImplTest {

    private MetadataServiceImpl metadataService;

    @BeforeEach
    void setUp() {
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
        Exception e = new Exception("Test");
        StackTraceElement serviceElement = new StackTraceElement(
                "net.spotapps.tester.service.SomeBusinessService", "someMethod", "SomeBusinessService.java", 10);
        StackTraceElement[] stackTrace = new StackTraceElement[] {
                new StackTraceElement("net.spotapps.tester.other.OtherClass", "otherMethod", "OtherClass.java", 5),
                serviceElement
        };
        e.setStackTrace(stackTrace);

        Metadata metadata = metadataService.createMetadata(e, "Test");
        assertEquals("Some Business Service", metadata.getServiceName());
    }

    static class XMLParserImpl {}
}
