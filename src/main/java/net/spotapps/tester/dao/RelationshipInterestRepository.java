package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.RelationshipInterest;

public interface RelationshipInterestRepository extends JpaRepository<RelationshipInterest, Long> {
}
