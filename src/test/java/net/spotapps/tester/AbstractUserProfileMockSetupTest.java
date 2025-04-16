package net.spotapps.tester;

import static net.spotapps.tester.UserProfileConstants.INVALID_ID_MESSAGE;
import static net.spotapps.tester.UserProfileConstants.USER_PROFILE_NOT_FOUND_MESSAGE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.Collections;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import net.spotapps.tester.model.UserImage;
import net.spotapps.tester.model.UserInterest;
import net.spotapps.tester.model.UserProfile;
import net.spotapps.tester.model.exception.InvalidIdException;
import net.spotapps.tester.model.exception.UserProfileNotFoundException;
import net.spotapps.tester.service.UserProfileService;

public abstract class AbstractUserProfileMockSetupTest {
    
    protected UserProfile testUserProfile1;
    protected UserProfile testUserProfile2;

    @MockitoBean
    protected UserProfileService userProfileService;

    public void setUp() {
        testUserProfile1 = new UserProfile();
        testUserProfile1.setUserId(1L);
        testUserProfile1.setImages(Arrays.asList(
            new UserImage(1L,"four"),
            new UserImage(2L,"images"),
            new UserImage(3L,"only"),
            new UserImage(4L,"please")
            ));
        testUserProfile1.setInterests(Arrays.asList(
            new UserInterest(1L, "up"),
            new UserInterest(2L, "to"),
            new UserInterest(3L, "six"),
            new UserInterest(4L, "of"),
            new UserInterest(5L, "these"),
            new UserInterest(6L, "allowed")
        ));

        testUserProfile2 = new UserProfile();
        testUserProfile2.setUserId(2L);
        testUserProfile2.setImages(Arrays.asList(
            new UserImage(5L,"just"),
            new UserImage(6L,"these"),
            new UserImage(7L,"four"),
            new UserImage(8L,"images")
            ));
        testUserProfile2.setInterests(Arrays.asList(
            new UserInterest(7L, "you"),
            new UserInterest(8L, "can"),
            new UserInterest(9L, "vary"),
            new UserInterest(10L, "this"),
            new UserInterest(11L, "amount")
        ));

        userProfileService = mock(UserProfileService.class);

        when(userProfileService.getAllProfiles())
            .thenReturn(Arrays.asList(new UserProfile[]{testUserProfile1, testUserProfile2}));

        when(userProfileService.getUserProfile("1"))
            .thenReturn(testUserProfile1);

        when(userProfileService.getUserProfile("3"))
            .thenThrow(new UserProfileNotFoundException(USER_PROFILE_NOT_FOUND_MESSAGE, 3L));

        when(userProfileService.getUserProfile("invalidID"))
            .thenThrow(new InvalidIdException(INVALID_ID_MESSAGE, "invalidID"));

        when(userProfileService.getUserProfileList(Arrays.asList(new String[]{"1","2"})))
            .thenReturn(Arrays.asList(new UserProfile[]{testUserProfile1, testUserProfile2}));

        when(userProfileService.getUserProfileList(Arrays.asList(new String[]{"invalidID","2"})))
            .thenReturn(Collections.singletonList(testUserProfile2));

        when(userProfileService.getUserProfileList(Arrays.asList(new String[]{"invalidID","3"})))
            .thenReturn(Collections.emptyList());

    }

}
