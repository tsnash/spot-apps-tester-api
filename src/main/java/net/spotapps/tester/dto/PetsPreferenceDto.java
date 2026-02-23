package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetsPreferenceDto {
    @JsonProperty("pets")
    private List<PetDto> pets;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<PetDto> getPets() { return pets; }
    public void setPets(List<PetDto> pets) { this.pets = pets; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
}
