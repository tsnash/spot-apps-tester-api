package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vices")
public class Vice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vice_id")
    private Long viceId;

    @ManyToOne
    @JoinColumn(name = "vice_type_id")
    private ViceType viceType;

    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private ViceFrequency frequency;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private VicePreference vicePreference;

    public Long getViceId() {
        return viceId;
    }

    public void setViceId(Long viceId) {
        this.viceId = viceId;
    }

    public ViceType getViceType() {
        return viceType;
    }

    public void setViceType(ViceType viceType) {
        this.viceType = viceType;
    }

    public ViceFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(ViceFrequency frequency) {
        this.frequency = frequency;
    }

    public VicePreference getVicePreference() {
        return vicePreference;
    }

    public void setVicePreference(VicePreference vicePreference) {
        this.vicePreference = vicePreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vice vice = (Vice) o;
        return Objects.equals(viceId, vice.viceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceId);
    }

    @Override
    public String toString() {
        return "Vice [viceId=" + viceId + "]";
    }
}
