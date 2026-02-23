package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.ManyToOne;
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

@Entity
@Table(name = "religion_preferences")
public class ReligionPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "The religious affiliation of the user")
    @ManyToOne
    @JoinColumn(name = "religion_id")
    private Religion religion;

    @Schema(description = "The importance of religion to the user (0-5)")
    @Column(name = "importance")
    @Min(0)
    @Max(5)
    private Integer importance;

    @Schema(description = "Whether the user prefers a partner with the same religion")
    @Column(name = "same_religion")
    private Boolean sameReligion;

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

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Boolean getSameReligion() {
        return sameReligion;
    }

    public void setSameReligion(Boolean sameReligion) {
        this.sameReligion = sameReligion;
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
        ReligionPreference other = (ReligionPreference) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "ReligionPreference [userId=" + userId + "]";
    }
}
