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
@Table(name = "relationship_practices")
public class RelationshipPractice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_practice_id")
    private Long relationshipPracticeId;

    @NotNull
    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public RelationshipPractice() {
    }

    public RelationshipPractice(String name) {
        this.name = name;
    }

    public Long getRelationshipPracticeId() {
        return relationshipPracticeId;
    }

    public void setRelationshipPracticeId(Long relationshipPracticeId) {
        this.relationshipPracticeId = relationshipPracticeId;
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
        if (!(o instanceof RelationshipPractice))
            return false;
        RelationshipPractice other = (RelationshipPractice) o;
        if (name != null && other.getName() != null) {
            return Objects.equals(name, other.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return Objects.hash(name);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "RelationshipPractice [relationshipPracticeId=" + relationshipPracticeId + ", name=" + name + "]";
    }
}
