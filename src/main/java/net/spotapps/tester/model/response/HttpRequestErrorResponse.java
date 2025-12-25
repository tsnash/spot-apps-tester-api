package net.spotapps.tester.model.response;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "issues"
})
public class HttpRequestErrorResponse implements HttpRequestResponse {

    @JsonProperty("metadata")
    @Schema(description = "Additional data related to but not part of the request response.")
    private Metadata metadata;

    @JsonProperty("issues")
    @Schema(description = "Reasons for the request error.")
    private List<Issue> issues;

    public HttpRequestErrorResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, issues);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        HttpRequestErrorResponse other = (HttpRequestErrorResponse) obj;
        return Objects.equals(metadata, other.metadata) && Objects.equals(issues, other.issues);
    }

    @Override
    public String toString() {
        return "HttpRequestErrorResponse [metadata=" + metadata + ", issues=" + issues + "]";
    }

}
