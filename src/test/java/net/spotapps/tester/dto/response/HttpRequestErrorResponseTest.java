package net.spotapps.tester.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.spotapps.tester.dto.UserProfileDto;

public class HttpRequestErrorResponseTest {

    @ParameterizedTest
    @MethodSource("provideDifferentErrorResponses")
    public void testHttpRequestErrorResponseInequality(HttpRequestErrorResponse testHttpRequestErrorResponse1, 
            HttpRequestErrorResponse httpRequestErrorResponse2) {
        assertNotEquals(testHttpRequestErrorResponse1, httpRequestErrorResponse2, "Different responses should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalErrorResponses")
    public void testHttpRequestErrorResponseEququality(HttpRequestErrorResponse testHttpRequestErrorResponse1, 
            HttpRequestErrorResponse httpRequestErrorResponse2) {
        assertEquals(testHttpRequestErrorResponse1, httpRequestErrorResponse2, "Identical responses should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalErrorResponses")
    public void testHttpRequestErrorResponseMethodEququality(HttpRequestErrorResponse testHttpRequestErrorResponse1, 
            HttpRequestErrorResponse httpRequestErrorResponse2) {
        assertEquals(testHttpRequestErrorResponse1.hashCode(), httpRequestErrorResponse2.hashCode(), "Identical responses should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentErrorResponses() {
        HttpRequestErrorResponse httpRequestErrorResponse1 = createHttpRequestErrorResponse("same");
        HttpRequestErrorResponse httpRequestErrorResponse2 = createHttpRequestErrorResponse("different");
        HttpRequestErrorResponse httpRequestErrorResponseNull = new HttpRequestErrorResponse();

        return Stream.of(
                Arguments.of(httpRequestErrorResponse1, httpRequestErrorResponse2),
                Arguments.of(httpRequestErrorResponse1, httpRequestErrorResponseNull),
                Arguments.of(httpRequestErrorResponse1, null));
    }

    private static Stream<Arguments> provideIdenticalErrorResponses() {
        HttpRequestErrorResponse httpRequestErrorResponse1 = createHttpRequestErrorResponse("same");
        HttpRequestErrorResponse httpRequestErrorResponse2 = createHttpRequestErrorResponse("same");
        HttpRequestErrorResponse httpRequestErrorResponseNull = new HttpRequestErrorResponse();

        return Stream.of(
                Arguments.of(httpRequestErrorResponse1, httpRequestErrorResponse1),
                Arguments.of(httpRequestErrorResponse1, httpRequestErrorResponse2),
                Arguments.of(httpRequestErrorResponseNull, httpRequestErrorResponseNull));
    }

    private static HttpRequestErrorResponse createHttpRequestErrorResponse(String traceId) {
        HttpRequestErrorResponse response = new HttpRequestErrorResponse();

        response.setMetadata(new Metadata(traceId));
        return response;
    }
}
