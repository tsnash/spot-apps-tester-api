package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "social_personalities")
public class SocialPersonality {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "Openness to experience trait")
    @ManyToOne
    @JoinColumn(name = "openness_id")
    private PersonalityScale openness;

    @Schema(description = "Conscientiousness trait")
    @ManyToOne
    @JoinColumn(name = "conscientiousness_id")
    private PersonalityScale conscientiousness;

    @Schema(description = "Extraversion trait")
    @ManyToOne
    @JoinColumn(name = "extraversion_id")
    private PersonalityScale extraversion;

    @Schema(description = "Agreeableness trait")
    @ManyToOne
    @JoinColumn(name = "agreeableness_id")
    private PersonalityScale agreeableness;

    @Schema(description = "Neuroticism trait")
    @ManyToOne
    @JoinColumn(name = "neuroticism_id")
    private PersonalityScale neuroticism;

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

    public PersonalityScale getOpenness() {
        return openness;
    }

    public void setOpenness(PersonalityScale openness) {
        this.openness = openness;
    }

    public PersonalityScale getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(PersonalityScale conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    public PersonalityScale getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(PersonalityScale extraversion) {
        this.extraversion = extraversion;
    }

    public PersonalityScale getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(PersonalityScale agreeableness) {
        this.agreeableness = agreeableness;
    }

    public PersonalityScale getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(PersonalityScale neuroticism) {
        this.neuroticism = neuroticism;
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
        SocialPersonality other = (SocialPersonality) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "SocialPersonality [userId=" + userId + "]";
    }
}
