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
@Table(name = "relationship_statuses")
public class RelationshipStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_status_id")
    private Long relationshipStatusId;

    @NotNull
    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    public RelationshipStatus() {
    }

    public RelationshipStatus(String name) {
        this.name = name;
    }

    public Long getRelationshipStatusId() {
        return relationshipStatusId;
    }

    public void setRelationshipStatusId(Long relationshipStatusId) {
        this.relationshipStatusId = relationshipStatusId;
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
        if (!(o instanceof RelationshipStatus))
            return false;
        RelationshipStatus that = (RelationshipStatus) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RelationshipStatus [relationshipStatusId=" + relationshipStatusId + ", name=" + name + "]";
    }
}
