package net.spotapps.tester.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import net.spotapps.tester.dao.AgePreferenceRepository;
import net.spotapps.tester.dao.ChildRepository;
import net.spotapps.tester.dao.ChildrenPreferenceRepository;
import net.spotapps.tester.dao.ContactPreferenceRepository;
import net.spotapps.tester.dao.DietPreferenceRepository;
import net.spotapps.tester.dao.EducationPreferenceRepository;
import net.spotapps.tester.dao.GenderPreferenceRepository;
import net.spotapps.tester.dao.LanguagePreferenceRepository;
import net.spotapps.tester.dao.LanguageRepository;
import net.spotapps.tester.dao.LocationPreferenceRepository;
import net.spotapps.tester.dao.PetRepository;
import net.spotapps.tester.dao.PetsPreferenceRepository;
import net.spotapps.tester.dao.RelationshipPreferenceRepository;
import net.spotapps.tester.dao.ReligionPreferenceRepository;
import net.spotapps.tester.dao.SocialPersonalityRepository;
import net.spotapps.tester.dao.TravelPreferenceRepository;
import net.spotapps.tester.dao.UserImageRepository;
import net.spotapps.tester.dao.UserInterestRepository;
import net.spotapps.tester.dao.UserProfileRepository;
import net.spotapps.tester.dao.UserRepository;
import net.spotapps.tester.dao.VicePreferenceRepository;
import net.spotapps.tester.dao.ViceRepository;

@SpringBootTest
@ActiveProfiles({"render", "lookups"})
@Transactional
public class RenderDataPopulationServiceTest {

    @Autowired
    private RenderDataPopulationService populationService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserImageRepository userImageRepository;

    @Autowired
    private UserInterestRepository userInterestRepository;

    @Autowired
    private AgePreferenceRepository agePreferenceRepository;

    @Autowired
    private ContactPreferenceRepository contactPreferenceRepository;

    @Autowired
    private LocationPreferenceRepository locationPreferenceRepository;

    @Autowired
    private SocialPersonalityRepository socialPersonalityRepository;

    @Autowired
    private GenderPreferenceRepository genderPreferenceRepository;

    @Autowired
    private RelationshipPreferenceRepository relationshipPreferenceRepository;

    @Autowired
    private ReligionPreferenceRepository religionPreferenceRepository;

    @Autowired
    private EducationPreferenceRepository educationPreferenceRepository;

    @Autowired
    private ChildrenPreferenceRepository childrenPreferenceRepository;

    @Autowired
    private LanguagePreferenceRepository languagePreferenceRepository;

    @Autowired
    private VicePreferenceRepository vicePreferenceRepository;

    @Autowired
    private PetsPreferenceRepository petsPreferenceRepository;

    @Autowired
    private TravelPreferenceRepository travelPreferenceRepository;

    @Autowired
    private DietPreferenceRepository dietPreferenceRepository;
    
    @Autowired
    private ChildRepository childRepository;
    
    @Autowired
    private LanguageRepository languageRepository;
    
    @Autowired
    private ViceRepository viceRepository;
    
    @Autowired
    private PetRepository petRepository;

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
        // Clear all dependent data first to avoid integrity violations
        agePreferenceRepository.deleteAllInBatch();
        contactPreferenceRepository.deleteAllInBatch();
        locationPreferenceRepository.deleteAllInBatch();
        socialPersonalityRepository.deleteAllInBatch();
        genderPreferenceRepository.deleteAllInBatch();
        relationshipPreferenceRepository.deleteAllInBatch();
        religionPreferenceRepository.deleteAllInBatch();
        educationPreferenceRepository.deleteAllInBatch();
        
        childRepository.deleteAllInBatch();
        childrenPreferenceRepository.deleteAllInBatch();
        
        languageRepository.deleteAllInBatch();
        languagePreferenceRepository.deleteAllInBatch();
        
        viceRepository.deleteAllInBatch();
        vicePreferenceRepository.deleteAllInBatch();
        
        petRepository.deleteAllInBatch();
        petsPreferenceRepository.deleteAllInBatch();
        
        travelPreferenceRepository.deleteAllInBatch();
        dietPreferenceRepository.deleteAllInBatch();
        userImageRepository.deleteAllInBatch();
        userInterestRepository.deleteAllInBatch();
        
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
        
        assertEquals(0, userProfileRepository.count());

        populationService.initData();

        // It generates 100 users/profiles by default if count is 0
        assertEquals(100, userProfileRepository.count(), "Should have generated 100 dummy profiles");
    }
}
