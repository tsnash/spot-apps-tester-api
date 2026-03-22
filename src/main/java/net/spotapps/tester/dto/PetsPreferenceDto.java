package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetsPreferenceDto)) return false;
        PetsPreferenceDto other = (PetsPreferenceDto) o;
        return Objects.equals(importance, other.importance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importance);
    }
}