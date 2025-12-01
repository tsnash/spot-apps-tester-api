package net.spotapps.tester.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import net.spotapps.tester.dto.UserProfileDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "userProfiles"
})
public class UserProfileCollectionResponse implements HttpRequestResponse {

    @JsonProperty("metadata")
    @Schema(description = "Additional data related to but not part of the request response")
    private Metadata metadata;

    @JsonProperty("userProfiles")
    @Schema(description = "A profile of a user including all of their indicated preferences")
    private List<UserProfileDto> userProfiles;

    public UserProfileCollectionResponse() {
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<UserProfileDto> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfileDto> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((userProfiles == null) ? 0 : userProfiles.hashCode());
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
        UserProfileCollectionResponse other = (UserProfileCollectionResponse) obj;
        if (metadata == null) {
            if (other.metadata != null)
                return false;
        } else if (!metadata.equals(other.metadata))
            return false;
        if (userProfiles == null) {
            if (other.userProfiles != null)
                return false;
        } else if (!userProfiles.equals(other.userProfiles))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfileCollectionResponse [metadata=" + metadata + ", userProfiles=" + userProfiles + "]";
    }
    
}
