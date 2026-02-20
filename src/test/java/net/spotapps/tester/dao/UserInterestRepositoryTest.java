package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.UserInterest;
import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserInterestRepositoryTest extends AbstractRepositoryTestBase {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserInterestRepository repository;

    @Test
    public void verifyUserInterestPersisted() {
        UserProfile userProfile = createAndSaveUser();

        UserInterest interest = new UserInterest("Coding", userProfile);

        UserInterest saved = repository.save(interest);

        assertThat(saved.getInterestId()).isNotNull();
        assertThat(saved.getInterest()).isEqualTo("Coding");

        entityManager.flush();
        entityManager.clear();

        UserInterest retrieved = repository.findById(saved.getInterestId()).orElse(null);

        assertThat(retrieved).isNotNull();
        assertThat(retrieved.getInterest()).isEqualTo("Coding");
        assertThat(retrieved.getUserProfile().getUserId()).isEqualTo(userProfile.getUserId());
    }
}