package net.spotapps.tester.dto.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata"
})
@Schema(description = "Represents an error response for an HTTP request, containing metadata.")
public class HttpRequestErrorResponse implements HttpRequestResponse {

    @JsonProperty("metadata")
    @Schema(description = "Additional data related to but not part of the request response.")
    private Metadata metadata;

    public HttpRequestErrorResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        HttpRequestErrorResponse other = (HttpRequestErrorResponse) obj;
        return Objects.equals(metadata, other.metadata);
    }

    @Override
    public String toString() {
        return "HttpRequestErrorResponse [metadata=" + metadata + "]";
    }

}
