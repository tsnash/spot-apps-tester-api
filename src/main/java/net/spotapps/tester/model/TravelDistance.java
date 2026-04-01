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
@Table(name = "travel_distances")
public class TravelDistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_distance_id")
    private Long travelDistanceId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public TravelDistance() {
    }

    public TravelDistance(String name) {
        this.name = name;
    }

    public Long getTravelDistanceId() {
        return travelDistanceId;
    }

    public void setTravelDistanceId(Long travelDistanceId) {
        this.travelDistanceId = travelDistanceId;
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
        if (!(o instanceof TravelDistance))
            return false;
        TravelDistance that = (TravelDistance) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TravelDistance [travelDistanceId=" + travelDistanceId + ", name=" + name + "]";
    }
}
