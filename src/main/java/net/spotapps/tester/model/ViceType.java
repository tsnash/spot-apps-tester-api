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
@Table(name = "vice_types")
public class ViceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vice_type_id")
    private Long viceTypeId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public ViceType() {
    }

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
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ViceType))
            return false;
        ViceType that = (ViceType) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ViceType [viceTypeId=" + viceTypeId + ", name=" + name + "]";
    }
}
