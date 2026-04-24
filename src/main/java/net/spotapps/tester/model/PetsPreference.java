package net.spotapps.tester.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "pets_preferences")
public class PetsPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "petsPreference", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("petId ASC")
    private Set<Pet> pets = new LinkedHashSet<>();

    @Column(name = "importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    @Column(name = "is_allowed")
    private Boolean isAllowed;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        if (this.pets == null) {
            this.pets = new LinkedHashSet<>();
        }
        // Maintain bidirectional consistency
        this.pets.forEach(p -> p.setPetsPreference(null));
        this.pets.clear();
        if (pets != null) {
            for (Pet pet : pets) {
                pet.setPetsPreference(this);
                this.pets.add(pet);
            }
        }
    }

    public void addPet(Pet pet) {
        if (pet != null) {
            this.pets.add(pet);
            pet.setPetsPreference(this);
        }
    }

    public void removePet(Pet pet) {
        if (pet != null) {
            this.pets.remove(pet);
            pet.setPetsPreference(null);
        }
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Boolean getIsAllowed() {
        return isAllowed;
    }

    public void setIsAllowed(Boolean isAllowed) {
        this.isAllowed = isAllowed;
    }

    @Override
    public int hashCode() {
        if (userId != null) {
            return Objects.hash(userId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PetsPreference))
            return false;
        PetsPreference other = (PetsPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "PetsPreference [userId=" + userId + "]";
    }
}
