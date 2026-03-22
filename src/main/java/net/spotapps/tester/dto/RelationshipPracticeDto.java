package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipPracticeId",
        "name"
})
public class RelationshipPracticeDto {

    @JsonProperty("relationshipPracticeId")
    private Long relationshipPracticeId;

    @JsonProperty("name")
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
