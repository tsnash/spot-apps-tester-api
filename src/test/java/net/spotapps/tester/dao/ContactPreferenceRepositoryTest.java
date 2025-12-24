package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.spotapps.tester.model.ContactPreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
public class ContactPreferenceRepositoryTest {

    @Autowired
    UserProfileRepository userRepository;

    @Autowired
    private ContactPreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile user = new UserProfile();
        userRepository.save(user);

        ContactPreference cp = new ContactPreference();
        cp.setUserProfile(user);
        cp.setEmailAddress("jane@example.com");

        ContactPreference saved = repository.save(cp);

        assertThat(saved.getUserId()).isEqualTo(user.getUserId());
    }
}
