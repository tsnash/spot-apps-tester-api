package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "travel_frequencies")
public class TravelFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_frequency_id")
    private Long travelFrequencyId;

    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public TravelFrequency() {
    }

    public TravelFrequency(String name) {
        this.name = name;
    }

    public Long getTravelFrequencyId() {
        return travelFrequencyId;
    }

    public void setTravelFrequencyId(Long travelFrequencyId) {
        this.travelFrequencyId = travelFrequencyId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TravelFrequency))
            return false;
        TravelFrequency that = (TravelFrequency) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TravelFrequency [travelFrequencyId=" + travelFrequencyId + ", name=" + name + "]";
    }
}
