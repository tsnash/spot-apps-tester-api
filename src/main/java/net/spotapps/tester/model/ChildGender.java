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
@Table(name = "child_genders")
public class ChildGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_gender_id")
    private Long childGenderId;

    @NotNull
    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public ChildGender() {
    }

    public ChildGender(String name) {
        this.name = name;
    }

    public Long getChildGenderId() {
        return childGenderId;
    }

    public void setChildGenderId(Long childGenderId) {
        this.childGenderId = childGenderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChildGender)) {
            return false;
        }
        ChildGender that = (ChildGender) o;
        if (name != null && that.name != null) {
            return Objects.equals(name, that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "ChildGender [childGenderId=" + childGenderId + ", name=" + name + "]";
    }
}
