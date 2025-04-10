package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_interests")
public class UserInterest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;

    @Column
    private String interest;

    @ManyToMany
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    public UserInterest(Long interestId, String interest) {
        this.interestId = interestId;
        this.interest = interest;
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
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
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
