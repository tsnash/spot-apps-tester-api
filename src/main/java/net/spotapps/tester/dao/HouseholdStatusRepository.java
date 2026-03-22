package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.HouseholdStatus;

public interface HouseholdStatusRepository extends JpaRepository<HouseholdStatus, Long> {
}
