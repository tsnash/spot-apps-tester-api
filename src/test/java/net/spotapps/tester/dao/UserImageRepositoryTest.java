package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserImageRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private UserImageRepository repository;

    @Test
    public void verifyUserImagePersisted() {
        UserProfile userProfile = createAndSaveUser();

        UserImage image = new UserImage("test-image.png", userProfile);

        UserImage saved = repository.save(image);

        assertThat(saved.getImageId()).isNotNull();
        assertThat(saved.getImage()).isEqualTo("test-image.png");

        entityManager.flush();
        entityManager.clear();

        UserImage retrieved = repository.findById(saved.getImageId()).orElse(null);

        assertThat(retrieved).isNotNull();
        assertThat(retrieved.getImage()).isEqualTo("test-image.png");
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}
