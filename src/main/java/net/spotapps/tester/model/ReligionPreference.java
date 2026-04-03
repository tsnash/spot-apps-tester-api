package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "religion_id")
    private Religion religion;

    @Column(name = "importance")
    @Min(1)
    @Max(5)
    private Integer importance;

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
        if (userId != null) {
            return Objects.hash(userId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ReligionPreference))
            return false;
        ReligionPreference other = (ReligionPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ReligionPreference [userId=" + userId + "]";
    }
}
