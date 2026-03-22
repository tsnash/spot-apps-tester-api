package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "travelDurationId",
        "name"
})
public class TravelDurationDto {

    @JsonProperty("travelDurationId")
    private Long travelDurationId;

    @JsonProperty("name")
    private String name;

    public TravelDurationDto() {
    }

    public TravelDurationDto(Long id, String name) {
        this.travelDurationId = id;
        this.name = name;
    }

    public Long getTravelDurationId() {
        return travelDurationId;
    }

    public void setTravelDurationId(Long id) {
        this.travelDurationId = id;
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
        TravelDurationDto other = (TravelDurationDto) o;
        return Objects.equals(travelDurationId, other.travelDurationId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelDurationId, name);
    }

    @Override
    public String toString() {
        return "TravelDurationDto [travelDurationId=" + travelDurationId + ", name=" + name + "]";
    }
}
