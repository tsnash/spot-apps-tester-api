package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.TravelPreference;

public interface TravelPreferenceRepository extends JpaRepository<TravelPreference, Long> {
}
