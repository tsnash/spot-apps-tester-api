package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "personality_scales")
public class PersonalityScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personality_scale_id")
    private Long personalityScaleId;

    @NotNull
    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public PersonalityScale() {
    }

    public PersonalityScale(String name) {
        setName(name);
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
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PersonalityScale))
            return false;
        PersonalityScale that = (PersonalityScale) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PersonalityScale [personalityScaleId=" + personalityScaleId + ", name=" + name + "]";
    }
}
