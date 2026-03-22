package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vices")
public class Vice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vice_id")
    private Long viceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vice_type_id")
    private ViceType viceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frequency_id")
    private ViceFrequency frequency;

    @ManyToOne(fetch = FetchType.LAZY)
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
        if (this == o)
            return true;
        if (!(o instanceof Vice))
            return false;
        Vice other = (Vice) o;
        if (viceId != null && other.getViceId() != null) {
            return Objects.equals(viceId, other.getViceId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (viceId != null) {
            return Objects.hash(viceId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        String typeId = (viceType != null) ? String.valueOf(viceType.getViceTypeId()) : "null";
        String freqId = (frequency != null) ? String.valueOf(frequency.getViceFrequencyId()) : "null";
        return "Vice [viceId=" + viceId + ", typeId=" + typeId + ", frequencyId=" + freqId + "]";
    }
}
