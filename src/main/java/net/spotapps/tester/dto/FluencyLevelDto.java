package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fluencyLevelId",
        "name"
})
public class FluencyLevelDto {

    @JsonProperty("fluencyLevelId")
    private Long fluencyLevelId;

    @JsonProperty("name")
    private String name;

    public FluencyLevelDto() {}

    public FluencyLevelDto(Long id, String name) {
        this.fluencyLevelId = id;
        this.name = name;
    }

    public Long getFluencyLevelId() {
        return fluencyLevelId;
    }

    public void setFluencyLevelId(Long id) {
        this.fluencyLevelId = id;
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
        FluencyLevelDto other = (FluencyLevelDto) o;
        return Objects.equals(fluencyLevelId, other.fluencyLevelId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fluencyLevelId, name);
    }

    @Override
    public String toString() {
        return "FluencyLevelDto [fluencyLevelId=" + fluencyLevelId + ", name=" + name + "]";
    }
}
