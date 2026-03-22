package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.VicePreference;

public interface VicePreferenceRepository extends JpaRepository<VicePreference, Long> {
}
