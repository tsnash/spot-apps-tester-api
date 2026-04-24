package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "petId",
        "petType",
        "quantity"
})
@Schema(description = "Represents a pet owned by or allowed by a user.")
public class PetDto {

    @JsonProperty("petId")
    @Schema(description = "The unique identifier for the pet record.", example = "1")
    private Long petId;

    @JsonProperty("petType")
    @Schema(description = "The type of pet.")
    private PetTypeDto petType;

    @JsonProperty("quantity")
    @Schema(description = "The number of pets of this type. A value of -1 indicates this specific pet type is prohibited.", minimum = "-1", example = "1")
    @Min(-1)
    private Integer quantity;

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public PetTypeDto getPetType() {
        return petType;
    }

    public void setPetType(PetTypeDto petType) {
        this.petType = petType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PetDto petDto = (PetDto) o;
        return Objects.equals(petId, petDto.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }
}
