package net.spotapps.tester.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    List<UserProfile> findAllByUserIdInOrderByUserIdAsc(Iterable<Long> userIds);
}