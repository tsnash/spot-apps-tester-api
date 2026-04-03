package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pet_types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_type_id")
    private Long petTypeId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public Long getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Long petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PetType))
            return false;
        PetType that = (PetType) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PetType [petTypeId=" + petTypeId + ", name=" + name + "]";
    }
}
