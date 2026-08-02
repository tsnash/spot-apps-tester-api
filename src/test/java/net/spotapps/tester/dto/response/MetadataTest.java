package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MetadataTest {

    @ParameterizedTest
    @MethodSource("provideDifferentMetadata")
    public void testMetadataInequality(Metadata metadata1, Metadata metadata2) {
        assertNotEquals(metadata1, metadata2, "Different metadata should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalMetadata")
    public void testMetadataEquality(Metadata metadata1, Metadata metadata2) {
        assertEquals(metadata1, metadata2, "Identical metadata should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalMetadata")
    public void testMetadataHashcodeEquality(Metadata metadata1, Metadata metadata2) {
        assertEquals(metadata1.hashCode(), metadata2.hashCode(), "Identical metadata should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentMetadata() {
        Metadata metadata1 = new Metadata("same");
        Metadata metadata2 = new Metadata("different");
        Metadata metadataNull = new Metadata();

        return Stream.of(
                Arguments.of(metadata1, metadata2),
                Arguments.of(metadata1, metadataNull),
                Arguments.of(metadata1, null));
    }

    private static Stream<Arguments> provideIdenticalMetadata() {
        Metadata metadata1 = new Metadata("same");
        Metadata metadata2 = new Metadata("same");
        Metadata metadataNull = new Metadata();

        return Stream.of(
                Arguments.of(metadata1, metadata1),
                Arguments.of(metadata1, metadata2),
                Arguments.of(metadataNull, metadataNull));
    }
}
