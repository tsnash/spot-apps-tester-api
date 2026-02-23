package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.spotapps.tester.model.DietaryRestriction;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DietPreferenceDto {
    @JsonProperty("restrictions")
    private Set<DietaryRestriction> restrictions;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public Set<DietaryRestriction> getRestrictions() { return restrictions; }
    public void setRestrictions(Set<DietaryRestriction> restrictions) { this.restrictions = restrictions; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
}
