package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.ContactPreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContactPreferenceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserProfileRepository userRepository;

    @Autowired
    private ContactPreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile user = createAndSaveUser();
        assertThat(user.getUserId()).isNotNull();

        ContactPreference cp = new ContactPreference();
        cp.setUserProfile(user);

        ContactPreference saved = repository.save(cp);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(user.getUserId());
        entityManager.flush();
        entityManager.clear();

        ContactPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(user.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void verifyContactPreferencePersisted() {
        UserProfile user = createAndSaveUser();

        ContactPreference cp = new ContactPreference();
        cp.setUserProfile(user);
        cp.setFirstName("John");
        cp.setLastName("Doe");
        cp.setPhoneNumber("+5555555555");
        cp.setEmailAddress("john@example.com");
        cp.setEmailVerified(true);

        ContactPreference saved = repository.save(cp);
        entityManager.flush();
        entityManager.clear();

        ContactPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getFirstName()).isEqualTo("John");
        assertThat(retrieved.getLastName()).isEqualTo("Doe");
        assertThat(retrieved.getPhoneNumber()).isEqualTo("+5555555555");
        assertThat(retrieved.getEmailAddress()).isEqualTo("john@example.com");
        assertThat(retrieved.isEmailVerified()).isTrue();
        assertThat(retrieved.getUserProfile()).isNotNull();
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(user.getUserId());
    }

    private UserProfile createAndSaveUser() {
        return userRepository.save(new UserProfile());
    }
}
