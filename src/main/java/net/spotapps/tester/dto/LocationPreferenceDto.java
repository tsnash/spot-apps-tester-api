package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationPreferenceDto {
    @JsonProperty("useLocal")
    private boolean useLocal;
    @JsonProperty("distanceInMiles")
    private Double distanceInMiles;
    @JsonProperty("distanceInKilometers")
    private Double distanceInKilometers;

    public boolean isUseLocal() { return useLocal; }
    public void setUseLocal(boolean useLocal) { this.useLocal = useLocal; }
    public Double getDistanceInMiles() { return distanceInMiles; }
    public void setDistanceInMiles(Double distanceInMiles) { this.distanceInMiles = distanceInMiles; }
    public Double getDistanceInKilometers() { return distanceInKilometers; }
    public void setDistanceInKilometers(Double distanceInKilometers) { this.distanceInKilometers = distanceInKilometers; }
}
