package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.FluencyLevel;

public interface FluencyLevelRepository extends JpaRepository<FluencyLevel, Long> {
}
