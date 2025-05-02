package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.UserInterest;

public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
    
}