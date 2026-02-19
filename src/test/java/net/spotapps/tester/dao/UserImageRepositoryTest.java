package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.User;
import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserImageRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserImageRepository repository;

    @Test
    public void testSaveAndFindUserImage() {
        User user = new User();
        entityManager.persist(user);

        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        entityManager.persist(userProfile);

        UserImage image = new UserImage("test-image.png", userProfile);
        UserImage saved = repository.save(image);

        assertThat(saved.getImageId()).isNotNull();
        assertThat(saved.getImage()).isEqualTo("test-image.png");
        assertThat(saved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());

        UserImage found = repository.findById(saved.getImageId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getImage()).isEqualTo("test-image.png");
    }
}