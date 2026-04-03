package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.ChildGender;

public interface ChildGenderRepository extends JpaRepository<ChildGender, Long> {
}
