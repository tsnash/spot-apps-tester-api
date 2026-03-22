package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
