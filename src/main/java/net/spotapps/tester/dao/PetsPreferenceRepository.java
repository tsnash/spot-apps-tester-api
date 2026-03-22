package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.PetsPreference;

public interface PetsPreferenceRepository extends JpaRepository<PetsPreference, Long> {
}
