package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_allowed")
    private Boolean isAllowed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private PetsPreference petsPreference;

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
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

    public PetsPreference getPetsPreference() {
        return petsPreference;
    }

    public void setPetsPreference(PetsPreference petsPreference) {
        this.petsPreference = petsPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }

    @Override
    public String toString() {
        return "Pet [petId=" + petId + "]";
    }
}
