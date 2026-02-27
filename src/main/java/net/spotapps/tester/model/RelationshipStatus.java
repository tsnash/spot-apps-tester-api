package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "relationship_statuses")
public class RelationshipStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_status_id")
    private Long relationshipStatusId;

    @Column(nullable = false, unique = true)
    private String name;

    public RelationshipStatus() {}

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
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationshipStatus)) return false;
        RelationshipStatus other = (RelationshipStatus) o;
        return Objects.equals(relationshipStatusId, other.relationshipStatusId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipStatusId, name);
    }

    @Override
    public String toString() {
        return "RelationshipStatus [relationshipStatusId=" + relationshipStatusId + ", name=" + name + "]";
    }
}
