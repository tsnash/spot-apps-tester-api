package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.TravelDuration;

public interface TravelDurationRepository extends JpaRepository<TravelDuration, Long> {
}
