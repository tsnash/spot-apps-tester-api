package net.spotapps.tester.dto;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import net.spotapps.tester.model.DietaryRestriction;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DietPreferenceDto {
    @JsonProperty("restrictions")
    private Set<DietaryRestriction> restrictions;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public Set<DietaryRestriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Set<DietaryRestriction> restrictions) {
        this.restrictions = restrictions;
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
        if (!(o instanceof DietPreferenceDto))
            return false;
        DietPreferenceDto other = (DietPreferenceDto) o;
        return Objects.equals(importance, other.importance) && Objects.equals(restrictions, other.restrictions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importance, restrictions);
    }

    @Override
    public String toString() {
        return "DietPreferenceDto [restrictions=" + restrictions + ", importance=" + importance + "]";
    }
}