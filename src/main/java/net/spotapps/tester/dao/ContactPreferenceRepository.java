package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.ContactPreference;

public interface ContactPreferenceRepository extends JpaRepository<ContactPreference, Long> {
    
}
