package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "petTypeId",
        "name"
})
public class PetTypeDto {

    @JsonProperty("petTypeId")
    private Long petTypeId;

    @JsonProperty("name")
    private String name;

    public PetTypeDto() {}

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
