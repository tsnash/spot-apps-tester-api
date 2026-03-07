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
import java.util.Objects;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "language_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fluency_id")
    private FluencyLevel fluency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private LanguagePreference languagePreference;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FluencyLevel getFluency() {
        return fluency;
    }

    public void setFluency(FluencyLevel fluency) {
        this.fluency = fluency;
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(LanguagePreference languagePreference) {
        this.languagePreference = languagePreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;
        Language other = (Language) o;
        if (languageId != null && other.getLanguageId() != null) {
            return Objects.equals(languageId, other.getLanguageId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (languageId != null) {
            return Objects.hash(languageId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Language [languageId=" + languageId + ", name=" + name + "]";
    }
}
