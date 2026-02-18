package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}