package net.spotapps.tester.service;

import org.springframework.stereotype.Service;

import net.spotapps.tester.dto.response.Metadata;

@Service
public class MetadataServiceImpl implements MetadataService {

    private static final String SERVICE_PACKAGE_PREFIX = "net.spotapps.tester.service";
    private static final String FALLBACK_SERVICE_NAME = "Global Exception Handler";

    @Override
    public Metadata createMetadata(Class<?> serviceInterface, String description) {
        Metadata metadata = new Metadata();
        metadata.setServiceName(formatClassName(serviceInterface.getSimpleName()));
        metadata.setStatusDescription(description);
        return metadata;
    }

    @Override
    public Metadata createMetadata(Exception exception, String description) {
        Metadata metadata = new Metadata();
        metadata.setServiceName(determineServiceNameFromException(exception));
        metadata.setStatusDescription(description);
        return metadata;
    }

    private String determineServiceNameFromException(Exception exception) {
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith(SERVICE_PACKAGE_PREFIX)) {
                try {
                    Class<?> clazz = Class.forName(element.getClassName());
                    return formatClassName(clazz.getSimpleName());
                } catch (ClassNotFoundException e) {
                    // If class not found, try to extract simple name from the full class name string
                    String fullClassName = element.getClassName();
                    String simpleName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
                    return formatClassName(simpleName);
                }
            }
        }
        return FALLBACK_SERVICE_NAME;
    }

    private String formatClassName(String className) {
        return className.replaceAll("(?<=[a-z])(?=[A-Z])", " ");
    }
}
