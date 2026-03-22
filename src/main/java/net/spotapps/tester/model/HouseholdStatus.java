package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "household_statuses")
public class HouseholdStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "household_status_id")
    private Long householdStatusId;

    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public HouseholdStatus() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HouseholdStatus))
            return false;
        HouseholdStatus that = (HouseholdStatus) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "HouseholdStatus [householdStatusId=" + householdStatusId + ", name=" + name + "]";
    }
}
