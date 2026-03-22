package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.ViceType;

public interface ViceTypeRepository extends JpaRepository<ViceType, Long> {
}
