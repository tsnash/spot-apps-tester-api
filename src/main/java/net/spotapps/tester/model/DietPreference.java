package net.spotapps.tester.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "diet_preferences")
public class DietPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @ElementCollection(targetClass = DietaryRestriction.class)
    @CollectionTable(name = "user_dietary_restrictions", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "restriction", columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private Set<DietaryRestriction> restrictions = new HashSet<>();

    @Column(name = "importance")
    @Min(1)
    @Max(5)
    private Integer importance;

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

    public Set<DietaryRestriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Set<DietaryRestriction> restrictions) {
        if (this.restrictions == null) {
            this.restrictions = new HashSet<>();
        }
        this.restrictions.clear();
        if (restrictions != null) {
            this.restrictions.addAll(restrictions);
        }
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
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
        if (!(obj instanceof DietPreference))
            return false;
        DietPreference other = (DietPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "DietPreference [userId=" + userId + "]";
    }
}
