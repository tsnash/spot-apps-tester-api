package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.CollectionTable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;

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

    @Schema(description = "The dietary restrictions of the user")
    @ElementCollection(targetClass = DietaryRestriction.class)
    @CollectionTable(name = "user_dietary_restrictions", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "restriction", columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private Set<DietaryRestriction> restrictions;

    @Schema(description = "The importance of dietary preferences to the user (1-5)")
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
        this.restrictions = restrictions;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DietPreference other = (DietPreference) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "DietPreference [userId=" + userId + "]";
    }
}
