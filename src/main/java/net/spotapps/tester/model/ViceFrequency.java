package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vice_frequencies")
public class ViceFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vice_frequency_id")
    private Long viceFrequencyId;

    @Column(nullable = false, unique = true)
    private String name;

    public ViceFrequency() {}

    public ViceFrequency(String name) {
        this.name = name;
    }

    public Long getViceFrequencyId() {
        return viceFrequencyId;
    }

    public void setViceFrequencyId(Long viceFrequencyId) {
        this.viceFrequencyId = viceFrequencyId;
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
        ViceFrequency other = (ViceFrequency) o;
        return Objects.equals(viceFrequencyId, other.viceFrequencyId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceFrequencyId, name);
    }

    @Override
    public String toString() {
        return "ViceFrequency [viceFrequencyId=" + viceFrequencyId + ", name=" + name + "]";
    }
}
