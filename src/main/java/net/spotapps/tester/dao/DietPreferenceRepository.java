package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.DietPreference;

public interface DietPreferenceRepository extends JpaRepository<DietPreference, Long> {
}
