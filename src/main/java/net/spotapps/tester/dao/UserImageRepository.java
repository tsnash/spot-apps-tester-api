package net.spotapps.tester.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.spotapps.tester.model.UserImage;

public interface UserImageRepository extends JpaRepository<UserImage, Long> {
    
}
