package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "personality_scales")
public class PersonalityScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personality_scale_id")
    private Long personalityScaleId;

    @Column(nullable = false, unique = true)
    private String name;

    public PersonalityScale() {}

    public PersonalityScale(String name) {
        this.name = name;
    }

    public Long getPersonalityScaleId() {
        return personalityScaleId;
    }

    public void setPersonalityScaleId(Long personalityScaleId) {
        this.personalityScaleId = personalityScaleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalityScale other = (PersonalityScale) o;
        return Objects.equals(personalityScaleId, other.personalityScaleId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalityScaleId, name);
    }

    @Override
    public String toString() {
        return "PersonalityScale [personalityScaleId=" + personalityScaleId + ", name=" + name + "]";
    }
}
