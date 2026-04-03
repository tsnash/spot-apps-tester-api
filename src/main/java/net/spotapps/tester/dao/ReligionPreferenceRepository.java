package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.ReligionPreference;

public interface ReligionPreferenceRepository extends JpaRepository<ReligionPreference, Long> {
}
