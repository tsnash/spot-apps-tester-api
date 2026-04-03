package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "religion",
        "importance",
        "sameReligion"
})
@Schema(description = "Represents a user's religion preference for matches.")
public class ReligionPreferenceDto {

    @JsonProperty("religion")
    @Schema(description = "The religion the user practices.")
    private ReligionDto religion;

    @JsonProperty("importance")
    @Schema(description = "The importance of the user's religion preference.", example = "3")
    @Min(1)
    @Max(5)
    private Integer importance;

    @JsonProperty("sameReligion")
    @Schema(description = "Whether the user wants to match with someone with similar beliefs.", example = "true")
    private Boolean sameReligion;

    public ReligionDto getReligion() {
        return religion;
    }

    public void setReligion(ReligionDto religion) {
        this.religion = religion;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Boolean getSameReligion() {
        return sameReligion;
    }

    public void setSameReligion(Boolean sameReligion) {
        this.sameReligion = sameReligion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ReligionPreferenceDto))
            return false;
        ReligionPreferenceDto other = (ReligionPreferenceDto) o;
        return Objects.equals(religion, other.religion) && Objects.equals(importance, other.importance)
                && Objects.equals(sameReligion, other.sameReligion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(religion, importance, sameReligion);
    }

    @Override
    public String toString() {
        return "ReligionPreferenceDto [religion=" + religion + ", importance=" + importance + ", sameReligion="
                + sameReligion + "]";
    }
}