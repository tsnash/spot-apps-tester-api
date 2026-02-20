package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.spotapps.tester.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSaveAndFindUser() {
        User user = new User();
        User saved = repository.save(user);

        assertThat(saved.getUserId()).isNotNull();

        User found = repository.findById(saved.getUserId()).orElse(null);
        assertThat(found).isNotNull();
    }
}