package net.spotapps.tester.service;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import net.spotapps.tester.config.LookupDataProperties;
import net.spotapps.tester.dao.ChildGenderRepository;
import net.spotapps.tester.dao.EducationDegreeRepository;
import net.spotapps.tester.dao.FluencyLevelRepository;
import net.spotapps.tester.dao.GenderRepository;
import net.spotapps.tester.dao.HouseholdStatusRepository;
import net.spotapps.tester.dao.LifeStageRepository;
import net.spotapps.tester.dao.OrientationRepository;
import net.spotapps.tester.dao.PersonalityScaleRepository;
import net.spotapps.tester.dao.PetTypeRepository;
import net.spotapps.tester.dao.RelationshipInterestRepository;
import net.spotapps.tester.dao.RelationshipPracticeRepository;
import net.spotapps.tester.dao.RelationshipStatusRepository;
import net.spotapps.tester.dao.ReligionRepository;
import net.spotapps.tester.dao.TravelDistanceRepository;
import net.spotapps.tester.dao.TravelDurationRepository;
import net.spotapps.tester.dao.TravelFrequencyRepository;
import net.spotapps.tester.dao.TravelGroupSizeRepository;
import net.spotapps.tester.dao.ViceFrequencyRepository;
import net.spotapps.tester.dao.ViceTypeRepository;
import net.spotapps.tester.model.ChildGender;
import net.spotapps.tester.model.EducationDegree;
import net.spotapps.tester.model.FluencyLevel;
import net.spotapps.tester.model.Gender;
import net.spotapps.tester.model.HouseholdStatus;
import net.spotapps.tester.model.LifeStage;
import net.spotapps.tester.model.Orientation;
import net.spotapps.tester.model.PersonalityScale;
import net.spotapps.tester.model.PetType;
import net.spotapps.tester.model.RelationshipInterest;
import net.spotapps.tester.model.RelationshipPractice;
import net.spotapps.tester.model.RelationshipStatus;
import net.spotapps.tester.model.Religion;
import net.spotapps.tester.model.TravelDistance;
import net.spotapps.tester.model.TravelDuration;
import net.spotapps.tester.model.TravelFrequency;
import net.spotapps.tester.model.TravelGroupSize;
import net.spotapps.tester.model.ViceFrequency;
import net.spotapps.tester.model.ViceType;

@Service
public class LookupDataPopulationService {

    @Autowired
    private LookupDataProperties lookupProperties;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private OrientationRepository orientationRepository;

    @Autowired
    private PersonalityScaleRepository personalityScaleRepository;

    @Autowired
    private RelationshipStatusRepository relationshipStatusRepository;

    @Autowired
    private RelationshipPracticeRepository relationshipPracticeRepository;

    @Autowired
    private RelationshipInterestRepository relationshipInterestRepository;

    @Autowired
    private ReligionRepository religionRepository;

    @Autowired
    private LifeStageRepository lifeStageRepository;

    @Autowired
    private ChildGenderRepository childGenderRepository;

    @Autowired
    private HouseholdStatusRepository householdStatusRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private FluencyLevelRepository fluencyLevelRepository;

    @Autowired
    private ViceTypeRepository viceTypeRepository;

    @Autowired
    private ViceFrequencyRepository viceFrequencyRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Autowired
    private TravelFrequencyRepository travelFrequencyRepository;

    @Autowired
    private TravelDurationRepository travelDurationRepository;

    @Autowired
    private TravelDistanceRepository travelDistanceRepository;

    @Autowired
    private TravelGroupSizeRepository travelGroupSizeRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PostConstruct
    public void initLookups() {
        transactionTemplate.executeWithoutResult(status -> {
            initGenders();
            initOrientations();
            initPersonalityScales();
            initRelationshipStatuses();
            initRelationshipPractices();
            initRelationshipInterests();
            initReligions();
            initLifeStages();
            initChildGenders();
            initHouseholdStatuses();
            initEducationDegrees();
            initFluencyLevels();
            initViceTypes();
            initViceFrequencies();
            initPetTypes();
            initTravelFrequencies();
            initTravelDurations();
            initTravelDistances();
            initTravelGroupSizes();
        });
    }

    private <T, ID> void upsertMissingLookups(
            JpaRepository<T, ID> repository,
            Function<T, String> nameExtractor,
            List<String> canonicalNames,
            Function<String, T> entityCreator) {
        upsertMissingLookups(repository, nameExtractor, canonicalNames, Function.identity(), entityCreator);
    }

    private <T, ID, S> void upsertMissingLookups(
            JpaRepository<T, ID> repository,
            Function<T, String> keyExtractor,
            List<S> sourceItems,
            Function<S, String> sourceKeyExtractor,
            Function<S, T> entityCreator) {
        if (sourceItems == null || sourceItems.isEmpty()) {
            return;
        }

        Set<String> existingKeys = repository.findAll().stream()
                .map(item -> normalize(keyExtractor.apply(item)))
                .collect(Collectors.toSet());

        List<T> toAdd = sourceItems.stream()
                .filter(source -> !existingKeys.contains(normalize(sourceKeyExtractor.apply(source))))
                .map(entityCreator)
                .toList();

        if (!toAdd.isEmpty()) {
            repository.saveAll(toAdd);
        }
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
    }

    private void initGenders() {
        upsertMissingLookups(genderRepository, Gender::getName, lookupProperties.getGenders(), Gender::new);
    }

    private void initOrientations() {
        upsertMissingLookups(orientationRepository, Orientation::getName, lookupProperties.getOrientations(), Orientation::new);
    }

    private void initPersonalityScales() {
        upsertMissingLookups(personalityScaleRepository, PersonalityScale::getName, lookupProperties.getPersonalityScales(), PersonalityScale::new);
    }

    private void initRelationshipStatuses() {
        upsertMissingLookups(relationshipStatusRepository, RelationshipStatus::getName, lookupProperties.getRelationshipStatuses(), RelationshipStatus::new);
    }

    private void initRelationshipPractices() {
        upsertMissingLookups(relationshipPracticeRepository, RelationshipPractice::getName, lookupProperties.getRelationshipPractices(), RelationshipPractice::new);
    }

    private void initRelationshipInterests() {
        upsertMissingLookups(relationshipInterestRepository, RelationshipInterest::getName, lookupProperties.getRelationshipInterests(), RelationshipInterest::new);
    }

    private void initReligions() {
        upsertMissingLookups(
                religionRepository,
                r -> r.getReligionName() + "|" + r.getBranchName(),
                lookupProperties.getReligions(),
                p -> p.getName() + "|" + p.getBranch(),
                p -> new Religion(p.getName(), p.getBranch())
        );
    }

    private void initLifeStages() {
        upsertMissingLookups(lifeStageRepository, LifeStage::getName, lookupProperties.getLifeStages(), LifeStage::new);
    }

    private void initChildGenders() {
        upsertMissingLookups(childGenderRepository, ChildGender::getName, lookupProperties.getChildGenders(), ChildGender::new);
    }

    private void initHouseholdStatuses() {
        upsertMissingLookups(householdStatusRepository, HouseholdStatus::getName, lookupProperties.getHouseholdStatuses(), HouseholdStatus::new);
    }

    private void initEducationDegrees() {
        upsertMissingLookups(educationDegreeRepository, EducationDegree::getName, lookupProperties.getEducationDegrees(), EducationDegree::new);
    }

    private void initFluencyLevels() {
        upsertMissingLookups(fluencyLevelRepository, FluencyLevel::getName, lookupProperties.getFluencyLevels(), FluencyLevel::new);
    }

    private void initViceTypes() {
        upsertMissingLookups(viceTypeRepository, ViceType::getName, lookupProperties.getViceTypes(), ViceType::new);
    }

    private void initViceFrequencies() {
        upsertMissingLookups(viceFrequencyRepository, ViceFrequency::getName, lookupProperties.getViceFrequencies(), ViceFrequency::new);
    }

    private void initPetTypes() {
        upsertMissingLookups(petTypeRepository, PetType::getName, lookupProperties.getPetTypes(), PetType::new);
    }

    private void initTravelFrequencies() {
        upsertMissingLookups(travelFrequencyRepository, TravelFrequency::getName, lookupProperties.getTravelFrequencies(), TravelFrequency::new);
    }

    private void initTravelDurations() {
        upsertMissingLookups(travelDurationRepository, TravelDuration::getName, lookupProperties.getTravelDurations(), TravelDuration::new);
    }

    private void initTravelDistances() {
        upsertMissingLookups(travelDistanceRepository, TravelDistance::getName, lookupProperties.getTravelDistances(), TravelDistance::new);
    }

    private void initTravelGroupSizes() {
        upsertMissingLookups(travelGroupSizeRepository, TravelGroupSize::getName, lookupProperties.getTravelGroupSizes(), TravelGroupSize::new);
    }
}
