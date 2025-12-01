package net.spotapps.tester.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "issues"
})
public class UserProfileErrorResponse implements HttpRequestResponse {

    @JsonProperty("metadata")
    @Schema(description = "Additional data related to but not part of the request response.")
    private Metadata metadata;

    @JsonProperty("issues")
    @Schema(description = "Reasons for the request error.")
    private List<Issue> issues;

    public UserProfileErrorResponse() {
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((issues == null) ? 0 : issues.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserProfileErrorResponse other = (UserProfileErrorResponse) obj;
        if (metadata == null) {
            if (other.metadata != null)
                return false;
        } else if (!metadata.equals(other.metadata))
            return false;
        if (issues == null) {
            if (other.issues != null)
                return false;
        } else if (!issues.equals(other.issues))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfileErrorResponse [metadata=" + metadata + ", issues=" + issues + "]";
    }

    
}
