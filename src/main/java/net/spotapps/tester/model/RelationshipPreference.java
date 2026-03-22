package net.spotapps.tester.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relationship_preferences")
public class RelationshipPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "The current relationship status of the user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private RelationshipStatus relationshipStatus;

    @Schema(description = "The relationship practices the user follows or is open to")
    @ManyToMany
    @JoinTable(
        name = "user_relationship_practices",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "practice_id")
    )
    private Set<RelationshipPractice> relationshipPractices = new HashSet<>();

    @Schema(description = "The types of relationships the user is interested in")
    @ManyToMany
    @JoinTable(
        name = "user_relationship_interests",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<RelationshipInterest> relationshipInterests = new HashSet<>();

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

    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public Set<RelationshipPractice> getRelationshipPractices() {
        return relationshipPractices;
    }

    public void setRelationshipPractices(Set<RelationshipPractice> relationshipPractices) {
        if (this.relationshipPractices == null) {
            this.relationshipPractices = new HashSet<>();
        }
        this.relationshipPractices.clear();
        if (relationshipPractices != null) {
            this.relationshipPractices.addAll(relationshipPractices);
        }
    }

    public Set<RelationshipInterest> getRelationshipInterests() {
        return relationshipInterests;
    }

    public void setRelationshipInterests(Set<RelationshipInterest> relationshipInterests) {
        if (this.relationshipInterests == null) {
            this.relationshipInterests = new HashSet<>();
        }
        this.relationshipInterests.clear();
        if (relationshipInterests != null) {
            this.relationshipInterests.addAll(relationshipInterests);
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
        if (!(obj instanceof RelationshipPreference))
            return false;
        RelationshipPreference other = (RelationshipPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "RelationshipPreference [userId=" + userId + "]";
    }
}
