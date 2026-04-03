package net.spotapps.tester.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import net.spotapps.tester.dao.*;
import net.spotapps.tester.model.*;

@Service
@Profile("render & !default")
public class RenderDataPopulationService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserImageRepository userImageRepository;

    @Autowired
    private UserInterestRepository userInterestRepository;

    @Autowired
    private UserRepository userRepository;

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
    private ChildrenPreferenceRepository childrenPreferenceRepository;

    @Autowired
    private AgePreferenceRepository agePreferenceRepository;

    @Autowired
    private ReligionPreferenceRepository religionPreferenceRepository;

    @Autowired
    private EducationPreferenceRepository educationPreferenceRepository;

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
    private TransactionTemplate transactionTemplate;

    @PostConstruct
    public void initData() {
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
            initUserProfiles();
            initUserImages();
            initUserInterests();
            initPreferences();
        });
    }

    private void initGenders() {
        if (genderRepository.count() == 0) {
            genderRepository.saveAll(List.of(new Gender("Male"), new Gender("Female"), new Gender("Non-binary")));
        }
    }

    private void initOrientations() {
        if (orientationRepository.count() == 0) {
            orientationRepository.saveAll(List.of(new Orientation("Heterosexual"), new Orientation("Homosexual"), new Orientation("Bisexual")));
        }
    }

    private void initPersonalityScales() {
        if (personalityScaleRepository.count() == 0) {
            personalityScaleRepository.saveAll(List.of(
                    new PersonalityScale("Very Low"),
                    new PersonalityScale("Low"),
                    new PersonalityScale("Neutral"),
                    new PersonalityScale("High"),
                    new PersonalityScale("Very High")));
        }
    }

    private void initRelationshipStatuses() {
        if (relationshipStatusRepository.count() == 0) {
            relationshipStatusRepository.saveAll(List.of(new RelationshipStatus("Single"), new RelationshipStatus("Married"), new RelationshipStatus("Divorced")));
        }
    }

    private void initRelationshipPractices() {
        if (relationshipPracticeRepository.count() == 0) {
            relationshipPracticeRepository.saveAll(List.of(new RelationshipPractice("Monogamy"), new RelationshipPractice("Polyamory"), new RelationshipPractice("Open Relationship")));
        }
    }

    private void initRelationshipInterests() {
        if (relationshipInterestRepository.count() == 0) {
            relationshipInterestRepository.saveAll(List.of(new RelationshipInterest("Long-term"), new RelationshipInterest("Short-term"), new RelationshipInterest("Casual")));
        }
    }

    private void initReligions() {
        if (religionRepository.count() == 0) {
            religionRepository.saveAll(List.of(
                    new Religion("Christianity", "Catholicism"),
                    new Religion("Christianity", "Protestantism"),
                    new Religion("Islam", "Sunni"),
                    new Religion("Islam", "Shia"),
                    new Religion("Judaism", "Orthodox"),
                    new Religion("None", "Atheist")));
        }
    }

    private void initLifeStages() {
        if (lifeStageRepository.count() == 0) {
            lifeStageRepository.saveAll(List.of(new LifeStage("Infant"), new LifeStage("Toddler"), new LifeStage("Child"), new LifeStage("Teenager"), new LifeStage("Adult")));
        }
    }

    private void initChildGenders() {
        if (childGenderRepository.count() == 0) {
            childGenderRepository.saveAll(List.of(new ChildGender("M"), new ChildGender("F")));
        }
    }

    private void initHouseholdStatuses() {
        if (householdStatusRepository.count() == 0) {
            householdStatusRepository.saveAll(List.of(new HouseholdStatus("Full-time"), new HouseholdStatus("Part-time"), new HouseholdStatus("Visiting")));
        }
    }

    private void initEducationDegrees() {
        if (educationDegreeRepository.count() == 0) {
            educationDegreeRepository.saveAll(List.of(new EducationDegree("High School"), new EducationDegree("Bachelor's"), new EducationDegree("Master's"), new EducationDegree("Doctorate")));
        }
    }

    private void initFluencyLevels() {
        if (fluencyLevelRepository.count() == 0) {
            fluencyLevelRepository.saveAll(List.of(new FluencyLevel("Native"), new FluencyLevel("Fluent"), new FluencyLevel("Conversational"), new FluencyLevel("Basic")));
        }
    }

    private void initViceTypes() {
        if (viceTypeRepository.count() == 0) {
            viceTypeRepository.saveAll(List.of(new ViceType("Smoking Cigarettes"), new ViceType("Drinking Alcohol"), new ViceType("Marijuana"), new ViceType("Vaping")));
        }
    }

    private void initViceFrequencies() {
        if (viceFrequencyRepository.count() == 0) {
            viceFrequencyRepository.saveAll(List.of(new ViceFrequency("Often"), new ViceFrequency("Sometimes"), new ViceFrequency("Rarely"), new ViceFrequency("Never")));
        }
    }

    private void initPetTypes() {
        if (petTypeRepository.count() == 0) {
            petTypeRepository.saveAll(List.of(new PetType("Dogs"), new PetType("Cats"), new PetType("Birds"), new PetType("Fish")));
        }
    }

    private void initTravelFrequencies() {
        if (travelFrequencyRepository.count() == 0) {
            travelFrequencyRepository.saveAll(List.of(new TravelFrequency("Often"), new TravelFrequency("Sometimes"), new TravelFrequency("Rarely"), new TravelFrequency("Never")));
        }
    }

    private void initTravelDurations() {
        if (travelDurationRepository.count() == 0) {
            travelDurationRepository.saveAll(List.of(new TravelDuration("Short"), new TravelDuration("Medium"), new TravelDuration("Long")));
        }
    }

    private void initTravelDistances() {
        if (travelDistanceRepository.count() == 0) {
            travelDistanceRepository.saveAll(List.of(new TravelDistance("Near"), new TravelDistance("Far"), new TravelDistance("International")));
        }
    }

    private void initTravelGroupSizes() {
        if (travelGroupSizeRepository.count() == 0) {
            travelGroupSizeRepository.saveAll(List.of(new TravelGroupSize("Solo"), new TravelGroupSize("Couple"), new TravelGroupSize("Small Group"), new TravelGroupSize("Large Group")));
        }
    }

    private void initUserProfiles() {
        if (userProfileRepository.count() == 0) {
            List<User> users = IntStream.range(0, 100)
                    .mapToObj(i -> new User())
                    .toList();
            List<User> savedUsers = userRepository.saveAll(users);

            List<UserProfile> profiles = savedUsers.stream().map(user -> {
                UserProfile profile = new UserProfile();
                profile.setUser(user);
                return profile;
            }).toList();
            userProfileRepository.saveAllAndFlush(profiles);
        }
    }

    private void initUserImages() {
        if (userImageRepository.count() == 0) {
            List<UserProfile> userProfiles = userProfileRepository.findAll();
            List<UserImage> images = new ArrayList<>();
            for (UserProfile userProfile : userProfiles) {
                images.addAll(IntStream.range(0, 4)
                        .mapToObj(i -> new UserImage(i + ".png", userProfile))
                        .toList());
            }
            userImageRepository.saveAllAndFlush(images);
        }
    }

    private void initUserInterests() {
        if (userInterestRepository.count() == 0) {
            List<UserProfile> userProfiles = userProfileRepository.findAll();
            List<UserInterest> interests = new ArrayList<>();
            for (UserProfile userProfile : userProfiles) {
                interests.addAll(IntStream.range(0, new Random().nextInt(7))
                        .mapToObj(i -> new UserInterest(RandomStringUtils.randomAlphabetic(8), userProfile))
                        .toList());
            }
            userInterestRepository.saveAllAndFlush(interests);
        }
    }

    private void initPreferences() {
        if (contactPreferenceRepository.count() == 0) {
            List<UserProfile> userProfiles = userProfileRepository.findAll();
            Random random = new Random();

            for (UserProfile profile : userProfiles) {
                initContactPreference(profile, random);
                initLocationPreference(profile, random);
                initAgePreference(profile, random);
                initSocialPersonality(profile, random);
                initGenderPreference(profile, random);
                initRelationshipPreference(profile, random);
                initReligionPreference(profile, random);
                initEducationPreference(profile, random);
                initChildrenPreference(profile, random);
                initLanguagePreference(profile, random);
                initVicePreference(profile, random);
                initPetsPreference(profile, random);
                initTravelPreference(profile, random);
                initDietPreference(profile, random);
            }
        }
    }

    private void initContactPreference(UserProfile profile, Random random) {
        ContactPreference contact = new ContactPreference();
        contact.setFirstName(RandomStringUtils.randomAlphabetic(5, 10));
        contact.setLastName(RandomStringUtils.randomAlphabetic(5, 10));
        contact.setEmailAddress(RandomStringUtils.randomAlphabetic(5, 8) + "@example.com");
        contact.setPhoneNumber(RandomStringUtils.randomNumeric(10));
        contact.setEmailVerified(random.nextBoolean());
        contact.setUserProfile(profile);
        contactPreferenceRepository.save(contact);
    }

    private void initLocationPreference(UserProfile profile, Random random) {
        LocationPreference location = new LocationPreference();
        location.setUseLocal(random.nextBoolean());
        location.setDistanceInMiles(10.0 + random.nextDouble() * 90.0);
        location.setUserProfile(profile);
        locationPreferenceRepository.save(location);
    }

    private void initAgePreference(UserProfile profile, Random random) {
        AgePreference age = new AgePreference();
        age.setDay(String.format("%02d", 1 + random.nextInt(28)));
        age.setMonth("January");
        age.setYear(String.valueOf(1970 + random.nextInt(40)));
        age.setMinAge(18 + random.nextInt(10));
        age.setMaxAge(40 + random.nextInt(40));
        age.setUserProfile(profile);
        agePreferenceRepository.save(age);
    }

    private void initSocialPersonality(UserProfile profile, Random random) {
        List<PersonalityScale> scales = personalityScaleRepository.findAll();
        if (scales.isEmpty())
            return;

        SocialPersonality social = new SocialPersonality();
        social.setOpenness(scales.get(random.nextInt(scales.size())));
        social.setConscientiousness(scales.get(random.nextInt(scales.size())));
        social.setExtraversion(scales.get(random.nextInt(scales.size())));
        social.setAgreeableness(scales.get(random.nextInt(scales.size())));
        social.setNeuroticism(scales.get(random.nextInt(scales.size())));
        social.setUserProfile(profile);
        socialPersonalityRepository.save(social);
    }

    private void initGenderPreference(UserProfile profile, Random random) {
        List<Gender> genders = genderRepository.findAll();
        List<Orientation> orientations = orientationRepository.findAll();
        if (genders.isEmpty() || orientations.isEmpty())
            return;

        GenderPreference genderPref = new GenderPreference();
        genderPref.setGender(genders.get(random.nextInt(genders.size())));
        genderPref.setOrientation(orientations.get(random.nextInt(orientations.size())));
        genderPref.setTrans(random.nextBoolean());
        genderPref.setUserProfile(profile);
        genderPreferenceRepository.save(genderPref);
    }

    private void initRelationshipPreference(UserProfile profile, Random random) {
        List<RelationshipStatus> statuses = relationshipStatusRepository.findAll();
        if (statuses.isEmpty())
            return;

        RelationshipPreference relation = new RelationshipPreference();
        relation.setRelationshipStatus(statuses.get(random.nextInt(statuses.size())));

        List<RelationshipPractice> practices = relationshipPracticeRepository.findAll();
        if (!practices.isEmpty()) {
            relation.getRelationshipPractices().add(practices.get(random.nextInt(practices.size())));
        }

        List<RelationshipInterest> interests = relationshipInterestRepository.findAll();
        if (!interests.isEmpty()) {
            relation.getRelationshipInterests().add(interests.get(random.nextInt(interests.size())));
        }

        relation.setUserProfile(profile);
        relationshipPreferenceRepository.save(relation);
    }

    private void initReligionPreference(UserProfile profile, Random random) {
        List<Religion> religions = religionRepository.findAll();
        if (religions.isEmpty())
            return;

        ReligionPreference religionPref = new ReligionPreference();
        religionPref.setReligion(religions.get(random.nextInt(religions.size())));
        religionPref.setImportance(1 + random.nextInt(5));
        religionPref.setSameReligion(random.nextBoolean());
        religionPref.setUserProfile(profile);
        religionPreferenceRepository.save(religionPref);
    }

    private void initEducationPreference(UserProfile profile, Random random) {
        List<EducationDegree> degrees = educationDegreeRepository.findAll();
        if (degrees.isEmpty())
            return;

        EducationPreference education = new EducationPreference();
        education.setHighestDegree(degrees.get(random.nextInt(degrees.size())));
        education.setConcentration(RandomStringUtils.randomAlphabetic(8, 12));
        education.setImportance(1 + random.nextInt(5));
        education.setUserProfile(profile);
        educationPreferenceRepository.save(education);
    }

    private void initChildrenPreference(UserProfile profile, Random random) {
        ChildrenPreference childrenPref = new ChildrenPreference();
        childrenPref.setMoreChildren(random.nextBoolean());

        if (random.nextBoolean()) {
            List<LifeStage> stages = lifeStageRepository.findAll();
            List<ChildGender> genders = childGenderRepository.findAll();
            List<HouseholdStatus> statuses = householdStatusRepository.findAll();
            if (!stages.isEmpty() && !genders.isEmpty() && !statuses.isEmpty()) {
                Child child = new Child();
                child.setLifeStage(stages.get(random.nextInt(stages.size())));
                child.setGender(genders.get(random.nextInt(genders.size())));
                child.setInHousehold(statuses.get(random.nextInt(statuses.size())));
                childrenPref.addChild(child);
            }
        }

        childrenPref.setUserProfile(profile);
        childrenPreferenceRepository.save(childrenPref);
    }

    private void initLanguagePreference(UserProfile profile, Random random) {
        LanguagePreference languagePref = new LanguagePreference();
        languagePref.setImportance(1 + random.nextInt(5));

        List<FluencyLevel> levels = fluencyLevelRepository.findAll();
        if (!levels.isEmpty()) {
            Language language = new Language();
            language.setName(RandomStringUtils.randomAlphabetic(6, 10));
            language.setFluency(levels.get(random.nextInt(levels.size())));
            languagePref.addLanguageSpoken(language);
        }

        languagePref.setUserProfile(profile);
        languagePreferenceRepository.save(languagePref);
    }

    private void initVicePreference(UserProfile profile, Random random) {
        VicePreference vicePref = new VicePreference();
        vicePref.setImportance(1 + random.nextInt(5));

        List<ViceType> types = viceTypeRepository.findAll();
        List<ViceFrequency> frequencies = viceFrequencyRepository.findAll();
        if (!types.isEmpty() && !frequencies.isEmpty()) {
            Vice vice = new Vice();
            vice.setViceType(types.get(random.nextInt(types.size())));
            vice.setFrequency(frequencies.get(random.nextInt(frequencies.size())));
            vicePref.addVice(vice);
        }

        vicePref.setUserProfile(profile);
        vicePreferenceRepository.save(vicePref);
    }

    private void initPetsPreference(UserProfile profile, Random random) {
        PetsPreference petsPref = new PetsPreference();
        petsPref.setImportance(1 + random.nextInt(5));

        List<PetType> types = petTypeRepository.findAll();
        if (!types.isEmpty()) {
            Pet pet = new Pet();
            pet.setPetType(types.get(random.nextInt(types.size())));
            pet.setQuantity(1 + random.nextInt(3));
            pet.setIsAllowed(random.nextBoolean());
            petsPref.addPet(pet);
        }

        petsPref.setUserProfile(profile);
        petsPreferenceRepository.save(petsPref);
    }

    private void initTravelPreference(UserProfile profile, Random random) {
        List<TravelFrequency> frequencies = travelFrequencyRepository.findAll();
        List<TravelDuration> durations = travelDurationRepository.findAll();
        List<TravelDistance> distances = travelDistanceRepository.findAll();
        List<TravelGroupSize> groupSizes = travelGroupSizeRepository.findAll();

        if (frequencies.isEmpty() || durations.isEmpty() || distances.isEmpty() || groupSizes.isEmpty())
            return;

        TravelPreference travel = new TravelPreference();
        travel.setFrequency(frequencies.get(random.nextInt(frequencies.size())));
        travel.setDuration(durations.get(random.nextInt(durations.size())));
        travel.setDistance(distances.get(random.nextInt(distances.size())));
        travel.setGroupSize(groupSizes.get(random.nextInt(groupSizes.size())));
        travel.setImportance(1 + random.nextInt(5));

        travel.setUserProfile(profile);
        travelPreferenceRepository.save(travel);
    }

    private void initDietPreference(UserProfile profile, Random random) {
        DietPreference diet = new DietPreference();
        diet.setImportance(1 + random.nextInt(5));
        diet.getRestrictions().add(DietaryRestriction.values()[random.nextInt(DietaryRestriction.values().length)]);

        diet.setUserProfile(profile);
        dietPreferenceRepository.save(diet);
    }

}
