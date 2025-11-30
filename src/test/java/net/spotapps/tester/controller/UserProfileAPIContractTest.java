package net.spotapps.tester.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.spotapps.tester.AbstractUserProfileMockSetupTest;
import net.spotapps.tester.model.exception.BadRequestException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;
import net.spotapps.tester.model.response.UserProfileCollectionResponse;
import net.spotapps.tester.model.response.UserProfileSuccessResponse;

@ExtendWith(SpringExtension.class)
public class UserProfileAPIContractTest extends AbstractUserProfileMockSetupTest {
    
    private UserProfileAPIContract userProfileAPIContract;
    
    @BeforeEach
    public void setUp() {
        super.setUp();
        userProfileAPIContract = new UserProfileAPIContractImpl(userProfileService);
    }

    @Test
    void testGetUserProfiles() {
        UserProfileCollectionResponse actual = 
              (UserProfileCollectionResponse) userProfileAPIContract.getUserProfiles(null).getBody();
        assertEquals(
            2, 
            actual.getUserProfiles().size(),
            "There should be two total user profiles");
        verify(userProfileService).getAllProfiles();
    }

    @Test
    void testGetUserProfileById() {
        UserProfileSuccessResponse actual = 
            (UserProfileSuccessResponse) userProfileAPIContract.getUserProfile("1", null).getBody();

        assertEquals(
            testUserProfileDto1, 
            actual.getUserProfile(), 
            "The fetched user profile should match the original");
        verify(userProfileService).getUserProfile("1");

        assertThrows(
            UserProfileNotFoundException.class,
            () -> userProfileAPIContract.getUserProfile("3", null),
            "Should throw a UserProfileNotFoundException");
        verify(userProfileService).getUserProfile("3");

        assertThrows(
            BadRequestException.class,
            () -> userProfileAPIContract.getUserProfile("invalidID", null),
            "Should throw a BadRequestException");
        verify(userProfileService).getUserProfile("invalidID");
    }

    @Test
    void testGetUserProfilesContainingIds() {

        UserProfileCollectionResponse actual = (UserProfileCollectionResponse) userProfileAPIContract
            .getUserProfiles(Arrays.asList(new String[]{"1", "2"}), null).getBody();
        assertEquals(
            2, 
            actual.getUserProfiles().size(),
            "There should be 2 user profiles");
        verify(userProfileService).getUserProfileList(Arrays.asList(new String[]{"1", "2"}));

        actual = (UserProfileCollectionResponse) userProfileAPIContract
            .getUserProfiles(Arrays.asList(new String[]{"invalidID", "2"}), null).getBody();
        assertEquals(
            1, 
            actual.getUserProfiles().size(),
            "There should be 1 user profile");
        verify(userProfileService).getUserProfileList(Arrays.asList(new String[]{"invalidID", "2"}));

        actual = (UserProfileCollectionResponse) userProfileAPIContract
            .getUserProfiles(Arrays.asList(new String[]{"invalidID", "3"}), null).getBody();
        assertTrue( 
            actual.getUserProfiles().isEmpty(),
            "There should be no user profiles");
        verify(userProfileService).getUserProfileList(Arrays.asList(new String[]{"invalidID", "3"}));
        
    }

}
