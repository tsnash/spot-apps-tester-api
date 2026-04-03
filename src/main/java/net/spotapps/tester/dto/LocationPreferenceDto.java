package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "useLocal",
        "distanceInMiles",
        "distanceInKilometers"
})
@Schema(description = "Represents a user's location preferences for matching.")
public class LocationPreferenceDto {

    @JsonProperty("useLocal")
    @Schema(description = "Indicates whether the user prefers local matches.", example = "true")
    private Boolean useLocal;

    @JsonProperty("distanceInMiles")
    @Schema(description = "The maximum preferred distance in miles.", example = "25.0")
    private Double distanceInMiles;

    @JsonProperty("distanceInKilometers")
    @Schema(description = "The maximum preferred distance in kilometers.", example = "40.23")
    private Double distanceInKilometers;

    public Boolean getUseLocal() {
        return useLocal;
    }

    public void setUseLocal(Boolean useLocal) {
        this.useLocal = useLocal;
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(Double distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }

    public Double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public void setDistanceInKilometers(Double distanceInKilometers) {
        this.distanceInKilometers = distanceInKilometers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LocationPreferenceDto))
            return false;
        LocationPreferenceDto other = (LocationPreferenceDto) o;
        return Objects.equals(useLocal, other.useLocal) && Objects.equals(distanceInMiles, other.distanceInMiles)
                && Objects.equals(distanceInKilometers, other.distanceInKilometers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useLocal, distanceInMiles, distanceInKilometers);
    }

    @Override
    public String toString() {
        return "LocationPreferenceDto [useLocal=" + useLocal + ", distanceInMiles=" + distanceInMiles
                + ", distanceInKilometers=" + distanceInKilometers + "]";
    }
}