package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "petTypeId",
        "name"
})
@Schema(description = "Represents a type of pet.")
public class PetTypeDto {

    @JsonProperty("petTypeId")
    @Schema(description = "The unique identifier for the pet type.", example = "1")
    private Long petTypeId;

    @JsonProperty("name")
    @Schema(description = "The name of the pet type.", example = "dog")
    private String name;

    public PetTypeDto() {
    }

    public PetTypeDto(Long id, String name) {
        this.petTypeId = id;
        this.name = name;
    }

    public Long getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Long id) {
        this.petTypeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PetTypeDto other = (PetTypeDto) o;
        return Objects.equals(petTypeId, other.petTypeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petTypeId, name);
    }

    @Override
    public String toString() {
        return "PetTypeDto [petTypeId=" + petTypeId + ", name=" + name + "]";
    }
}
