package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "location_preferences")
public class LocationPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "Whether to use the user's current location or specified location")
    @Column(name = "use_local", nullable = false, columnDefinition = "boolean default false")
    private Boolean useLocal = false;

    @Schema(description = "The maximum distance in miles the user is willing to search")
    @Column(name = "distance_in_miles")
    private Double distanceInMiles = 15.0;

    @Schema(description = "The maximum distance in kilometers the user is willing to search")
    @Column(name = "distance_in_kilometers")
    private Double distanceInKilometers = 24.1401;

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

    public Boolean getUseLocal() {
        return useLocal;
    }

    public void setUseLocal(Boolean useLocal) {
        this.useLocal = useLocal;
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(Double distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
        if (distanceInMiles != null) {
            this.distanceInKilometers = distanceInMiles * 1.60934;
        } else {
            this.distanceInKilometers = null;
        }
    }

    public Double getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public void setDistanceInKilometers(Double distanceInKilometers) {
        this.distanceInKilometers = distanceInKilometers;
        if (distanceInKilometers != null) {
            this.distanceInMiles = distanceInKilometers / 1.60934;
        } else {
            this.distanceInMiles = null;
        }
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
        if (!(obj instanceof LocationPreference))
            return false;
        LocationPreference other = (LocationPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "LocationPreference [userId=" + userId + "]";
    }
}
