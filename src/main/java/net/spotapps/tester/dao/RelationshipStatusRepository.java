package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.RelationshipStatus;

public interface RelationshipStatusRepository extends JpaRepository<RelationshipStatus, Long> {
}
