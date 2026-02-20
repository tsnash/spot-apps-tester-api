package net.spotapps.tester.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.User;
import net.spotapps.tester.model.UserProfile;

public abstract class AbstractRepositoryTestBase {
    @Autowired
    protected TestEntityManager entityManager;

    protected UserProfile createAndSaveUser() {
        User user = new User();
        entityManager.persist(user);
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        entityManager.persist(userProfile);
        entityManager.flush();
        return userProfile;
    }
}