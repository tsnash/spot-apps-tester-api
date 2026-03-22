package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class EducationPreferenceDto {
    @JsonProperty("highestDegree")
    private EducationDegreeDto highestDegree;
    @JsonProperty("concentration")
    private String concentration;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public EducationDegreeDto getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(EducationDegreeDto highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
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
        if (!(o instanceof EducationPreferenceDto))
            return false;
        EducationPreferenceDto other = (EducationPreferenceDto) o;
        return Objects.equals(highestDegree, other.highestDegree) && Objects.equals(concentration, other.concentration)
                && Objects.equals(importance, other.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highestDegree, concentration, importance);
    }
}