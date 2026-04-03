package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.SocialPersonality;

public interface SocialPersonalityRepository extends JpaRepository<SocialPersonality, Long> {
}
