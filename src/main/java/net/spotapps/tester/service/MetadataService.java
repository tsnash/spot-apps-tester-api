package net.spotapps.tester.service;

import net.spotapps.tester.dto.response.Metadata;

public interface MetadataService {

    Metadata createMetadata(Class<?> serviceInterface, String description);

    Metadata createMetadata(Exception exception, String description);

    Metadata createMetadata(Exception exception, Class<?> serviceInterface, String description);

}
