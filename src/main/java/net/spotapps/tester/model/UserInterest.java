package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_interests")
public class UserInterest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private Long interestId;

    @Column
    private String interest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    public UserInterest() {
    }

    public UserInterest(Long interestId, String interest) {
        this.interestId = interestId;
        this.interest = interest;
    }

    public UserInterest(String interest, UserProfile userProfile) {
        this.interest = interest;
        this.userProfile = userProfile;
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((interestId == null) ? 0 : interestId.hashCode());
        result = prime * result + ((interest == null) ? 0 : interest.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof UserInterest))
            return false;
        UserInterest other = (UserInterest) obj;
        if (interestId == null) {
            if (other.interestId != null)
                return false;
        } else if (!interestId.equals(other.interestId))
            return false;
        if (interest == null) {
            if (other.interest != null)
                return false;
        } else if (!interest.equals(other.interest))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserInterest [interestId=" + interestId + ", interest=" + interest + "]";
    }

    
    
}
