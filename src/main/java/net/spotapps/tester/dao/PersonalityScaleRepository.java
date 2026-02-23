package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.PersonalityScale;

public interface PersonalityScaleRepository extends JpaRepository<PersonalityScale, Long> {
}
