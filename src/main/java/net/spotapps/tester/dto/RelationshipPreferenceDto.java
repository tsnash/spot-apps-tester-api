package net.spotapps.tester.dto;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class RelationshipPreferenceDto {
    @JsonProperty("relationshipStatus")
    private RelationshipStatusDto relationshipStatus;
    @JsonProperty("relationshipPractices")
    private Set<RelationshipPracticeDto> relationshipPractices;
    @JsonProperty("relationshipInterests")
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
        return Objects.equals(relationshipStatus, other.relationshipStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipStatus);
    }
}