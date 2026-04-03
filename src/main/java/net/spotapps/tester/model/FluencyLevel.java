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
@Table(name = "fluency_levels")
public class FluencyLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fluency_level_id")
    private Long fluencyLevelId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public FluencyLevel() {
    }

    public FluencyLevel(String name) {
        this.name = name;
    }

    public Long getFluencyLevelId() {
        return fluencyLevelId;
    }

    public void setFluencyLevelId(Long fluencyLevelId) {
        this.fluencyLevelId = fluencyLevelId;
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
        if (!(o instanceof FluencyLevel))
            return false;
        FluencyLevel that = (FluencyLevel) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FluencyLevel [fluencyLevelId=" + fluencyLevelId + ", name=" + name + "]";
    }
}
