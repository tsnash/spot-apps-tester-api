package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReligionPreferenceDto {
    @JsonProperty("religion")
    private ReligionDto religion;
    @JsonProperty("importance")
    @Min(0)
    @Max(5)
    private Integer importance;
    @JsonProperty("sameReligion")
    private Boolean sameReligion;

    public ReligionDto getReligion() { return religion; }
    public void setReligion(ReligionDto religion) { this.religion = religion; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
    public Boolean getSameReligion() { return sameReligion; }
    public void setSameReligion(Boolean sameReligion) { this.sameReligion = sameReligion; }
}
