package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.TravelDistance;

public interface TravelDistanceRepository extends JpaRepository<TravelDistance, Long> {
}
