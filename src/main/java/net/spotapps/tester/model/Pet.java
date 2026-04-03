package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_allowed")
    private Boolean isAllowed;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
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

    void setPetsPreference(PetsPreference petsPreference) {
        this.petsPreference = petsPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pet))
            return false;
        Pet other = (Pet) o;
        if (petId != null && other.getPetId() != null) {
            return Objects.equals(petId, other.getPetId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (petId != null) {
            return Objects.hash(petId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Pet [petId=" + petId + "]";
    }
}
