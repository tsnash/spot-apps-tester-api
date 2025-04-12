package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserInterest;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidIdException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserProfileServiceTest {

    protected static final String[] VALID_EXISTING_ID_INPUTS = {"1", "2"};
    protected static final String VALID_NON_EXISTENT_ID_INPUT = "3";
    protected static final String[] INVALID_ID_INPUTS = {"not", "valid"};

    protected static final Long[] VALID_EXISTING_IDS = 
        { idParser(VALID_EXISTING_ID_INPUTS[0]), idParser(VALID_EXISTING_ID_INPUTS[1]) };
    protected static final Long VALID_NON_EXISTENT_ID = idParser(VALID_NON_EXISTENT_ID_INPUT);
    
    private UserProfileServiceImpl userProfileService;

    private UserProfileRepository repository;

    protected UserProfile testUserProfile1;
    protected UserProfile testUserProfile2;

    

    @BeforeEach
    void setUp() {
        testUserProfile1 = new UserProfile();
        testUserProfile1.setUserId(VALID_EXISTING_IDS[0]);
        testUserProfile1.setImages(Arrays.asList(
            new UserImage(1L, "should"),
            new UserImage(2L, "be"),
            new UserImage(3L, "four"),
            new UserImage(4L, "here")
        ));
        testUserProfile1.setInterests(Arrays.asList(
            new UserInterest(1L, "just"),
            new UserInterest(2L, "some"),
            new UserInterest(3L, "interests")
        ));

        testUserProfile2 = new UserProfile();
        testUserProfile2.setUserId(VALID_EXISTING_IDS[1]);
        testUserProfile2.setImages(Arrays.asList(
            new UserImage(5L, "some"),
            new UserImage(6L, "others"),
            new UserImage(7L, "as"),
            new UserImage(8L, "well")
        ));
        testUserProfile1.setInterests(Arrays.asList(
            new UserInterest(4L, "here"),
            new UserInterest(5L, "are"),
            new UserInterest(6L, "more"),
            new UserInterest(7L, "of"),
            new UserInterest(8L, "them")
        ));

        repository = mock(UserProfileRepository.class);

        when(repository.findById(eq(VALID_EXISTING_IDS[0])))
            .thenReturn(Optional.of(testUserProfile1));

        when(repository.findById(VALID_EXISTING_IDS[1]))
            .thenReturn(Optional.of(testUserProfile2));

        when(repository.findById(VALID_NON_EXISTENT_ID))
            .thenReturn(Optional.ofNullable(null));

        when(repository.findAllByUserIdInOrderByUserIdAsc(eq(Arrays.asList(
                new Long[] { VALID_EXISTING_IDS[0], VALID_EXISTING_IDS[1] }).reversed())))
            .thenReturn(Arrays.asList(
                new UserProfile[]{testUserProfile1, testUserProfile2}));

        when(repository.findAllByUserIdInOrderByUserIdAsc(Arrays.asList(
            new Long[] { VALID_EXISTING_IDS[1], VALID_NON_EXISTENT_ID })))
            .thenReturn(Arrays.asList(
                new UserProfile[]{ testUserProfile2 }));

        when(repository.findAllByUserIdInOrderByUserIdAsc(Arrays.asList(
            new Long[] { VALID_EXISTING_IDS[0] })))
            .thenReturn(Arrays.asList(
                new UserProfile[]{ testUserProfile1 }));

        when(repository.findAll())
            .thenReturn(Arrays.asList(
                new UserProfile[]{ testUserProfile1, testUserProfile2 }));

        userProfileService = new UserProfileServiceImpl(repository);
    }

    private static Long idParser(String string) {
        return NumberUtils.createLong(string);
    }

    @Test
    void testGetUserProfile() {
        // valid id profile exists
        UserProfile actual = userProfileService.getUserProfile(VALID_EXISTING_ID_INPUTS[0]);
        verify(repository).findById(VALID_EXISTING_IDS[0]);
        assertNotNull(actual, "This user profile should exist.");
        assertEquals(testUserProfile1, actual, "This user profile should match the test user profile 1");

        // valid id profile doesn't exist
        actual = userProfileService.getUserProfile(VALID_NON_EXISTENT_ID_INPUT);
        verify(repository).findById(VALID_NON_EXISTENT_ID);
        assertNull(actual, "This user profile shouldn't exist");
        

        // invalid id don't check for profile
        assertThrows(
            InvalidIdException.class, 
            () -> userProfileService.getUserProfile(INVALID_ID_INPUTS[0]), 
            "Should throw an InvalidIdException");
        verifyNoMoreInteractions(repository);

    }

    @Test
    void testGetUserProfileList() {

        // 2/2 valid ids 2 profiles in asc order
        List<UserProfile> actual = userProfileService.getUserProfileList(Arrays.asList(
            VALID_EXISTING_ID_INPUTS).reversed());
        verify(repository).findAllByUserIdInOrderByUserIdAsc(Arrays.asList(
            VALID_EXISTING_IDS).reversed());
        assertEquals(
            VALID_EXISTING_IDS.length, 
            actual.size(),
            "There should be as many user profiles as valid existing ids");
        assertEquals(
            testUserProfile1,
            actual.get(0),
            "The test user profile 1 should match the first user profile in the list");
        assertEquals(
            testUserProfile2,
            actual.get(1),
            "The test user profile 2 should match the second user profile in the list");

        // 2/2 valid ids 1 profile
        actual = userProfileService.getUserProfileList(Arrays.asList(
            VALID_EXISTING_ID_INPUTS[1], VALID_NON_EXISTENT_ID_INPUT));
        verify(repository).findAllByUserIdInOrderByUserIdAsc(Arrays.asList(
            VALID_EXISTING_IDS[1], VALID_NON_EXISTENT_ID));
        assertEquals(
            1,
            actual.size(),
            "There should be only 1 user profile in the list");
        assertEquals(
            testUserProfile2,
            actual.get(0),
            "The test user profile 2 should match the only user profile in the list");

        // 1/1 valid ids 0 profiles
        actual = userProfileService.getUserProfileList(Arrays.asList(VALID_NON_EXISTENT_ID_INPUT));
        verify(repository).findAllByUserIdInOrderByUserIdAsc(Arrays.asList(VALID_NON_EXISTENT_ID));
        assertTrue(actual.isEmpty(), "There shouldn't be any user profiles matching this id");

        // 1/2 valid ids 1 profile
        actual = userProfileService.getUserProfileList(Arrays.asList(
            VALID_EXISTING_ID_INPUTS[0], INVALID_ID_INPUTS[0]));
        verify(repository).findAllByUserIdInOrderByUserIdAsc(Arrays.asList(VALID_EXISTING_IDS[0]));
        assertEquals(
            1,
            actual.size(),
            "There should be only 1 user profile in the list");
        assertEquals(
            testUserProfile1,
            actual.get(0),
            "The test user profile 1 should match the only user profile in the list");
        
        // 0/2 valid ids no profile lookup
        actual = userProfileService.getUserProfileList(Arrays.asList(INVALID_ID_INPUTS));
        verifyNoMoreInteractions(repository);
        assertEquals(
            0,
            actual.size(),
            "There should be no user profiles when only invalid user ids are looked up");

    }

    @Test
    void testGetAllProfiles() {
        List<UserProfile> actual = userProfileService.getAllProfiles();
        verify(repository).findAll();
        assertEquals(
            VALID_EXISTING_IDS.length,
            actual.size(),
            "All valid user profiles should be returned from this method");
        assertEquals(
            testUserProfile1,
            actual.get(0),
            "The test user profile 1 should match the first user profile in the list");
        assertEquals(
            testUserProfile2,
            actual.get(1),
            "The test user profile 2 should match the second user profile in the list");
        verifyNoMoreInteractions(repository);

    }
}
