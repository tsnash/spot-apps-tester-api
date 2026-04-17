package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import net.spotapps.tester.dao.GenderRepository;
import net.spotapps.tester.dao.ReligionRepository;
import net.spotapps.tester.model.Gender;
import net.spotapps.tester.model.Religion;

@SpringBootTest
@ActiveProfiles("lookups")
@Transactional
public class LookupDataPopulationServiceTest {

    @Autowired
    private LookupDataPopulationService lookupDataPopulationService;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private ReligionRepository religionRepository;

    @Autowired
    private net.spotapps.tester.dao.GenderPreferenceRepository genderPreferenceRepository;

    @Test
    void testInitLookupsIdempotency() {
        long genderCountAfterStartup = genderRepository.count();
        long religionCountAfterStartup = religionRepository.count();

        assertTrue(genderCountAfterStartup > 0, "Genders should have been seeded from YAML on startup");
        assertTrue(religionCountAfterStartup > 0, "Religions should have been seeded from YAML on startup");

        // Call it again
        lookupDataPopulationService.initLookups();

        assertEquals(genderCountAfterStartup, genderRepository.count(), "Gender count should not change after second initLookups call");
        assertEquals(religionCountAfterStartup, religionRepository.count(), "Religion count should not change after second initLookups call");
    }

    @Test
    void testInitLookupsBackfill() {
        // Clear genders (must clear preferences first)
        genderPreferenceRepository.deleteAllInBatch();
        genderRepository.deleteAllInBatch();
        
        genderRepository.save(new Gender("Custom Gender"));
        genderRepository.flush();

        assertEquals(1, genderRepository.count());

        lookupDataPopulationService.initLookups();

        // Check that YAML genders are added. 
        // Based on application-lookups.yaml, there should be 3: Male, Female, Non-binary
        // Total should be 1 + 3 = 4
        assertEquals(4, genderRepository.count(), "Should have added 3 canonical genders and kept the custom one");
        assertTrue(genderRepository.findAll().stream().anyMatch(g -> g.getName().equalsIgnoreCase("Male")));
    }

    @Test
    void testReligionBackfill() {
        religionRepository.deleteAllInBatch();
        religionRepository.save(new Religion("Custom Religion", "Custom Branch"));
        religionRepository.flush();

        long initialCount = religionRepository.count();
        assertEquals(1, initialCount);

        lookupDataPopulationService.initLookups();

        // Based on application-lookups.yaml, there are 6 religions
        assertEquals(7, religionRepository.count(), "Should have added 6 canonical religions and kept the custom one");
        assertTrue(religionRepository.findAll().stream().anyMatch(r -> r.getReligionName().equalsIgnoreCase("Christianity") && r.getBranchName().equalsIgnoreCase("Catholicism")));
    }
}
