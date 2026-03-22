package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipInterestId",
        "name"
})
public class RelationshipInterestDto {

    @JsonProperty("relationshipInterestId")
    private Long relationshipInterestId;

    @JsonProperty("name")
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
        if (o == null || getClass() != o.getClass())
            return false;
        RelationshipInterestDto other = (RelationshipInterestDto) o;
        return Objects.equals(relationshipInterestId, other.relationshipInterestId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipInterestId, name);
    }

    @Override
    public String toString() {
        return "RelationshipInterestDto [relationshipInterestId=" + relationshipInterestId + ", name=" + name + "]";
    }
}
