package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationPreferenceDto {
    @JsonProperty("useLocal")
    private Boolean useLocal;
    @JsonProperty("distanceInMiles")
    private Double distanceInMiles;
    @JsonProperty("distanceInKilometers")
    private Double distanceInKilometers;

    public Boolean getUseLocal() { return useLocal; }
    public void setUseLocal(Boolean useLocal) { this.useLocal = useLocal; }
    public Double getDistanceInMiles() { return distanceInMiles; }
    public void setDistanceInMiles(Double distanceInMiles) { this.distanceInMiles = distanceInMiles; }
    public Double getDistanceInKilometers() { return distanceInKilometers; }
    public void setDistanceInKilometers(Double distanceInKilometers) { this.distanceInKilometers = distanceInKilometers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationPreferenceDto)) return false;
        LocationPreferenceDto other = (LocationPreferenceDto) o;
        return Objects.equals(useLocal, other.useLocal) && Objects.equals(distanceInMiles, other.distanceInMiles) && Objects.equals(distanceInKilometers, other.distanceInKilometers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useLocal, distanceInMiles, distanceInKilometers);
    }
}