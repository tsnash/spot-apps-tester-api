package net.spotapps.tester.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;

import net.spotapps.tester.dto.UserProfileDto;
import net.spotapps.tester.model.DietaryRestriction;

@SpringBootTest
@Sql(scripts = "classpath:datasets/user_profiles_setup.sql",
        config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
@Sql(scripts = "classpath:datasets/user_profiles_teardown.sql",
        executionPhase = ExecutionPhase.AFTER_TEST_METHOD,
        config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
class UserProfileServiceLazyPreferencesTest {

    @Autowired
    private UserProfileService userProfileService;

    @Test
    void getUserProfileMapsLazyPreferenceData() {
        assertPreferencesMapped(userProfileService.getUserProfile("2"));
    }

    @Test
    void getUserProfileListMapsLazyPreferenceData() {
        List<UserProfileDto> profiles = userProfileService.getUserProfileList(List.of("2"));

        assertThat(profiles).hasSize(1);
        assertPreferencesMapped(profiles.getFirst());
    }

    @Test
    void getAllProfilesMapsLazyPreferenceData() {
        UserProfileDto profile = userProfileService.getAllProfiles().stream()
                .filter(candidate -> candidate.getUserId().equals(2L))
                .findFirst()
                .orElseThrow();

        assertPreferencesMapped(profile);
    }

    private static void assertPreferencesMapped(UserProfileDto profile) {
        assertThat(profile.getLanguagePreference().getLanguagesSpoken())
                .extracting(language -> language.getName())
                .containsExactly("English");
        assertThat(profile.getDietPreference().getRestrictions())
                .containsExactly(DietaryRestriction.VEGAN);
    }
}
