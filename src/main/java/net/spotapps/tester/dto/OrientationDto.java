package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "orientationId",
        "name"
})
public class OrientationDto {

    @JsonProperty("orientationId")
    private Long orientationId;

    @JsonProperty("name")
    private String name;

    public OrientationDto() {}

    public OrientationDto(Long id, String name) {
        this.orientationId = id;
        this.name = name;
    }

    public Long getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(Long id) {
        this.orientationId = id;
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
        OrientationDto other = (OrientationDto) o;
        return Objects.equals(orientationId, other.orientationId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientationId, name);
    }

    @Override
    public String toString() {
        return "OrientationDto [orientationId=" + orientationId + ", name=" + name + "]";
    }
}
