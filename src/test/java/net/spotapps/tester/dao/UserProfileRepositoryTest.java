package net.spotapps.tester.dao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import net.spotapps.tester.TesterApplication;
import net.spotapps.tester.model.UserProfile;

@SpringBootTest(classes = TesterApplication.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup(UserProfileRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {UserProfileRepositoryTest.DATASET})
@DirtiesContext
public class UserProfileRepositoryTest {
    protected static final String DATASET = "classpath:datasets/user_profiles.xml";

    @Autowired
    private UserProfileRepository repository;

    @Test
    @Transactional(readOnly = true)
    public void testFindOneById() {
        UserProfile actual = repository.findById(3L).orElse(null);
        assertNotNull(actual, "This user profile should exist");
        assertEquals(3L, actual.getUserId(), "This user profile should have a user id of 3");

        assertEquals(1, actual.getImages().size(), "There should be one image");
        assertEquals("0.png", actual.getImages().get(0).getImage(), 
            "The image should be \"0.png\"");

        assertEquals(1, actual.getInterests().size(), "There should be one interest");
        assertEquals("programming", actual.getInterests().get(0).getInterest(), 
            "The interest should be \"programming\"");

        actual = repository.findById(6L).orElse(null);
        assertNull(actual, "This user profile should not exist");
    }

    @Test
    public void testFindOneByIdLazyLoadOutsideTransaction() {
        UserProfile actual = repository.findById(3L).orElse(null);
        assertNotNull(actual, "This user profile should exist");
        assertEquals(3L, actual.getUserId(), "This user profile should have a user id of 3");

        assertThrows(LazyInitializationException.class, () -> actual.getImages().size(),
            "Images should fail to load");
        assertThrows(LazyInitializationException.class, () -> actual.getInterests().size(),
            "Interests should fail to load");
    
    }

    @Test
    @Transactional(readOnly = true)
    public void testFindAllByUserIdInOrderByUserIdAsc() {
        Long[] expectedIds = new Long[]{4L,2L,5L};
        List<UserProfile> actual = repository.findAllByUserIdInOrderByUserIdAsc(Arrays.asList(expectedIds));
        assertEquals(expectedIds.length, actual.size(), "There should be a user profile for each user id");
        Arrays.sort(expectedIds);
        assertArrayEquals(expectedIds, actual.stream().map(UserProfile::getUserId).toArray(),
            "The user ids should be in ascending order");

        Long[] notExpectedIds = new Long[]{10L,6L};
        actual = repository.findAllByUserIdInOrderByUserIdAsc(Arrays.asList(notExpectedIds));
        assertTrue(actual.isEmpty(), "There shouldn't be any user profiles for these ids");
    }
}
