package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "status_id")
    private RelationshipStatus relationshipStatus;

    @Schema(description = "The relationship practices the user follows or is open to")
    @ManyToMany
    @JoinTable(
        name = "user_relationship_practices",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "practice_id")
    )
    private Set<RelationshipPractice> relationshipPractices;

    @Schema(description = "The types of relationships the user is interested in")
    @ManyToMany
    @JoinTable(
        name = "user_relationship_interests",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<RelationshipInterest> relationshipInterests;

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
        this.relationshipPractices = relationshipPractices;
    }

    public Set<RelationshipInterest> getRelationshipInterests() {
        return relationshipInterests;
    }

    public void setRelationshipInterests(Set<RelationshipInterest> relationshipInterests) {
        this.relationshipInterests = relationshipInterests;
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
        RelationshipPreference other = (RelationshipPreference) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "RelationshipPreference [userId=" + userId + "]";
    }
}
