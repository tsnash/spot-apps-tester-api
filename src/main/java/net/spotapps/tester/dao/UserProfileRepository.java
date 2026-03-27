package net.spotapps.tester.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import net.spotapps.tester.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Override
    @NonNull
    @EntityGraph(value = "UserProfile.withAssociations")
    Optional<UserProfile> findById(@NonNull Long id);

    @Override
    @NonNull
    @EntityGraph(value = "UserProfile.withAssociations")
    List<UserProfile> findAll();

    @NonNull
    @EntityGraph(value = "UserProfile.withAssociations")
    List<UserProfile> findAllByUserIdInOrderByUserIdAsc(@NonNull Iterable<Long> userIds);
}