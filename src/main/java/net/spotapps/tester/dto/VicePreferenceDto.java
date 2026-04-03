package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Represents a user's preferences regarding vices such as smoking, drinking, etc.")
public class VicePreferenceDto {

    @JsonProperty("vices")
    @Schema(description = "The list of vices the user has preferences about.")
    private List<ViceDto> vices;

    @JsonProperty("importance")
    @Schema(description = "The importance of the user's vice preferences.", minimum = "1", maximum = "5", example = "3")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<ViceDto> getVices() {
        return vices;
    }

    public void setVices(List<ViceDto> vices) {
        this.vices = vices;
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
        if (!(o instanceof VicePreferenceDto))
            return false;
        VicePreferenceDto other = (VicePreferenceDto) o;
        return Objects.equals(importance, other.importance)
                && Objects.equals(vices, other.vices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importance, vices);
    }

    @Override
    public String toString() {
        return "VicePreferenceDto [vices=" + vices + ", importance=" + importance + "]";
    }
}