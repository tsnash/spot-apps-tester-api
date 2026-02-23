package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.GenderPreference;

public interface GenderPreferenceRepository extends JpaRepository<GenderPreference, Long> {
}
