package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vice_types")
public class ViceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vice_type_id")
    private Long viceTypeId;

    @Column(nullable = false, unique = true)
    private String name;

    public ViceType() {}

    public ViceType(String name) {
        this.name = name;
    }

    public Long getViceTypeId() {
        return viceTypeId;
    }

    public void setViceTypeId(Long viceTypeId) {
        this.viceTypeId = viceTypeId;
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
        if (!(o instanceof ViceType)) return false;
        ViceType other = (ViceType) o;
        return Objects.equals(viceTypeId, other.viceTypeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceTypeId, name);
    }

    @Override
    public String toString() {
        return "ViceType [viceTypeId=" + viceTypeId + ", name=" + name + "]";
    }
}
