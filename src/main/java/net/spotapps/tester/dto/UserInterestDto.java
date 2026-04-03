package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "interestId",
        "interest"
})
@Schema(description = "Represents a user's interest, including its unique identifier and the interest name.")
public class UserInterestDto {

    @JsonProperty("interestId")
    @Schema(description = "The unique identifier of the user's interest.", example = "1")
    private Long interestId;

    @JsonProperty("interest")
    @Schema(description = "The name of the user's interest.", example = "hiking")
    private String interest;

    public UserInterestDto() {
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((interestId == null) ? 0 : interestId.hashCode());
        result = prime * result + ((interest == null) ? 0 : interest.hashCode());
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
        UserInterestDto other = (UserInterestDto) obj;
        if (interestId == null) {
            if (other.interestId != null)
                return false;
        } else if (!interestId.equals(other.interestId))
            return false;
        if (interest == null) {
            if (other.interest != null)
                return false;
        } else if (!interest.equals(other.interest))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserInterestDto [interestId=" + interestId + ", interest=" + interest + "]";
    }

}
