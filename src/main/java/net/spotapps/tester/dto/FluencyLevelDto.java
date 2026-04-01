package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fluencyLevelId",
        "name"
})
@Schema(description = "Represents a level of language fluency.")
public class FluencyLevelDto {

    @JsonProperty("fluencyLevelId")
    @Schema(description = "The unique identifier for the fluency level.", example = "1")
    private Long fluencyLevelId;

    @JsonProperty("name")
    @Schema(description = "The name of the fluency level.", example = "native")
    private String name;

    public FluencyLevelDto() {
    }

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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
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
