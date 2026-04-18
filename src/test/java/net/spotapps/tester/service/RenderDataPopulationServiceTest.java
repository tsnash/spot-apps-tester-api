package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.dao.UserRepository;

@SpringBootTest
@ActiveProfiles({"render", "lookups"})
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RenderDataPopulationServiceTest {

    @Autowired
    private RenderDataPopulationService populationService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testInitDataIdempotency() {
        // initData is called once on startup due to @PostConstruct
        long profileCountAfterStartup = userProfileRepository.count();

        assertTrue(profileCountAfterStartup > 0, "Profiles should have been seeded on startup");

        // Call it again
        populationService.initData();

        assertEquals(profileCountAfterStartup, userProfileRepository.count(), "Profile count should not change after second initData call");
    }

    @Test
    void testInitDataProfilesGenerated() {
        // Clear root entities; Hibernate cascades will handle dependent preference entities
        userProfileRepository.deleteAll();
        userRepository.deleteAll();
        
        assertEquals(0, userProfileRepository.count());

        populationService.initData();

        // It generates 100 users/profiles by default if count is 0
        assertEquals(100, userProfileRepository.count(), "Should have generated 100 dummy profiles");
    }
}
