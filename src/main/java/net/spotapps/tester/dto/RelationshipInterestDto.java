package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipInterestId",
        "name"
})
@Schema(description = "Represents interest in a relationship type.")
public class RelationshipInterestDto {

    @JsonProperty("relationshipInterestId")
    @Schema(description = "The unique identifier for the relationship interest.", example = "1")
    private Long relationshipInterestId;

    @JsonProperty("name")
    @Schema(description = "The name of the relationship interest.", example = "monogamous")
    private String name;

    public RelationshipInterestDto() {
    }

    public RelationshipInterestDto(Long id, String name) {
        this.relationshipInterestId = id;
        this.name = name;
    }

    public Long getRelationshipInterestId() {
        return relationshipInterestId;
    }

    public void setRelationshipInterestId(Long id) {
        this.relationshipInterestId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RelationshipInterestDto other))
            return false;
        if (this.relationshipInterestId != null && other.relationshipInterestId != null) {
            return Objects.equals(this.relationshipInterestId, other.relationshipInterestId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return relationshipInterestId != null ? relationshipInterestId.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "RelationshipInterestDto [relationshipInterestId=" + relationshipInterestId + ", name=" + name + "]";
    }
}
