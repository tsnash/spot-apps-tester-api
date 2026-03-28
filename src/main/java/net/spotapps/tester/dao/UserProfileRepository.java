package net.spotapps.tester.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import net.spotapps.tester.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @NonNull
    @Query("SELECT u FROM UserProfile u WHERE u.userId = :id")
    @EntityGraph(value = "UserProfile.withAssociations")
    Optional<UserProfile> findWithAssociationsByUserId(@NonNull Long id);

    @NonNull
    @Query("SELECT u FROM UserProfile u")
    @EntityGraph(value = "UserProfile.withAssociations")
    List<UserProfile> findAllWithAssociations();

    @NonNull
    @EntityGraph(value = "UserProfile.withAssociations")
    List<UserProfile> findAllByUserIdInOrderByUserIdAsc(@NonNull Iterable<Long> userIds);
}