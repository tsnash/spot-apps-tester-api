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
        userProfile3AllFields.setLocation(new LocationPreference());
        userProfile3AllFields.setSocial(new SocialPreference());
        userProfile3AllFields.setGender(new GenderPreference());
        userProfile3AllFields.setRelationship(new RelationshipPreference());
        userProfile3AllFields.setChildren(new ChildrenPreference());
        userProfile3AllFields.setAge(new AgePreference());
        userProfile3AllFields.setReligion(new ReligionPreference());
        userProfile3AllFields.setEducation(new EducationPreference());
        userProfile3AllFields.setLanguage(new LanguagePreference());
        userProfile3AllFields.setVice(new VicePreference());
        userProfile3AllFields.setPets(new PetsPreference());
        userProfile3AllFields.setTravel(new TravelPreference());
        userProfile3AllFields.setDiet(new DietPreference());
        userProfile3AllFields.setInterests(Arrays.asList(new UserInterest()));

        UserProfile userProfile4AllFields = new UserProfile();
        userProfile4AllFields.setUserId(4L);
        userProfile4AllFields.setImages(Arrays.asList(new UserImage()));
        userProfile4AllFields.setContactPreference(new ContactPreference());
        userProfile4AllFields.setLocation(new LocationPreference());
        userProfile4AllFields.setSocial(new SocialPreference());
        userProfile4AllFields.setGender(new GenderPreference());
        userProfile4AllFields.setRelationship(new RelationshipPreference());
        userProfile4AllFields.setChildren(new ChildrenPreference());
        userProfile4AllFields.setAge(new AgePreference());
        userProfile4AllFields.setReligion(new ReligionPreference());
        userProfile4AllFields.setEducation(new EducationPreference());
        userProfile4AllFields.setLanguage(new LanguagePreference());
        userProfile4AllFields.setVice(new VicePreference());
        userProfile4AllFields.setPets(new PetsPreference());
        userProfile4AllFields.setTravel(new TravelPreference());
        userProfile4AllFields.setDiet(new DietPreference());
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
        userProfile1AllFields.setLocation(new LocationPreference());
        userProfile1AllFields.setSocial(new SocialPreference());
        userProfile1AllFields.setGender(new GenderPreference());
        userProfile1AllFields.setRelationship(new RelationshipPreference());
        userProfile1AllFields.setChildren(new ChildrenPreference());
        userProfile1AllFields.setAge(new AgePreference());
        userProfile1AllFields.setReligion(new ReligionPreference());
        userProfile1AllFields.setEducation(new EducationPreference());
        userProfile1AllFields.setLanguage(new LanguagePreference());
        userProfile1AllFields.setVice(new VicePreference());
        userProfile1AllFields.setPets(new PetsPreference());
        userProfile1AllFields.setTravel(new TravelPreference());
        userProfile1AllFields.setDiet(new DietPreference());
        userProfile1AllFields.setInterests(Arrays.asList(new UserInterest()));

        return Stream.of(
                Arguments.of(userProfile1, userProfile1),
                Arguments.of(userProfile1, userProfile2),
                Arguments.of(userProfileNull, userProfileNull),
                Arguments.of(userProfile1, userProfile1AllFields));
    }

}
