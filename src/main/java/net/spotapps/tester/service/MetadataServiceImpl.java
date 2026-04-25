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
        metadata.setServiceName(formatClassName(stripImpl(serviceInterface.getSimpleName())));
        metadata.setStatusDescription(description);
        return metadata;
    }

    @Override
    public Metadata createMetadata(Exception exception, String description) {
        return createMetadata(exception, null, description);
    }

    @Override
    public Metadata createMetadata(Exception exception, Class<?> serviceInterface, String description) {
        Metadata metadata = new Metadata();
        metadata.setServiceName(determineServiceNameFromException(exception, serviceInterface));
        metadata.setStatusDescription(description);
        return metadata;
    }

    private String determineServiceNameFromException(Exception exception, Class<?> serviceInterface) {
        if (serviceInterface != null) {
            return formatClassName(stripImpl(serviceInterface.getSimpleName()));
        }

        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().startsWith(SERVICE_PACKAGE_PREFIX)) {
                String fullClassName = element.getClassName();
                String simpleName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
                return formatClassName(stripImpl(simpleName));
            }
        }
        return FALLBACK_SERVICE_NAME;
    }

    private String stripImpl(String className) {
        if (className.endsWith("Impl")) {
            return className.substring(0, className.length() - 4);
        }
        return className;
    }

    private String formatClassName(String className) {
        return className.replaceAll("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])", " ");
    }
}
