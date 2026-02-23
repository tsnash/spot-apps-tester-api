package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "orientations")
public class Orientation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orientation_id")
    private Long orientationId;

    @Column(nullable = false, unique = true)
    private String name;

    public Orientation() {}

    public Orientation(String name) {
        this.name = name;
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
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orientation other = (Orientation) o;
        return Objects.equals(orientationId, other.orientationId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientationId, name);
    }

    @Override
    public String toString() {
        return "Orientation [orientationId=" + orientationId + ", name=" + name + "]";
    }
}
