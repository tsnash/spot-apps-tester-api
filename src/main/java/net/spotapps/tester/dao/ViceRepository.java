package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.Vice;

public interface ViceRepository extends JpaRepository<Vice, Long> {
}
