package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "relationship_interests")
public class RelationshipInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_interest_id")
    private Long relationshipInterestId;

    @Column(nullable = false, unique = true)
    private String name;

    public RelationshipInterest() {}

    public RelationshipInterest(String name) {
        this.name = name;
    }

    public Long getRelationshipInterestId() {
        return relationshipInterestId;
    }

    public void setRelationshipInterestId(Long relationshipInterestId) {
        this.relationshipInterestId = relationshipInterestId;
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
        RelationshipInterest other = (RelationshipInterest) o;
        return Objects.equals(relationshipInterestId, other.relationshipInterestId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipInterestId, name);
    }

    @Override
    public String toString() {
        return "RelationshipInterest [relationshipInterestId=" + relationshipInterestId + ", name=" + name + "]";
    }
}
