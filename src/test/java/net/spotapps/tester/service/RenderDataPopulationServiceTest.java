package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import net.spotapps.tester.dao.GenderRepository;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.model.Gender;

@SpringBootTest
@ActiveProfiles("render")
@Transactional
public class RenderDataPopulationServiceTest {

    @Autowired
    private RenderDataPopulationService populationService;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private net.spotapps.tester.dao.GenderPreferenceRepository genderPreferenceRepository;

    @Test
    void testInitDataIdempotency() {
        // initData is called once on startup due to @PostConstruct
        long genderCountAfterStartup = genderRepository.count();
        long profileCountAfterStartup = userProfileRepository.count();

        assertTrue(genderCountAfterStartup > 0, "Genders should have been seeded on startup");
        assertTrue(profileCountAfterStartup > 0, "Profiles should have been seeded on startup");

        // Call it again
        populationService.initData();

        assertEquals(genderCountAfterStartup, genderRepository.count(), "Gender count should not change after second initData call");
        assertEquals(profileCountAfterStartup, userProfileRepository.count(), "Profile count should not change after second initData call");
    }

    @Test
    void testInitDataBackfill() {
        // Assume some lookups are already there from startup.
        // Let's add a new one manually and see if others are still there and not duplicated.
        // Actually, let's clear genders and add only one.
        // We need to clear gender preferences first due to FK constraints
        genderPreferenceRepository.deleteAllInBatch();
        genderRepository.deleteAllInBatch();
        genderRepository.save(new Gender("Custom Gender"));
        genderRepository.flush();

        assertEquals(1, genderRepository.count());

        populationService.initData();

        // Canonical genders: Male, Female, Non-binary
        // Total should be 1 + 3 = 4
        assertEquals(4, genderRepository.count(), "Should have added 3 canonical genders and kept the custom one");
        assertTrue(genderRepository.findAll().stream().anyMatch(g -> g.getName().equals("Male")));
        assertTrue(genderRepository.findAll().stream().anyMatch(g -> g.getName().equals("Female")));
        assertTrue(genderRepository.findAll().stream().anyMatch(g -> g.getName().equals("Non-binary")));
        assertTrue(genderRepository.findAll().stream().anyMatch(g -> g.getName().equals("Custom Gender")));
    }
}
