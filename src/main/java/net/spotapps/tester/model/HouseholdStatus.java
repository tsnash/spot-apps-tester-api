package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "household_statuses")
public class HouseholdStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "household_status_id")
    private Long householdStatusId;

    @Column(nullable = false, unique = true)
    private String name;

    public HouseholdStatus() {}

    public HouseholdStatus(String name) {
        this.name = name;
    }

    public Long getHouseholdStatusId() {
        return householdStatusId;
    }

    public void setHouseholdStatusId(Long householdStatusId) {
        this.householdStatusId = householdStatusId;
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
        HouseholdStatus other = (HouseholdStatus) o;
        return Objects.equals(householdStatusId, other.householdStatusId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(householdStatusId, name);
    }

    @Override
    public String toString() {
        return "HouseholdStatus [householdStatusId=" + householdStatusId + ", name=" + name + "]";
    }
}
