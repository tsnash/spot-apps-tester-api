package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lifeStageId",
        "name"
})
public class LifeStageDto {

    @JsonProperty("lifeStageId")
    private Long lifeStageId;

    @JsonProperty("name")
    private String name;

    public LifeStageDto() {}

    public LifeStageDto(Long id, String name) {
        this.lifeStageId = id;
        this.name = name;
    }

    public Long getLifeStageId() {
        return lifeStageId;
    }

    public void setLifeStageId(Long id) {
        this.lifeStageId = id;
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
        LifeStageDto other = (LifeStageDto) o;
        return Objects.equals(lifeStageId, other.lifeStageId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lifeStageId, name);
    }

    @Override
    public String toString() {
        return "LifeStageDto [lifeStageId=" + lifeStageId + ", name=" + name + "]";
    }
}
