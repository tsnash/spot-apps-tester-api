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
@Table(name = "household_statuses")
public class HouseholdStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "household_status_id")
    private Long householdStatusId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public HouseholdStatus() {
    }

    public HouseholdStatus(String name) {
        setName(name);
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
        this.name = Objects.requireNonNull(name);
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
