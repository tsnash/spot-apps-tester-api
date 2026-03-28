package net.spotapps.tester.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "language_preferences")
public class LanguagePreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "List of languages spoken by the user")
    @OneToMany(mappedBy = "languagePreference", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("languageId ASC")
    private Set<Language> languagesSpoken = new LinkedHashSet<>();

    @Schema(description = "The importance of language to the user (1-5)")
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

    public Set<Language> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(Set<Language> languagesSpoken) {
        if (this.languagesSpoken == null) {
            this.languagesSpoken = new LinkedHashSet<>();
        }
        // Maintain bidirectional consistency
        this.languagesSpoken.forEach(lang -> lang.setLanguagePreference(null));
        this.languagesSpoken.clear();
        if (languagesSpoken != null) {
            for (Language language : languagesSpoken) {
                language.setLanguagePreference(this);
                this.languagesSpoken.add(language);
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
        if (!(obj instanceof LanguagePreference))
            return false;
        LanguagePreference other = (LanguagePreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "LanguagePreference [userId=" + userId + "]";
    }
}
