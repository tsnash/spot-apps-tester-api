package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pets",
        "importance"
})
@Schema(description = "Represents a user's pets and their preference for matches with pets.")
public class PetsPreferenceDto {

    @JsonProperty("pets")
    @Schema(description = "A list of pets associated with the user.")
    private List<PetDto> pets;

    @JsonProperty("importance")
    @Schema(description = "How important pets are to the user", minimum = "1", maximum = "5", example = "3")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<PetDto> getPets() {
        return pets;
    }

    public void setPets(List<PetDto> pets) {
        this.pets = pets;
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
        if (!(o instanceof PetsPreferenceDto))
            return false;
        PetsPreferenceDto other = (PetsPreferenceDto) o;
        return Objects.equals(importance, other.importance) && Objects.equals(pets, other.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importance, pets);
    }

    @Override
    public String toString() {
        return "PetsPreferenceDto [pets=" + pets + ", importance=" + importance + "]";
    }
}