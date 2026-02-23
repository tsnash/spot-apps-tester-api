package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import net.spotapps.tester.model.DietPreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DietPreferenceRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private DietPreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile userProfile = createAndSaveUser();
        assertThat(userProfile.getUserId()).isNotNull();

        DietPreference pref = new DietPreference();
        pref.setUserProfile(userProfile);

        DietPreference saved = repository.save(pref);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(userProfile.getUserId());
        entityManager.flush();
        entityManager.clear();

        DietPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(userProfile.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
