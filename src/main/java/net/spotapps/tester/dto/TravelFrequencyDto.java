package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "travelFrequencyId",
        "name"
})
public class TravelFrequencyDto {

    @JsonProperty("travelFrequencyId")
    private Long travelFrequencyId;

    @JsonProperty("name")
    private String name;

    public TravelFrequencyDto() {
    }

    public TravelFrequencyDto(Long id, String name) {
        this.travelFrequencyId = id;
        this.name = name;
    }

    public Long getTravelFrequencyId() {
        return travelFrequencyId;
    }

    public void setTravelFrequencyId(Long id) {
        this.travelFrequencyId = id;
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
        TravelFrequencyDto other = (TravelFrequencyDto) o;
        return Objects.equals(travelFrequencyId, other.travelFrequencyId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelFrequencyId, name);
    }

    @Override
    public String toString() {
        return "TravelFrequencyDto [travelFrequencyId=" + travelFrequencyId + ", name=" + name + "]";
    }
}
