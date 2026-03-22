package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.EducationDegree;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
}
