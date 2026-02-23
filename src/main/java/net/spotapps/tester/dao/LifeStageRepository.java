package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.LifeStage;

public interface LifeStageRepository extends JpaRepository<LifeStage, Long> {
}
