package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "relationshipStatusId",
        "name"
})
public class RelationshipStatusDto {

    @JsonProperty("relationshipStatusId")
    private Long relationshipStatusId;

    @JsonProperty("name")
    private String name;

    public RelationshipStatusDto() {}

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
