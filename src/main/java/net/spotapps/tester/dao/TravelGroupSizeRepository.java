package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.TravelGroupSize;

public interface TravelGroupSizeRepository extends JpaRepository<TravelGroupSize, Long> {
}
