package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "travelDistanceId",
        "name"
})
@Schema(description = "Represents a user's preference regarding distance from origin while traveling.")
public class TravelDistanceDto {

    @JsonProperty("travelDistanceId")
    @Schema(description = "The ID of the travel distance preference.", example = "1")
    private Long travelDistanceId;

    @JsonProperty("name")
    @Schema(description = "The name of the travel distance preference.", example = "local")
    private String name;

    public TravelDistanceDto() {
    }

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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
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
