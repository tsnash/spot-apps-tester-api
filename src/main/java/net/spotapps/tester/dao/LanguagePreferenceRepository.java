package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.LanguagePreference;

public interface LanguagePreferenceRepository extends JpaRepository<LanguagePreference, Long> {
}
