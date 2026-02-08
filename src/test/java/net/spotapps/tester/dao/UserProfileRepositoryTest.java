package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import net.spotapps.tester.model.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(UserProfileRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { UserProfileRepositoryTest.DATASET })
public class UserProfileRepositoryTest {
    protected static final String DATASET = "classpath:datasets/user_profiles.xml";

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindOneById() {
        UserProfile actual = repository.findById(3L).orElseThrow();
        assertThat(actual.getUserId()).isEqualTo(3L);

        assertThat(actual.getImages()).hasSize(1);
        assertThat(actual.getImages().get(0).getImage()).isEqualTo("0.png");

        assertThat(actual.getInterests()).hasSize(1);
        assertThat(actual.getInterests().get(0).getInterest()).isEqualTo("programming");

        assertThat(repository.findById(6L)).isEmpty();
    }

    @Test
    public void testFindOneByIdLazyLoadOutsideTransaction() {
        UserProfile actual = repository.findById(3L).orElseThrow();

        // Detach the entity to simulate the session closing
        entityManager.detach(actual);

        assertThatThrownBy(() -> actual.getImages().size())
                .isInstanceOf(LazyInitializationException.class);
        assertThatThrownBy(() -> actual.getInterests().size())
                .isInstanceOf(LazyInitializationException.class);
    }

    @Test
    public void testFindAllByUserIdInOrderByUserIdAsc() {
        List<Long> expectedIds = Arrays.asList(4L, 2L, 5L);
        List<UserProfile> actual = repository.findAllByUserIdInOrderByUserIdAsc(expectedIds);

        assertThat(actual)
                .extracting(UserProfile::getUserId)
                .containsExactly(2L, 4L, 5L);

        List<Long> notExpectedIds = Arrays.asList(10L, 6L);
        actual = repository.findAllByUserIdInOrderByUserIdAsc(notExpectedIds);
        assertThat(actual).isEmpty();
    }
}
