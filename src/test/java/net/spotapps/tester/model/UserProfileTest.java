package net.spotapps.tester.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class UserProfileTest {

    @ParameterizedTest
    @MethodSource("provideDifferentUserProfiles")
    public void testUserProfileInequality(UserProfile testUserProfile1, UserProfile testUserProfile2) {
        assertNotEquals(testUserProfile1, testUserProfile2, "Different user profiles should not be equal");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserProfiles")
    public void testUserProfileEquality(UserProfile testUserProfile1, UserProfile testUserProfile2) {
        assertEquals(testUserProfile1, testUserProfile2, "Identical user profiles should be equal");
    }

    @ParameterizedTest
    @MethodSource("provideDifferentUserProfiles")
    public void testUserProfileHashcodeInequality(UserProfile testUserProfile1, UserProfile testUserProfile2) {
        assertNotEquals(testUserProfile1.hashCode(), testUserProfile2.hashCode(),
                "Different user profiles should not have equal hash codes");
    }

    @ParameterizedTest
    @MethodSource("provideIdenticalUserProfiles")
    public void testUserProfileHashcodeEquality(UserProfile testUserProfile1, UserProfile testUserProfile2) {
        assertEquals(testUserProfile1.hashCode(), testUserProfile2.hashCode(),
                "Identical user profiles should have equal hash codes");
    }

    private static Stream<Arguments> provideDifferentUserProfiles() {
        UserProfile userProfile1 = new UserProfile();
        userProfile1.setUserId(1L);

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setUserId(2L);

        UserProfile userProfileNull = new UserProfile();
        userProfileNull.setUserId(null);

        UserProfile userProfile3AllFields = new UserProfile();
        userProfile3AllFields.setUserId(3L);
        userProfile3AllFields.setImages(Arrays.asList(new UserImage()));
        userProfile3AllFields.setContactPreference(new ContactPreference());
        userProfile3AllFields.setLocationPreference(new LocationPreference());
        userProfile3AllFields.setSocialPreference(new SocialPreference());
        userProfile3AllFields.setGenderPreference(new GenderPreference());
        userProfile3AllFields.setRelationshipPreference(new RelationshipPreference());
        userProfile3AllFields.setChildrenPreference(new ChildrenPreference());
        userProfile3AllFields.setAgePreference(new AgePreference());
        userProfile3AllFields.setReligionPreference(new ReligionPreference());
        userProfile3AllFields.setEducationPreference(new EducationPreference());
        userProfile3AllFields.setLanguagePreference(new LanguagePreference());
        userProfile3AllFields.setVicePreference(new VicePreference());
        userProfile3AllFields.setPetsPreference(new PetsPreference());
        userProfile3AllFields.setTravelPreference(new TravelPreference());
        userProfile3AllFields.setDietPreference(new DietPreference());
        userProfile3AllFields.setInterests(Arrays.asList(new UserInterest()));

        UserProfile userProfile4AllFields = new UserProfile();
        userProfile4AllFields.setUserId(4L);
        userProfile4AllFields.setImages(Arrays.asList(new UserImage()));
        userProfile4AllFields.setContactPreference(new ContactPreference());
        userProfile4AllFields.setLocationPreference(new LocationPreference());
        userProfile4AllFields.setSocialPreference(new SocialPreference());
        userProfile4AllFields.setGenderPreference(new GenderPreference());
        userProfile4AllFields.setRelationshipPreference(new RelationshipPreference());
        userProfile4AllFields.setChildrenPreference(new ChildrenPreference());
        userProfile4AllFields.setAgePreference(new AgePreference());
        userProfile4AllFields.setReligionPreference(new ReligionPreference());
        userProfile4AllFields.setEducationPreference(new EducationPreference());
        userProfile4AllFields.setLanguagePreference(new LanguagePreference());
        userProfile4AllFields.setVicePreference(new VicePreference());
        userProfile4AllFields.setPetsPreference(new PetsPreference());
        userProfile4AllFields.setTravelPreference(new TravelPreference());
        userProfile4AllFields.setDietPreference(new DietPreference());
        userProfile4AllFields.setInterests(Arrays.asList(new UserInterest()));

        return Stream.of(
                Arguments.of(userProfile1, userProfile2),
                Arguments.of(userProfile1, userProfileNull),
                Arguments.of(userProfile3AllFields, userProfile4AllFields));
    }

    private static Stream<Arguments> provideIdenticalUserProfiles() {
        UserProfile userProfile1 = new UserProfile();
        userProfile1.setUserId(1L);

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setUserId(1L);

        UserProfile userProfileNull = new UserProfile();
        userProfileNull.setUserId(null);

        UserProfile userProfile1AllFields = new UserProfile();
        userProfile1AllFields.setUserId(1L);
        userProfile1AllFields.setImages(Arrays.asList(new UserImage()));
        userProfile1AllFields.setContactPreference(new ContactPreference());
        userProfile1AllFields.setLocationPreference(new LocationPreference());
        userProfile1AllFields.setSocialPreference(new SocialPreference());
        userProfile1AllFields.setGenderPreference(new GenderPreference());
        userProfile1AllFields.setRelationshipPreference(new RelationshipPreference());
        userProfile1AllFields.setChildrenPreference(new ChildrenPreference());
        userProfile1AllFields.setAgePreference(new AgePreference());
        userProfile1AllFields.setReligionPreference(new ReligionPreference());
        userProfile1AllFields.setEducationPreference(new EducationPreference());
        userProfile1AllFields.setLanguagePreference(new LanguagePreference());
        userProfile1AllFields.setVicePreference(new VicePreference());
        userProfile1AllFields.setPetsPreference(new PetsPreference());
        userProfile1AllFields.setTravelPreference(new TravelPreference());
        userProfile1AllFields.setDietPreference(new DietPreference());
        userProfile1AllFields.setInterests(Arrays.asList(new UserInterest()));

        return Stream.of(
                Arguments.of(userProfile1, userProfile1),
                Arguments.of(userProfile1, userProfile2),
                Arguments.of(userProfileNull, userProfileNull),
                Arguments.of(userProfile1, userProfile1AllFields));
    }

}
