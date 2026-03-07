package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "travel_group_sizes")
public class TravelGroupSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_group_size_id")
    private Long travelGroupSizeId;

    @Column(nullable = false, unique = true)
    private String name;

    public TravelGroupSize() {}

    public TravelGroupSize(String name) {
        this.name = name;
    }

    public Long getTravelGroupSizeId() {
        return travelGroupSizeId;
    }

    public void setTravelGroupSizeId(Long travelGroupSizeId) {
        this.travelGroupSizeId = travelGroupSizeId;
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
        if (!(o instanceof TravelGroupSize)) return false;
        TravelGroupSize that = (TravelGroupSize) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "TravelGroupSize [travelGroupSizeId=" + travelGroupSizeId + ", name=" + name + "]";
    }
}
