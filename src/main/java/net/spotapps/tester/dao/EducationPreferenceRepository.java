package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.EducationPreference;

public interface EducationPreferenceRepository extends JpaRepository<EducationPreference, Long> {
}
