package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import net.spotapps.tester.model.LocationPreference;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LocationPreferenceRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private LocationPreferenceRepository repository;

    @Test
    void mapsIdIsDerivedFromUserProfile() {
        UserProfile userProfile = createAndSaveUser();
        assertThat(userProfile.getUserId()).isNotNull();

        LocationPreference pref = new LocationPreference();
        pref.setUserProfile(userProfile);

        LocationPreference saved = repository.save(pref);
        assertThat(saved.getUserId()).isNotNull().isEqualTo(userProfile.getUserId());
        entityManager.flush();
        entityManager.clear();

        LocationPreference retrieved = repository.findById(saved.getUserId()).orElseThrow();

        assertThat(retrieved.getUserId()).isEqualTo(userProfile.getUserId());
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
