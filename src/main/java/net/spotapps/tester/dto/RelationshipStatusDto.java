package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipStatusId",
        "name"
})
@Schema(description = "Represents a relationship status.")
public class RelationshipStatusDto {

    @JsonProperty("relationshipStatusId")
    @Schema(description = "The unique identifier for the relationship status.", example = "1")
    private Long relationshipStatusId;

    @JsonProperty("name")
    @Schema(description = "The name of the relationship status.", example = "single")
    private String name;

    public RelationshipStatusDto() {
    }

    public RelationshipStatusDto(Long id, String name) {
        this.relationshipStatusId = id;
        this.name = name;
    }

    public Long getRelationshipStatusId() {
        return relationshipStatusId;
    }

    public void setRelationshipStatusId(Long id) {
        this.relationshipStatusId = id;
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
        if (o == null || getClass() != o.getClass())
            return false;
        RelationshipStatusDto other = (RelationshipStatusDto) o;
        return Objects.equals(relationshipStatusId, other.relationshipStatusId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipStatusId, name);
    }

    @Override
    public String toString() {
        return "RelationshipStatusDto [relationshipStatusId=" + relationshipStatusId + ", name=" + name + "]";
    }
}
