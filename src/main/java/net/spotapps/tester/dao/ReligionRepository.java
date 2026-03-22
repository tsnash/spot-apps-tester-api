package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.Religion;

public interface ReligionRepository extends JpaRepository<Religion, Long> {
}
