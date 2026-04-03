package net.spotapps.tester.dto;

import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "frequency",
        "duration",
        "distance",
        "groupSize",
        "importance"
})
@Schema(description = "Represents a user's travel preferences.")
public class TravelPreferenceDto {

    @JsonProperty("frequency")
    @Schema(description = "The travel frequency preference.")
    private TravelFrequencyDto frequency;

    @JsonProperty("duration")
    @Schema(description = "The travel duration preference.")
    private TravelDurationDto duration;

    @JsonProperty("distance")
    @Schema(description = "The travel distance preference.")
    private TravelDistanceDto distance;

    @JsonProperty("groupSize")
    @Schema(description = "The travel group size preference.")
    private TravelGroupSizeDto groupSize;

    @JsonProperty("importance")
    @Schema(description = "The importance of the travel preferences.", minimum = "1", maximum = "5", example = "3")
    @Min(1)
    @Max(5)
    private Integer importance;

    public TravelFrequencyDto getFrequency() {
        return frequency;
    }

    public void setFrequency(TravelFrequencyDto frequency) {
        this.frequency = frequency;
    }

    public TravelDurationDto getDuration() {
        return duration;
    }

    public void setDuration(TravelDurationDto duration) {
        this.duration = duration;
    }

    public TravelDistanceDto getDistance() {
        return distance;
    }

    public void setDistance(TravelDistanceDto distance) {
        this.distance = distance;
    }

    public TravelGroupSizeDto getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(TravelGroupSizeDto groupSize) {
        this.groupSize = groupSize;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TravelPreferenceDto))
            return false;
        TravelPreferenceDto other = (TravelPreferenceDto) o;
        return Objects.equals(frequency, other.frequency) && Objects.equals(duration, other.duration)
                && Objects.equals(distance, other.distance) && Objects.equals(groupSize, other.groupSize)
                && Objects.equals(importance, other.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, duration, distance, groupSize, importance);
    }

    @Override
    public String toString() {
        return "TravelPreferenceDto [frequency=" + frequency + ", duration=" + duration + ", distance=" + distance
                + ", groupSize=" + groupSize + ", importance=" + importance + "]";
    }
}