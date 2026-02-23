package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spotapps.tester.model.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
