package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.ChildrenPreference;

public interface ChildrenPreferenceRepository extends JpaRepository<ChildrenPreference, Long> {
}
