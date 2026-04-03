package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipPracticeId",
        "name"
})
@Schema(description = "Represents a relationship practice.")
public class RelationshipPracticeDto {

    @JsonProperty("relationshipPracticeId")
    @Schema(description = "The unique identifier for the relationship practice.", example = "1")
    private Long relationshipPracticeId;

    @JsonProperty("name")
    @Schema(description = "The name of the relationship practice.", example = "monogamy")
    private String name;

    public RelationshipPracticeDto() {
    }

    public RelationshipPracticeDto(Long id, String name) {
        this.relationshipPracticeId = id;
        this.name = name;
    }

    public Long getRelationshipPracticeId() {
        return relationshipPracticeId;
    }

    public void setRelationshipPracticeId(Long id) {
        this.relationshipPracticeId = id;
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
        RelationshipPracticeDto other = (RelationshipPracticeDto) o;
        return Objects.equals(relationshipPracticeId, other.relationshipPracticeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipPracticeId, name);
    }

    @Override
    public String toString() {
        return "RelationshipPracticeDto [relationshipPracticeId=" + relationshipPracticeId + ", name=" + name + "]";
    }
}
