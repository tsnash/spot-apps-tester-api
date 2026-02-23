package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    public EducationDegreeDto getHighestDegree() { return highestDegree; }
    public void setHighestDegree(EducationDegreeDto highestDegree) { this.highestDegree = highestDegree; }
    public String getConcentration() { return concentration; }
    public void setConcentration(String concentration) { this.concentration = concentration; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
}
