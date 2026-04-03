package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.AgePreference;

public interface AgePreferenceRepository extends JpaRepository<AgePreference, Long> {
}
