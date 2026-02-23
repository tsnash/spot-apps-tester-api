package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "travelDistanceId",
        "name"
})
public class TravelDistanceDto {

    @JsonProperty("travelDistanceId")
    private Long travelDistanceId;

    @JsonProperty("name")
    private String name;

    public TravelDistanceDto() {}

    public TravelDistanceDto(Long id, String name) {
        this.travelDistanceId = id;
        this.name = name;
    }

    public Long getTravelDistanceId() {
        return travelDistanceId;
    }

    public void setTravelDistanceId(Long id) {
        this.travelDistanceId = id;
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
        TravelDistanceDto other = (TravelDistanceDto) o;
        return Objects.equals(travelDistanceId, other.travelDistanceId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelDistanceId, name);
    }

    @Override
    public String toString() {
        return "TravelDistanceDto [travelDistanceId=" + travelDistanceId + ", name=" + name + "]";
    }
}
