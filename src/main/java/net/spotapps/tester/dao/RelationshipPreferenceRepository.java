package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.RelationshipPreference;

public interface RelationshipPreferenceRepository extends JpaRepository<RelationshipPreference, Long> {
}
