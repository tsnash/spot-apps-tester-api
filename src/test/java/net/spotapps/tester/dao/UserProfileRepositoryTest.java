package net.spotapps.tester.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

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
    private TestEntityManager entityManager;

    @Autowired
    private UserProfileRepository repository;

    @Test
    public void testFindOneById() {
        UserProfile actual = repository.findById(3L).orElseThrow();
        assertThat(actual.getUserId()).isEqualTo(3L);

        assertThat(actual.getImages()).hasSize(1);
        assertThat(actual.getImages().iterator().next().getImage()).isEqualTo("0.png");

        assertThat(actual.getInterests()).hasSize(1);
        assertThat(actual.getInterests().iterator().next().getInterest()).isEqualTo("programming");

        assertThat(repository.findById(6L)).isEmpty();
    }

    @Test
    public void testFindOneByIdWithAllPreferences() {
        UserProfile actual = repository.findWithAssociationsByUserId(2L).orElseThrow();
        assertThat(actual.getUserId()).isEqualTo(2L);

        assertThat(actual.getLocationPreference()).isNotNull();
        assertThat(actual.getLocationPreference().getUseLocal()).isTrue();
        assertThat(actual.getLocationPreference().getDistanceInMiles()).isEqualTo(20.0);

        assertThat(actual.getSocialPersonality()).isNotNull();
        assertThat(actual.getSocialPersonality().getOpenness().getName()).isEqualTo("Neutral");

        assertThat(actual.getGenderPreference()).isNotNull();
        assertThat(actual.getGenderPreference().getGender().getName()).isEqualTo("Male");

        assertThat(actual.getRelationshipPreference()).isNotNull();
        assertThat(actual.getRelationshipPreference().getRelationshipStatus().getName()).isEqualTo("Single");

        assertThat(actual.getChildrenPreference()).isNotNull();
        assertThat(actual.getChildrenPreference().getChildren()).hasSize(1);
        assertThat(actual.getChildrenPreference().getChildren().iterator().next().getLifeStage().getName())
                .isEqualTo("Infant");

        assertThat(actual.getAgePreference()).isNotNull();
        assertThat(actual.getAgePreference().getYear()).isEqualTo("1990");

        assertThat(actual.getReligionPreference()).isNotNull();
        assertThat(actual.getReligionPreference().getReligion().getReligionName()).isEqualTo("Christianity");

        assertThat(actual.getEducationPreference()).isNotNull();
        assertThat(actual.getEducationPreference().getHighestDegree().getName()).isEqualTo("Bachelor's");

        assertThat(actual.getLanguagePreference()).isNotNull();
        assertThat(actual.getLanguagePreference().getLanguagesSpoken()).hasSize(1);
        assertThat(actual.getLanguagePreference().getLanguagesSpoken().iterator().next().getName())
                .isEqualTo("English");

        assertThat(actual.getVicePreference()).isNotNull();
        assertThat(actual.getVicePreference().getVices()).hasSize(1);

        assertThat(actual.getPetsPreference()).isNotNull();
        assertThat(actual.getPetsPreference().getPets()).hasSize(1);

        assertThat(actual.getTravelPreference()).isNotNull();
        assertThat(actual.getTravelPreference().getFrequency().getName()).isEqualTo("Rarely");

        assertThat(actual.getDietPreference()).isNotNull();
        assertThat(actual.getDietPreference().getRestrictions()).hasSize(1);
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
        // The findAllByUserIdInOrderByUserIdAsc method already has @EntityGraph,
        // so we expect eager loading for this specific method.
        List<Long> expectedIds = List.of(4L, 2L, 5L);
        List<UserProfile> actual = repository.findAllByUserIdInOrderByUserIdAsc(expectedIds);

        assertThat(actual)
                .extracting(UserProfile::getUserId)
                .containsExactly(2L, 4L, 5L);

        List<Long> notExpectedIds = Arrays.asList(10L, 6L);
        actual = repository.findAllByUserIdInOrderByUserIdAsc(List.of(10L, 6L));
        assertThat(actual).isEmpty();
    }
}
