package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import net.spotapps.tester.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void verifyUserPersisted() {
        User user = new User();
        User saved = repository.save(user);

        assertThat(saved.getUserId()).isNotNull();

        entityManager.flush();
        entityManager.clear();

        User retrieved = repository.findById(saved.getUserId()).orElse(null);

        assertThat(retrieved).isNotNull();
        assertThat(retrieved.getUserId()).isEqualTo(saved.getUserId());
    }
}