package net.spotapps.tester.dto;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipStatus",
        "relationshipPractices",
        "relationshipInterests"
})
@Schema(description = "Represents a user's current relationship status and preferences.")
public class RelationshipPreferenceDto {

    @JsonProperty("relationshipStatus")
    @Schema(description = "The current relationship status of the user.")
    private RelationshipStatusDto relationshipStatus;

    @JsonProperty("relationshipPractices")
    @Schema(description = "The relationship practices the user follows or prefers.")
    private Set<RelationshipPracticeDto> relationshipPractices;

    @JsonProperty("relationshipInterests")
    @Schema(description = "The relationship interests of the user.")
    private Set<RelationshipInterestDto> relationshipInterests;

    public RelationshipStatusDto getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipStatusDto relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public Set<RelationshipPracticeDto> getRelationshipPractices() {
        return relationshipPractices;
    }

    public void setRelationshipPractices(Set<RelationshipPracticeDto> relationshipPractices) {
        this.relationshipPractices = relationshipPractices;
    }

    public Set<RelationshipInterestDto> getRelationshipInterests() {
        return relationshipInterests;
    }

    public void setRelationshipInterests(Set<RelationshipInterestDto> relationshipInterests) {
        this.relationshipInterests = relationshipInterests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RelationshipPreferenceDto))
            return false;
        RelationshipPreferenceDto other = (RelationshipPreferenceDto) o;
        return Objects.equals(relationshipStatus, other.relationshipStatus)
                && Objects.equals(relationshipPractices, other.relationshipPractices)
                && Objects.equals(relationshipInterests, other.relationshipInterests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipStatus, relationshipPractices, relationshipInterests);
    }

    @Override
    public String toString() {
        return "RelationshipPreferenceDto [relationshipStatus=" + relationshipStatus + ", relationshipPractices="
                + relationshipPractices + ", relationshipInterests=" + relationshipInterests + "]";
    }
}