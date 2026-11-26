package net.spotapps.tester.dto.response;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.EqualityTestHelper;

public class HttpRequestErrorResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentErrorResponses")
    public void testHttpRequestErrorResponseInequality(HttpRequestErrorResponse testHttpRequestErrorResponse1,
            HttpRequestErrorResponse testHttpRequestErrorResponse2) {
        EqualityTestHelper.assertInequality(testHttpRequestErrorResponse1, testHttpRequestErrorResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalErrorResponses")
    public void testHttpRequestErrorResponseEquality(HttpRequestErrorResponse testHttpRequestErrorResponse1,
            HttpRequestErrorResponse testHttpRequestErrorResponse2) {
        EqualityTestHelper.assertEquality(testHttpRequestErrorResponse1, testHttpRequestErrorResponse2);
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalErrorResponses")
    public void testHttpRequestErrorResponseHashcodeEquality(HttpRequestErrorResponse testHttpRequestErrorResponse1,
            HttpRequestErrorResponse testHttpRequestErrorResponse2) {
        EqualityTestHelper.assertHashcodeEquality(testHttpRequestErrorResponse1, testHttpRequestErrorResponse2);
    }

    @Test
    public void testHttpRequestErrorResponseDifferentTypeInequality() {
        EqualityTestHelper.assertDifferentTypeInequality(createHttpRequestErrorResponse(new Metadata("same")));
    }

    private static Stream<Arguments> provideDifferentErrorResponses() {
        HttpRequestErrorResponse errorResponse1 = createHttpRequestErrorResponse(new Metadata("same"));
        HttpRequestErrorResponse errorResponse2 = createHttpRequestErrorResponse(new Metadata("different"));
        HttpRequestErrorResponse errorResponseEmptyMetadata = createHttpRequestErrorResponse(new Metadata(null));
        HttpRequestErrorResponse errorResponseNullMetadata = new HttpRequestErrorResponse();

        return Stream.of(
                Arguments.of(errorResponse1, errorResponse2),
                Arguments.of(errorResponse1, errorResponseEmptyMetadata),
                Arguments.of(errorResponse1, errorResponseNullMetadata),
                Arguments.of(errorResponseEmptyMetadata, errorResponseNullMetadata),
                Arguments.of(errorResponse1, null));
    }

    private static Stream<Arguments> provideIdenticalErrorResponses() {
        HttpRequestErrorResponse errorResponse1 = createHttpRequestErrorResponse(new Metadata("same"));
        HttpRequestErrorResponse errorResponse2 = createHttpRequestErrorResponse(new Metadata("same"));
        HttpRequestErrorResponse errorResponseEmptyMetadata1 = createHttpRequestErrorResponse(new Metadata(null));
        HttpRequestErrorResponse errorResponseEmptyMetadata2 = createHttpRequestErrorResponse(new Metadata(null));
        HttpRequestErrorResponse errorResponseNullMetadata1 = new HttpRequestErrorResponse();
        HttpRequestErrorResponse errorResponseNullMetadata2 = new HttpRequestErrorResponse();

        return Stream.of(
                Arguments.of(errorResponse1, errorResponse1),
                Arguments.of(errorResponse1, errorResponse2),
                Arguments.of(errorResponseEmptyMetadata1, errorResponseEmptyMetadata2),
                Arguments.of(errorResponseNullMetadata1, errorResponseNullMetadata2));
    }

    private static HttpRequestErrorResponse createHttpRequestErrorResponse(Metadata metadata) {
        HttpRequestErrorResponse response = new HttpRequestErrorResponse();
        response.setMetadata(metadata);
        return response;
    }
}
