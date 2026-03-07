package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vice_preferences")
public class VicePreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "List of user's vices and their frequencies")
    @OneToMany(mappedBy = "vicePreference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vice> vices = new ArrayList<>();

    @Schema(description = "The importance of vice preferences to the user (1-5)")
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

    public List<Vice> getVices() {
        return vices;
    }

    public void setVices(List<Vice> vices) {
        if (this.vices == null) {
            this.vices = new ArrayList<>();
        }
        // Maintain bidirectional consistency
        this.vices.forEach(v -> v.setVicePreference(null));
        this.vices.clear();
        if (vices != null) {
            for (Vice vice : vices) {
                vice.setVicePreference(this);
                this.vices.add(vice);
            }
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
        if (!(obj instanceof VicePreference))
            return false;
        VicePreference other = (VicePreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "VicePreference [userId=" + userId + "]";
    }
}
