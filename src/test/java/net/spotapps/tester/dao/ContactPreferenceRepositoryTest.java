package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.ContactPreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
public class ContactPreferenceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserProfileRepository userRepository;

    @Autowired
    private ContactPreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile user = new UserProfile();
        userRepository.save(user);
        assertThat(user.getUserId()).isNotNull();

        ContactPreference cp = new ContactPreference();
        cp.setUserProfile(user);

        ContactPreference saved = repository.save(cp);
        entityManager.flush();
        entityManager.clear();
        
        ContactPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(user.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void verifyContactPreferencePersisted() {
        UserProfile user = new UserProfile();
        userRepository.save(user);

        ContactPreference cp = new ContactPreference();
        cp.setUserProfile(user);
        cp.setFirstName("John");
        cp.setLastName("Doe");
        cp.setPhoneNumber("555-555-5555");
        cp.setEmailAddress("john@example.com");
        cp.setEmailVerified(true);

        ContactPreference saved = repository.save(cp);
        entityManager.flush();
        entityManager.clear();
        
        ContactPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getFirstName()).isEqualTo("John");
        assertThat(retrieved.getLastName()).isEqualTo("Doe");
        assertThat(retrieved.getPhoneNumber()).isEqualTo("555-555-5555");
        assertThat(retrieved.getEmailAddress()).isEqualTo("john@example.com");
        assertThat(retrieved.getEmailVerified()).isTrue();
    }
}
