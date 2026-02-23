package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "viceFrequencyId",
        "name"
})
public class ViceFrequencyDto {

    @JsonProperty("viceFrequencyId")
    private Long viceFrequencyId;

    @JsonProperty("name")
    private String name;

    public ViceFrequencyDto() {}

    public ViceFrequencyDto(Long id, String name) {
        this.viceFrequencyId = id;
        this.name = name;
    }

    public Long getViceFrequencyId() {
        return viceFrequencyId;
    }

    public void setViceFrequencyId(Long id) {
        this.viceFrequencyId = id;
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
        ViceFrequencyDto other = (ViceFrequencyDto) o;
        return Objects.equals(viceFrequencyId, other.viceFrequencyId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceFrequencyId, name);
    }

    @Override
    public String toString() {
        return "ViceFrequencyDto [viceFrequencyId=" + viceFrequencyId + ", name=" + name + "]";
    }
}
