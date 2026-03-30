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
@Table(name = "orientations")
public class Orientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orientation_id")
    private Long orientationId;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    public Orientation() {
    }

    public Orientation(String name) {
        setName(name);
    }

    public Long getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(Long orientationId) {
        this.orientationId = orientationId;
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
        if (!(o instanceof Orientation))
            return false;
        Orientation other = (Orientation) o;
        if (orientationId != null && other.getOrientationId() != null) {
            return Objects.equals(orientationId, other.getOrientationId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (orientationId != null) {
            return Objects.hash(orientationId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Orientation [orientationId=" + orientationId + ", name=" + name + "]";
    }
}
