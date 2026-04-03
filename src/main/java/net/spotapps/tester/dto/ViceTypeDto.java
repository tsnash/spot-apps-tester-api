package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "viceTypeId",
        "name"
})
@Schema(description = "Represents a type of vice.")
public class ViceTypeDto {

    @JsonProperty("viceTypeId")
    @Schema(description = "The unique identifier of the vice type.", example = "1")
    private Long viceTypeId;

    @JsonProperty("name")
    @Schema(description = "The name of the vice type.", example = "smoking")
    private String name;

    public ViceTypeDto() {
    }

    public ViceTypeDto(Long id, String name) {
        this.viceTypeId = id;
        this.name = name;
    }

    public Long getViceTypeId() {
        return viceTypeId;
    }

    public void setViceTypeId(Long id) {
        this.viceTypeId = id;
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
        ViceTypeDto other = (ViceTypeDto) o;
        return Objects.equals(viceTypeId, other.viceTypeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceTypeId, name);
    }

    @Override
    public String toString() {
        return "ViceTypeDto [viceTypeId=" + viceTypeId + ", name=" + name + "]";
    }
}
