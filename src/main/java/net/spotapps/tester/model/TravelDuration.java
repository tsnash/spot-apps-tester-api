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
@Table(name = "travel_durations")
public class TravelDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_duration_id")
    private Long travelDurationId;

    @NotNull
    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public TravelDuration() {
    }

    public TravelDuration(String name) {
        this.name = name;
    }

    public Long getTravelDurationId() {
        return travelDurationId;
    }

    public void setTravelDurationId(Long travelDurationId) {
        this.travelDurationId = travelDurationId;
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
        if (!(o instanceof TravelDuration))
            return false;
        TravelDuration that = (TravelDuration) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TravelDuration [travelDurationId=" + travelDurationId + ", name=" + name + "]";
    }
}
