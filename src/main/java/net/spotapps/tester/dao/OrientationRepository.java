package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.Orientation;

public interface OrientationRepository extends JpaRepository<Orientation, Long> {
}
