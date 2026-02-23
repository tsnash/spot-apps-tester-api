package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import net.spotapps.tester.model.AgePreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AgePreferenceRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private AgePreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile userProfile = createAndSaveUser();
        assertThat(userProfile.getUserId()).isNotNull();

        AgePreference pref = new AgePreference();
        pref.setUserProfile(userProfile);

        AgePreference saved = repository.save(pref);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(userProfile.getUserId());
        entityManager.flush();
        entityManager.clear();

        AgePreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(userProfile.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
