package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.spotapps.tester.model.VicePreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VicePreferenceRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private VicePreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile userProfile = createAndSaveUserWithProfile();
        assertThat(userProfile.getUserId()).isNotNull();

        VicePreference pref = new VicePreference();
        pref.setUserProfile(userProfile);

        VicePreference saved = repository.save(pref);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(userProfile.getUserId());
        entityManager.flush();
        entityManager.clear();

        VicePreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(userProfile.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
