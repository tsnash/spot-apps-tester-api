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
        List<String> canonicalNames = List.of("Male", "Female", "Non-binary");
        List<Gender> existing = genderRepository.findAll();
        List<Gender> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(Gender::new)
                .toList();
        if (!toAdd.isEmpty()) {
            genderRepository.saveAll(toAdd);
        }
    }

    private void initOrientations() {
        List<String> canonicalNames = List.of("Heterosexual", "Homosexual", "Bisexual");
        List<Orientation> existing = orientationRepository.findAll();
        List<Orientation> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(Orientation::new)
                .toList();
        if (!toAdd.isEmpty()) {
            orientationRepository.saveAll(toAdd);
        }
    }

    private void initPersonalityScales() {
        List<String> canonicalNames = List.of("Very Low", "Low", "Neutral", "High", "Very High");
        List<PersonalityScale> existing = personalityScaleRepository.findAll();
        List<PersonalityScale> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(PersonalityScale::new)
                .toList();
        if (!toAdd.isEmpty()) {
            personalityScaleRepository.saveAll(toAdd);
        }
    }

    private void initRelationshipStatuses() {
        List<String> canonicalNames = List.of("Single", "Married", "Divorced");
        List<RelationshipStatus> existing = relationshipStatusRepository.findAll();
        List<RelationshipStatus> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(RelationshipStatus::new)
                .toList();
        if (!toAdd.isEmpty()) {
            relationshipStatusRepository.saveAll(toAdd);
        }
    }

    private void initRelationshipPractices() {
        List<String> canonicalNames = List.of("Monogamy", "Polyamory", "Open Relationship");
        List<RelationshipPractice> existing = relationshipPracticeRepository.findAll();
        List<RelationshipPractice> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(RelationshipPractice::new)
                .toList();
        if (!toAdd.isEmpty()) {
            relationshipPracticeRepository.saveAll(toAdd);
        }
    }

    private void initRelationshipInterests() {
        List<String> canonicalNames = List.of("Long-term", "Short-term", "Casual");
        List<RelationshipInterest> existing = relationshipInterestRepository.findAll();
        List<RelationshipInterest> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(RelationshipInterest::new)
                .toList();
        if (!toAdd.isEmpty()) {
            relationshipInterestRepository.saveAll(toAdd);
        }
    }

    private void initReligions() {
        List<Religion> canonical = List.of(
                new Religion("Christianity", "Catholicism"),
                new Religion("Christianity", "Protestantism"),
                new Religion("Islam", "Sunni"),
                new Religion("Islam", "Shia"),
                new Religion("Judaism", "Orthodox"),
                new Religion("None", "Atheist"));
        List<Religion> existing = religionRepository.findAll();
        List<Religion> toAdd = canonical.stream()
                .filter(c -> existing.stream().noneMatch(e -> e.getReligionName().equalsIgnoreCase(c.getReligionName()) && e.getBranchName().equalsIgnoreCase(c.getBranchName())))
                .toList();
        if (!toAdd.isEmpty()) {
            religionRepository.saveAll(toAdd);
        }
    }

    private void initLifeStages() {
        List<String> canonicalNames = List.of("Infant", "Toddler", "Child", "Teenager", "Adult");
        List<LifeStage> existing = lifeStageRepository.findAll();
        List<LifeStage> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(LifeStage::new)
                .toList();
        if (!toAdd.isEmpty()) {
            lifeStageRepository.saveAll(toAdd);
        }
    }

    private void initChildGenders() {
        List<String> canonicalNames = List.of("M", "F");
        List<ChildGender> existing = childGenderRepository.findAll();
        List<ChildGender> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(ChildGender::new)
                .toList();
        if (!toAdd.isEmpty()) {
            childGenderRepository.saveAll(toAdd);
        }
    }

    private void initHouseholdStatuses() {
        List<String> canonicalNames = List.of("Full-time", "Part-time", "Visiting");
        List<HouseholdStatus> existing = householdStatusRepository.findAll();
        List<HouseholdStatus> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(HouseholdStatus::new)
                .toList();
        if (!toAdd.isEmpty()) {
            householdStatusRepository.saveAll(toAdd);
        }
    }

    private void initEducationDegrees() {
        List<String> canonicalNames = List.of("High School", "Bachelor's", "Master's", "Doctorate");
        List<EducationDegree> existing = educationDegreeRepository.findAll();
        List<EducationDegree> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(EducationDegree::new)
                .toList();
        if (!toAdd.isEmpty()) {
            educationDegreeRepository.saveAll(toAdd);
        }
    }

    private void initFluencyLevels() {
        List<String> canonicalNames = List.of("Native", "Fluent", "Conversational", "Basic");
        List<FluencyLevel> existing = fluencyLevelRepository.findAll();
        List<FluencyLevel> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(FluencyLevel::new)
                .toList();
        if (!toAdd.isEmpty()) {
            fluencyLevelRepository.saveAll(toAdd);
        }
    }

    private void initViceTypes() {
        List<String> canonicalNames = List.of("Smoking Cigarettes", "Drinking Alcohol", "Marijuana", "Vaping");
        List<ViceType> existing = viceTypeRepository.findAll();
        List<ViceType> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(ViceType::new)
                .toList();
        if (!toAdd.isEmpty()) {
            viceTypeRepository.saveAll(toAdd);
        }
    }

    private void initViceFrequencies() {
        List<String> canonicalNames = List.of("Often", "Sometimes", "Rarely", "Never");
        List<ViceFrequency> existing = viceFrequencyRepository.findAll();
        List<ViceFrequency> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(ViceFrequency::new)
                .toList();
        if (!toAdd.isEmpty()) {
            viceFrequencyRepository.saveAll(toAdd);
        }
    }

    private void initPetTypes() {
        List<String> canonicalNames = List.of("Dogs", "Cats", "Birds", "Fish");
        List<PetType> existing = petTypeRepository.findAll();
        List<PetType> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(PetType::new)
                .toList();
        if (!toAdd.isEmpty()) {
            petTypeRepository.saveAll(toAdd);
        }
    }

    private void initTravelFrequencies() {
        List<String> canonicalNames = List.of("Often", "Sometimes", "Rarely", "Never");
        List<TravelFrequency> existing = travelFrequencyRepository.findAll();
        List<TravelFrequency> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(TravelFrequency::new)
                .toList();
        if (!toAdd.isEmpty()) {
            travelFrequencyRepository.saveAll(toAdd);
        }
    }

    private void initTravelDurations() {
        List<String> canonicalNames = List.of("Short", "Medium", "Long");
        List<TravelDuration> existing = travelDurationRepository.findAll();
        List<TravelDuration> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(TravelDuration::new)
                .toList();
        if (!toAdd.isEmpty()) {
            travelDurationRepository.saveAll(toAdd);
        }
    }

    private void initTravelDistances() {
        List<String> canonicalNames = List.of("Near", "Far", "International");
        List<TravelDistance> existing = travelDistanceRepository.findAll();
        List<TravelDistance> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(TravelDistance::new)
                .toList();
        if (!toAdd.isEmpty()) {
            travelDistanceRepository.saveAll(toAdd);
        }
    }

    private void initTravelGroupSizes() {
        List<String> canonicalNames = List.of("Solo", "Couple", "Small Group", "Large Group");
        List<TravelGroupSize> existing = travelGroupSizeRepository.findAll();
        List<TravelGroupSize> toAdd = canonicalNames.stream()
                .filter(name -> existing.stream().noneMatch(e -> e.getName().equalsIgnoreCase(name)))
                .map(TravelGroupSize::new)
                .toList();
        if (!toAdd.isEmpty()) {
            travelGroupSizeRepository.saveAll(toAdd);
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
        List<UserProfile> userProfiles = userProfileRepository.findAllWithAssociations();
        Random random = new Random();

        // Prefetch lookup data
        List<PersonalityScale> scales = personalityScaleRepository.findAll();
        List<Gender> genders = genderRepository.findAll();
        List<Orientation> orientations = orientationRepository.findAll();
        List<RelationshipStatus> statuses = relationshipStatusRepository.findAll();
        List<RelationshipPractice> practices = relationshipPracticeRepository.findAll();
        List<RelationshipInterest> relationshipInterests = relationshipInterestRepository.findAll();
        List<Religion> religions = religionRepository.findAll();
        List<EducationDegree> degrees = educationDegreeRepository.findAll();
        List<LifeStage> stages = lifeStageRepository.findAll();
        List<ChildGender> childGenders = childGenderRepository.findAll();
        List<HouseholdStatus> householdStatuses = householdStatusRepository.findAll();
        List<FluencyLevel> fluencyLevels = fluencyLevelRepository.findAll();
        List<ViceType> viceTypes = viceTypeRepository.findAll();
        List<ViceFrequency> viceFrequencies = viceFrequencyRepository.findAll();
        List<PetType> petTypes = petTypeRepository.findAll();
        List<TravelFrequency> travelFrequencies = travelFrequencyRepository.findAll();
        List<TravelDuration> travelDurations = travelDurationRepository.findAll();
        List<TravelDistance> travelDistances = travelDistanceRepository.findAll();
        List<TravelGroupSize> travelGroupSizes = travelGroupSizeRepository.findAll();

        for (UserProfile profile : userProfiles) {
            if (profile.getContactPreference() == null) {
                initContactPreference(profile, random);
            }
            if (profile.getLocationPreference() == null) {
                initLocationPreference(profile, random);
            }
            if (profile.getAgePreference() == null) {
                initAgePreference(profile, random);
            }
            if (profile.getSocialPersonality() == null) {
                initSocialPersonality(profile, random, scales);
            }
            if (profile.getGenderPreference() == null) {
                initGenderPreference(profile, random, genders, orientations);
            }
            if (profile.getRelationshipPreference() == null) {
                initRelationshipPreference(profile, random, statuses, practices, relationshipInterests);
            }
            if (profile.getReligionPreference() == null) {
                initReligionPreference(profile, random, religions);
            }
            if (profile.getEducationPreference() == null) {
                initEducationPreference(profile, random, degrees);
            }
            if (profile.getChildrenPreference() == null) {
                initChildrenPreference(profile, random, stages, childGenders, householdStatuses);
            }
            if (profile.getLanguagePreference() == null) {
                initLanguagePreference(profile, random, fluencyLevels);
            }
            if (profile.getVicePreference() == null) {
                initVicePreference(profile, random, viceTypes, viceFrequencies);
            }
            if (profile.getPetsPreference() == null) {
                initPetsPreference(profile, random, petTypes);
            }
            if (profile.getTravelPreference() == null) {
                initTravelPreference(profile, random, travelFrequencies, travelDurations, travelDistances, travelGroupSizes);
            }
            if (profile.getDietPreference() == null) {
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
        profile.setContactPreference(contact);
        contactPreferenceRepository.save(contact);
    }

    private void initLocationPreference(UserProfile profile, Random random) {
        LocationPreference location = new LocationPreference();
        location.setUseLocal(random.nextBoolean());
        location.setDistanceInMiles(10.0 + random.nextDouble() * 90.0);
        profile.setLocationPreference(location);
        locationPreferenceRepository.save(location);
    }

    private void initAgePreference(UserProfile profile, Random random) {
        AgePreference age = new AgePreference();
        age.setDay(String.format("%02d", 1 + random.nextInt(28)));
        age.setMonth("January");
        age.setYear(String.valueOf(1970 + random.nextInt(40)));
        age.setMinAge(18 + random.nextInt(10));
        age.setMaxAge(40 + random.nextInt(40));
        profile.setAgePreference(age);
        agePreferenceRepository.save(age);
    }

    private void initSocialPersonality(UserProfile profile, Random random, List<PersonalityScale> scales) {
        if (scales.isEmpty())
            return;

        SocialPersonality social = new SocialPersonality();
        social.setOpenness(scales.get(random.nextInt(scales.size())));
        social.setConscientiousness(scales.get(random.nextInt(scales.size())));
        social.setExtraversion(scales.get(random.nextInt(scales.size())));
        social.setAgreeableness(scales.get(random.nextInt(scales.size())));
        social.setNeuroticism(scales.get(random.nextInt(scales.size())));
        profile.setSocialPersonality(social);
        socialPersonalityRepository.save(social);
    }

    private void initGenderPreference(UserProfile profile, Random random, List<Gender> genders, List<Orientation> orientations) {
        if (genders.isEmpty() || orientations.isEmpty())
            return;

        GenderPreference genderPref = new GenderPreference();
        genderPref.setGender(genders.get(random.nextInt(genders.size())));
        genderPref.setOrientation(orientations.get(random.nextInt(orientations.size())));
        genderPref.setTrans(random.nextBoolean());
        profile.setGenderPreference(genderPref);
        genderPreferenceRepository.save(genderPref);
    }

    private void initRelationshipPreference(UserProfile profile, Random random, List<RelationshipStatus> statuses, List<RelationshipPractice> practices, List<RelationshipInterest> interests) {
        if (statuses.isEmpty())
            return;

        RelationshipPreference relation = new RelationshipPreference();
        relation.setRelationshipStatus(statuses.get(random.nextInt(statuses.size())));

        if (!practices.isEmpty()) {
            relation.getRelationshipPractices().add(practices.get(random.nextInt(practices.size())));
        }

        if (!interests.isEmpty()) {
            relation.getRelationshipInterests().add(interests.get(random.nextInt(interests.size())));
        }

        profile.setRelationshipPreference(relation);
        relationshipPreferenceRepository.save(relation);
    }

    private void initReligionPreference(UserProfile profile, Random random, List<Religion> religions) {
        if (religions.isEmpty())
            return;

        ReligionPreference religionPref = new ReligionPreference();
        religionPref.setReligion(religions.get(random.nextInt(religions.size())));
        religionPref.setImportance(1 + random.nextInt(5));
        religionPref.setSameReligion(random.nextBoolean());
        profile.setReligionPreference(religionPref);
        religionPreferenceRepository.save(religionPref);
    }

    private void initEducationPreference(UserProfile profile, Random random, List<EducationDegree> degrees) {
        if (degrees.isEmpty())
            return;

        EducationPreference education = new EducationPreference();
        education.setHighestDegree(degrees.get(random.nextInt(degrees.size())));
        education.setConcentration(RandomStringUtils.randomAlphabetic(8, 12));
        education.setImportance(1 + random.nextInt(5));
        profile.setEducationPreference(education);
        educationPreferenceRepository.save(education);
    }

    private void initChildrenPreference(UserProfile profile, Random random, List<LifeStage> stages, List<ChildGender> genders, List<HouseholdStatus> statuses) {
        ChildrenPreference childrenPref = new ChildrenPreference();
        childrenPref.setMoreChildren(random.nextBoolean());

        if (random.nextBoolean()) {
            if (!stages.isEmpty() && !genders.isEmpty() && !statuses.isEmpty()) {
                Child child = new Child();
                child.setLifeStage(stages.get(random.nextInt(stages.size())));
                child.setGender(genders.get(random.nextInt(genders.size())));
                child.setInHousehold(statuses.get(random.nextInt(statuses.size())));
                childrenPref.addChild(child);
            }
        }

        profile.setChildrenPreference(childrenPref);
        childrenPreferenceRepository.save(childrenPref);
    }

    private void initLanguagePreference(UserProfile profile, Random random, List<FluencyLevel> levels) {
        LanguagePreference languagePref = new LanguagePreference();
        languagePref.setImportance(1 + random.nextInt(5));

        if (!levels.isEmpty()) {
            Language language = new Language();
            language.setName(RandomStringUtils.randomAlphabetic(6, 10));
            language.setFluency(levels.get(random.nextInt(levels.size())));
            languagePref.addLanguageSpoken(language);
        }

        profile.setLanguagePreference(languagePref);
        languagePreferenceRepository.save(languagePref);
    }

    private void initVicePreference(UserProfile profile, Random random, List<ViceType> types, List<ViceFrequency> frequencies) {
        VicePreference vicePref = new VicePreference();
        vicePref.setImportance(1 + random.nextInt(5));

        if (!types.isEmpty() && !frequencies.isEmpty()) {
            Vice vice = new Vice();
            vice.setViceType(types.get(random.nextInt(types.size())));
            vice.setFrequency(frequencies.get(random.nextInt(frequencies.size())));
            vicePref.addVice(vice);
        }

        profile.setVicePreference(vicePref);
        vicePreferenceRepository.save(vicePref);
    }

    private void initPetsPreference(UserProfile profile, Random random, List<PetType> types) {
        PetsPreference petsPref = new PetsPreference();
        petsPref.setImportance(1 + random.nextInt(5));

        if (!types.isEmpty()) {
            Pet pet = new Pet();
            pet.setPetType(types.get(random.nextInt(types.size())));
            pet.setQuantity(1 + random.nextInt(3));
            pet.setIsAllowed(random.nextBoolean());
            petsPref.addPet(pet);
        }

        profile.setPetsPreference(petsPref);
        petsPreferenceRepository.save(petsPref);
    }

    private void initTravelPreference(UserProfile profile, Random random, List<TravelFrequency> frequencies, List<TravelDuration> durations, List<TravelDistance> distances, List<TravelGroupSize> groupSizes) {
        if (frequencies.isEmpty() || durations.isEmpty() || distances.isEmpty() || groupSizes.isEmpty())
            return;

        TravelPreference travel = new TravelPreference();
        travel.setFrequency(frequencies.get(random.nextInt(frequencies.size())));
        travel.setDuration(durations.get(random.nextInt(durations.size())));
        travel.setDistance(distances.get(random.nextInt(distances.size())));
        travel.setGroupSize(groupSizes.get(random.nextInt(groupSizes.size())));
        travel.setImportance(1 + random.nextInt(5));

        profile.setTravelPreference(travel);
        travelPreferenceRepository.save(travel);
    }

    private void initDietPreference(UserProfile profile, Random random) {
        DietPreference diet = new DietPreference();
        diet.setImportance(1 + random.nextInt(5));
        diet.getRestrictions().add(DietaryRestriction.values()[random.nextInt(DietaryRestriction.values().length)]);

        profile.setDietPreference(diet);
        dietPreferenceRepository.save(diet);
    }

}
