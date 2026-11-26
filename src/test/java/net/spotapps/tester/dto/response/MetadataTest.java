package net.spotapps.tester.dto.response;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.EqualityTestHelper;

public class MetadataTest {

    @ParameterizedTest
    @MethodSource("provideDifferentMetadata")
    public void testMetadataInequality(Metadata testMetadata1, Metadata testMetadata2) {
        EqualityTestHelper.assertInequality(testMetadata1, testMetadata2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalMetadata")
    public void testMetadataEquality(Metadata testMetadata1, Metadata testMetadata2) {
        EqualityTestHelper.assertEquality(testMetadata1, testMetadata2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalMetadata")
    public void testMetadataHashcodeEquality(Metadata testMetadata1, Metadata testMetadata2) {
        EqualityTestHelper.assertHashcodeEquality(testMetadata1, testMetadata2);
    }

    @Test
    public void testMetadataDifferentTypeInequality() {
        EqualityTestHelper.assertDifferentTypeInequality(new Metadata("same"));
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
        Metadata metadataNull1 = new Metadata();
        Metadata metadataNull2 = new Metadata();
        Metadata metadataExplicitNull = new Metadata(null);

        return Stream.of(
                Arguments.of(metadata1, metadata1),
                Arguments.of(metadata1, metadata2),
                Arguments.of(metadataNull1, metadataNull2),
                Arguments.of(metadataExplicitNull, metadataNull1));
    }
}
