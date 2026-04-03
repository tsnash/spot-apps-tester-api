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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "gender_preferences")
public class GenderPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @NotNull
    @Column(name = "is_trans", nullable = false, columnDefinition = "boolean default false")
    private Boolean isTrans = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orientation_id")
    private Orientation orientation;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getTrans() {
        return isTrans;
    }

    public void setTrans(Boolean isTrans) {
        this.isTrans = isTrans != null ? isTrans : false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
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
        if (!(obj instanceof GenderPreference))
            return false;
        GenderPreference other = (GenderPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "GenderPreference [userId=" + userId + "]";
    }
}
