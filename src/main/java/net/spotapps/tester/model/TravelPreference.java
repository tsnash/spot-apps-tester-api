package net.spotapps.tester.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "travel_preferences")
public class TravelPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "How often the user likes to travel")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frequency_id")
    private TravelFrequency frequency;

    @Schema(description = "Preferred duration of trips")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duration_id")
    private TravelDuration duration;

    @Schema(description = "How far the user is willing to travel")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distance_id")
    private TravelDistance distance;

    @Schema(description = "Preferred travel group size")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_size_id")
    private TravelGroupSize groupSize;

    @Schema(description = "The importance of travel preferences to the user (1-5)")
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

    public TravelFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(TravelFrequency frequency) {
        this.frequency = frequency;
    }

    public TravelDuration getDuration() {
        return duration;
    }

    public void setDuration(TravelDuration duration) {
        this.duration = duration;
    }

    public TravelDistance getDistance() {
        return distance;
    }

    public void setDistance(TravelDistance distance) {
        this.distance = distance;
    }

    public TravelGroupSize getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(TravelGroupSize groupSize) {
        this.groupSize = groupSize;
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
        if (!(obj instanceof TravelPreference))
            return false;
        TravelPreference other = (TravelPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "TravelPreference [userId=" + userId + "]";
    }
}
