package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.spotapps.tester.model.LanguagePreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LanguagePreferenceRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private LanguagePreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile userProfile = createAndSaveUserWithProfile();
        assertThat(userProfile.getUserId()).isNotNull();

        LanguagePreference pref = new LanguagePreference();
        pref.setUserProfile(userProfile);

        LanguagePreference saved = repository.save(pref);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(userProfile.getUserId());
        entityManager.flush();
        entityManager.clear();

        LanguagePreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(userProfile.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
