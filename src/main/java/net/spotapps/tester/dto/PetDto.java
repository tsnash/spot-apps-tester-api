package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetDto {

    @JsonProperty("petId")
    private Long petId;

    @JsonProperty("petType")
    private PetTypeDto petType;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("isAllowed")
    private Boolean isAllowed;

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

    public Boolean getIsAllowed() {
        return isAllowed;
    }

    public void setIsAllowed(Boolean isAllowed) {
        this.isAllowed = isAllowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetDto petDto = (PetDto) o;
        return Objects.equals(petId, petDto.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }
}
