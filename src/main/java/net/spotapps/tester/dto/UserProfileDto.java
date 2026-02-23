package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;
import net.spotapps.tester.model.UserProfile;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "images",
        "contactPreference",
        "locationPreference",
        "socialPersonality",
        "genderPreference",
        "relationshipPreference",
        "childrenPreference",
        "agePreference",
        "religionPreference",
        "educationPreference",
        "languagePreference",
        "vicePreference",
        "petsPreference",
        "travelPreference",
        "dietPreference",
        "interests"
})
public class UserProfileDto {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The unique identifier, shared with and derived from the associated User entity")
    private Long userId;

    @JsonProperty(required = true)
    @JsonPropertyDescription("List of references to images of the user")
    private List<UserImageDto> images;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The things and activities the user is interested in")
    private List<UserInterestDto> interests;

    @JsonProperty(value = "contactPreference", required = true)
    @JsonPropertyDescription("The user's contact preferences")
    @Valid
    private ContactPreferenceDto contactPreference;

    @JsonProperty(value = "locationPreference", required = true)
    @JsonPropertyDescription("The user's location preferences")
    @Valid
    private LocationPreferenceDto locationPreference;

    @JsonProperty(value = "socialPersonality", required = true)
    @JsonPropertyDescription("The user's social preferences")
    @Valid
    private SocialPersonalityDto socialPersonality;

    @JsonProperty(value = "genderPreference", required = true)
    @JsonPropertyDescription("The user's gender preferences")
    @Valid
    private GenderPreferenceDto genderPreference;

    @JsonProperty(value = "relationshipPreference", required = true)
    @JsonPropertyDescription("The user's relationship preferences")
    @Valid
    private RelationshipPreferenceDto relationshipPreference;

    @JsonProperty(value = "childrenPreference", required = true)
    @JsonPropertyDescription("The user's children preferences")
    @Valid
    private ChildrenPreferenceDto childrenPreference;

    @JsonProperty(value = "agePreference", required = true)
    @JsonPropertyDescription("The user's age preferences")
    @Valid
    private AgePreferenceDto agePreference;

    @JsonProperty(value = "religionPreference", required = true)
    @JsonPropertyDescription("The user's religion preferences")
    @Valid
    private ReligionPreferenceDto religionPreference;

    @JsonProperty(value = "educationPreference", required = true)
    @JsonPropertyDescription("The user's education preferences")
    @Valid
    private EducationPreferenceDto educationPreference;

    @JsonProperty(value = "languagePreference", required = true)
    @JsonPropertyDescription("The user's language preferences")
    @Valid
    private LanguagePreferenceDto languagePreference;

    @JsonProperty(value = "vicePreference", required = true)
    @JsonPropertyDescription("The user's vice preferences")
    @Valid
    private VicePreferenceDto vicePreference;

    @JsonProperty(value = "petsPreference", required = true)
    @JsonPropertyDescription("The user's pets preferences")
    @Valid
    private PetsPreferenceDto petsPreference;

    @JsonProperty(value = "travelPreference", required = true)
    @JsonPropertyDescription("The user's travel preferences")
    @Valid
    private TravelPreferenceDto travelPreference;

    @JsonProperty(value = "dietPreference", required = true)
    @JsonPropertyDescription("The user's diet preferences")
    @Valid
    private DietPreferenceDto dietPreference;

    public UserProfileDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UserImageDto> getImages() {
        return images;
    }

    public void setImages(List<UserImageDto> images) {
        this.images = images;
    }

    public List<UserInterestDto> getInterests() {
        return interests;
    }

    public void setInterests(List<UserInterestDto> interests) {
        this.interests = interests;
    }

    public ContactPreferenceDto getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(ContactPreferenceDto contactPreference) {
        this.contactPreference = contactPreference;
    }

    public LocationPreferenceDto getLocationPreference() {
        return locationPreference;
    }

    public void setLocationPreference(LocationPreferenceDto locationPreference) {
        this.locationPreference = locationPreference;
    }

    public SocialPersonalityDto getSocialPersonality() {
        return socialPersonality;
    }

    public void setSocialPersonality(SocialPersonalityDto socialPersonality) {
        this.socialPersonality = socialPersonality;
    }

    public GenderPreferenceDto getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(GenderPreferenceDto genderPreference) {
        this.genderPreference = genderPreference;
    }

    public RelationshipPreferenceDto getRelationshipPreference() {
        return relationshipPreference;
    }

    public void setRelationshipPreference(RelationshipPreferenceDto relationshipPreference) {
        this.relationshipPreference = relationshipPreference;
    }

    public ChildrenPreferenceDto getChildrenPreference() {
        return childrenPreference;
    }

    public void setChildrenPreference(ChildrenPreferenceDto childrenPreference) {
        this.childrenPreference = childrenPreference;
    }

    public AgePreferenceDto getAgePreference() {
        return agePreference;
    }

    public void setAgePreference(AgePreferenceDto agePreference) {
        this.agePreference = agePreference;
    }

    public ReligionPreferenceDto getReligionPreference() {
        return religionPreference;
    }

    public void setReligionPreference(ReligionPreferenceDto religionPreference) {
        this.religionPreference = religionPreference;
    }

    public EducationPreferenceDto getEducationPreference() {
        return educationPreference;
    }

    public void setEducationPreference(EducationPreferenceDto educationPreference) {
        this.educationPreference = educationPreference;
    }

    public LanguagePreferenceDto getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(LanguagePreferenceDto languagePreference) {
        this.languagePreference = languagePreference;
    }

    public VicePreferenceDto getVicePreference() {
        return vicePreference;
    }

    public void setVicePreference(VicePreferenceDto vicePreference) {
        this.vicePreference = vicePreference;
    }

    public PetsPreferenceDto getPetsPreference() {
        return petsPreference;
    }

    public void setPetsPreference(PetsPreferenceDto petsPreference) {
        this.petsPreference = petsPreference;
    }

    public TravelPreferenceDto getTravelPreference() {
        return travelPreference;
    }

    public void setTravelPreference(TravelPreferenceDto travelPreference) {
        this.travelPreference = travelPreference;
    }

    public DietPreferenceDto getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(DietPreferenceDto dietPreference) {
        this.dietPreference = dietPreference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactPreference, locationPreference, socialPersonality, genderPreference,
                relationshipPreference, childrenPreference, agePreference, religionPreference, educationPreference,
                languagePreference, vicePreference, petsPreference, travelPreference, dietPreference, images, interests,
                userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserProfileDto other = (UserProfileDto) obj;
        return Objects.equals(contactPreference, other.contactPreference)
                && Objects.equals(locationPreference, other.locationPreference)
                && Objects.equals(socialPersonality, other.socialPersonality)
                && Objects.equals(genderPreference, other.genderPreference)
                && Objects.equals(relationshipPreference, other.relationshipPreference)
                && Objects.equals(childrenPreference, other.childrenPreference)
                && Objects.equals(agePreference, other.agePreference)
                && Objects.equals(religionPreference, other.religionPreference)
                && Objects.equals(educationPreference, other.educationPreference)
                && Objects.equals(languagePreference, other.languagePreference)
                && Objects.equals(vicePreference, other.vicePreference)
                && Objects.equals(petsPreference, other.petsPreference)
                && Objects.equals(travelPreference, other.travelPreference)
                && Objects.equals(dietPreference, other.dietPreference) && Objects.equals(images, other.images)
                && Objects.equals(interests, other.interests) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "UserProfileDto [userId=" + userId + ", images=" + images + ", interests=" + interests
                + ", contactPreference=" + contactPreference + ", locationPreference=" + locationPreference
                + ", socialPersonality=" + socialPersonality + ", genderPreference=" + genderPreference
                + ", relationshipPreference=" + relationshipPreference + ", childrenPreference=" + childrenPreference
                + ", agePreference=" + agePreference + ", religionPreference=" + religionPreference
                + ", educationPreference=" + educationPreference + ", languagePreference=" + languagePreference
                + ", vicePreference=" + vicePreference + ", petsPreference=" + petsPreference + ", travelPreference="
                + travelPreference + ", dietPreference=" + dietPreference + "]";
    }

    public static UserProfileDto convertUserProfileToDto(final UserProfile userProfile) {

        UserProfileDto dto = new UserProfileDto();
        dto.setUserId(userProfile.getUserId());

        if (userProfile.getImages() != null) {
            dto.setImages(userProfile.getImages().stream()
                    .map(image -> {
                        UserImageDto imageDto = new UserImageDto();
                        imageDto.setImageId(image.getImageId());
                        imageDto.setImage(image.getImage());
                        return imageDto;
                    })
                    .toList());
        }

        if (userProfile.getInterests() != null) {
            dto.setInterests(userProfile.getInterests().stream()
                    .map(interest -> {
                        UserInterestDto interestDto = new UserInterestDto();
                        interestDto.setInterestId(interest.getInterestId());
                        interestDto.setInterest(interest.getInterest());
                        return interestDto;
                    })
                    .toList());
        }

        if (userProfile.getContactPreference() != null) {
            ContactPreferenceDto contactDto = new ContactPreferenceDto();
            contactDto.setFirstName(userProfile.getContactPreference().getFirstName());
            contactDto.setLastName(userProfile.getContactPreference().getLastName());
            contactDto.setPhoneNumber(userProfile.getContactPreference().getPhoneNumber());
            contactDto.setEmailAddress(userProfile.getContactPreference().getEmailAddress());
            dto.setContactPreference(contactDto);
        }

        if (userProfile.getLocationPreference() != null) {
            LocationPreferenceDto locDto = new LocationPreferenceDto();
            locDto.setUseLocal(userProfile.getLocationPreference().getUseLocal());
            locDto.setDistanceInMiles(userProfile.getLocationPreference().getDistanceInMiles());
            locDto.setDistanceInKilometers(userProfile.getLocationPreference().getDistanceInKilometers());
            dto.setLocationPreference(locDto);
        }

        if (userProfile.getSocialPersonality() != null) {
            SocialPersonalityDto spDto = new SocialPersonalityDto();
            if (userProfile.getSocialPersonality().getOpenness() != null)
                spDto.setOpenness(new PersonalityScaleDto(userProfile.getSocialPersonality().getOpenness().getPersonalityScaleId(), userProfile.getSocialPersonality().getOpenness().getName()));
            if (userProfile.getSocialPersonality().getConscientiousness() != null)
                spDto.setConscientiousness(new PersonalityScaleDto(userProfile.getSocialPersonality().getConscientiousness().getPersonalityScaleId(), userProfile.getSocialPersonality().getConscientiousness().getName()));
            if (userProfile.getSocialPersonality().getExtraversion() != null)
                spDto.setExtraversion(new PersonalityScaleDto(userProfile.getSocialPersonality().getExtraversion().getPersonalityScaleId(), userProfile.getSocialPersonality().getExtraversion().getName()));
            if (userProfile.getSocialPersonality().getAgreeableness() != null)
                spDto.setAgreeableness(new PersonalityScaleDto(userProfile.getSocialPersonality().getAgreeableness().getPersonalityScaleId(), userProfile.getSocialPersonality().getAgreeableness().getName()));
            if (userProfile.getSocialPersonality().getNeuroticism() != null)
                spDto.setNeuroticism(new PersonalityScaleDto(userProfile.getSocialPersonality().getNeuroticism().getPersonalityScaleId(), userProfile.getSocialPersonality().getNeuroticism().getName()));
            dto.setSocialPersonality(spDto);
        }

        if (userProfile.getGenderPreference() != null) {
            GenderPreferenceDto gpDto = new GenderPreferenceDto();
            if (userProfile.getGenderPreference().getGender() != null)
                gpDto.setGender(new GenderDto(userProfile.getGenderPreference().getGender().getGenderId(), userProfile.getGenderPreference().getGender().getName()));
            gpDto.setTrans(userProfile.getGenderPreference().getTrans());
            if (userProfile.getGenderPreference().getOrientation() != null)
                gpDto.setOrientation(new OrientationDto(userProfile.getGenderPreference().getOrientation().getOrientationId(), userProfile.getGenderPreference().getOrientation().getName()));
            dto.setGenderPreference(gpDto);
        }

        if (userProfile.getRelationshipPreference() != null) {
            RelationshipPreferenceDto rpDto = new RelationshipPreferenceDto();
            if (userProfile.getRelationshipPreference().getRelationshipStatus() != null)
                rpDto.setRelationshipStatus(new RelationshipStatusDto(userProfile.getRelationshipPreference().getRelationshipStatus().getRelationshipStatusId(), userProfile.getRelationshipPreference().getRelationshipStatus().getName()));
            if (userProfile.getRelationshipPreference().getRelationshipPractices() != null)
                rpDto.setRelationshipPractices(userProfile.getRelationshipPreference().getRelationshipPractices().stream().map(p -> new RelationshipPracticeDto(p.getRelationshipPracticeId(), p.getName())).collect(Collectors.toSet()));
            if (userProfile.getRelationshipPreference().getRelationshipInterests() != null)
                rpDto.setRelationshipInterests(userProfile.getRelationshipPreference().getRelationshipInterests().stream().map(i -> new RelationshipInterestDto(i.getRelationshipInterestId(), i.getName())).collect(Collectors.toSet()));
            dto.setRelationshipPreference(rpDto);
        }

        if (userProfile.getChildrenPreference() != null) {
            ChildrenPreferenceDto cpDto = new ChildrenPreferenceDto();
            cpDto.setMoreChildren(userProfile.getChildrenPreference().getMoreChildren());
            if (userProfile.getChildrenPreference().getChildren() != null) {
                cpDto.setChildren(userProfile.getChildrenPreference().getChildren().stream().map(c -> {
                    ChildDto cDto = new ChildDto();
                    cDto.setChildId(c.getChildId());
                    if (c.getLifeStage() != null) cDto.setLifeStage(new LifeStageDto(c.getLifeStage().getLifeStageId(), c.getLifeStage().getName()));
                    if (c.getGender() != null) cDto.setGender(new ChildGenderDto(c.getGender().getChildGenderId(), c.getGender().getName()));
                    if (c.getInHousehold() != null) cDto.setInHousehold(new HouseholdStatusDto(c.getInHousehold().getHouseholdStatusId(), c.getInHousehold().getName()));
                    return cDto;
                }).toList());
            }
            dto.setChildrenPreference(cpDto);
        }

        if (userProfile.getAgePreference() != null) {
            AgePreferenceDto apDto = new AgePreferenceDto();
            apDto.setDay(userProfile.getAgePreference().getDay());
            apDto.setMonth(userProfile.getAgePreference().getMonth());
            apDto.setYear(userProfile.getAgePreference().getYear());
            apDto.setMinAge(userProfile.getAgePreference().getMinAge());
            apDto.setMaxAge(userProfile.getAgePreference().getMaxAge());
            dto.setAgePreference(apDto);
        }

        if (userProfile.getReligionPreference() != null) {
            ReligionPreferenceDto relDto = new ReligionPreferenceDto();
            if (userProfile.getReligionPreference().getReligion() != null) {
                ReligionDto rDto = new ReligionDto();
                rDto.setReligionId(userProfile.getReligionPreference().getReligion().getReligionId());
                rDto.setReligionName(userProfile.getReligionPreference().getReligion().getReligionName());
                rDto.setBranchName(userProfile.getReligionPreference().getReligion().getBranchName());
                relDto.setReligion(rDto);
            }
            relDto.setImportance(userProfile.getReligionPreference().getImportance());
            relDto.setSameReligion(userProfile.getReligionPreference().getSameReligion());
            dto.setReligionPreference(relDto);
        }

        if (userProfile.getEducationPreference() != null) {
            EducationPreferenceDto epDto = new EducationPreferenceDto();
            if (userProfile.getEducationPreference().getHighestDegree() != null)
                epDto.setHighestDegree(new EducationDegreeDto(userProfile.getEducationPreference().getHighestDegree().getEducationDegreeId(), userProfile.getEducationPreference().getHighestDegree().getName()));
            epDto.setConcentration(userProfile.getEducationPreference().getConcentration());
            epDto.setImportance(userProfile.getEducationPreference().getImportance());
            dto.setEducationPreference(epDto);
        }

        if (userProfile.getLanguagePreference() != null) {
            LanguagePreferenceDto lpDto = new LanguagePreferenceDto();
            if (userProfile.getLanguagePreference().getLanguagesSpoken() != null) {
                lpDto.setLanguagesSpoken(userProfile.getLanguagePreference().getLanguagesSpoken().stream().map(l -> {
                    LanguageDto lDto = new LanguageDto();
                    lDto.setLanguageId(l.getLanguageId());
                    lDto.setName(l.getName());
                    if (l.getFluency() != null) lDto.setFluency(new FluencyLevelDto(l.getFluency().getFluencyLevelId(), l.getFluency().getName()));
                    return lDto;
                }).toList());
            }
            lpDto.setImportance(userProfile.getLanguagePreference().getImportance());
            dto.setLanguagePreference(lpDto);
        }

        if (userProfile.getVicePreference() != null) {
            VicePreferenceDto vpDto = new VicePreferenceDto();
            if (userProfile.getVicePreference().getVices() != null) {
                vpDto.setVices(userProfile.getVicePreference().getVices().stream().map(v -> {
                    ViceDto vDto = new ViceDto();
                    vDto.setViceId(v.getViceId());
                    if (v.getViceType() != null) vDto.setViceType(new ViceTypeDto(v.getViceType().getViceTypeId(), v.getViceType().getName()));
                    if (v.getFrequency() != null) vDto.setFrequency(new ViceFrequencyDto(v.getFrequency().getViceFrequencyId(), v.getFrequency().getName()));
                    return vDto;
                }).toList());
            }
            vpDto.setImportance(userProfile.getVicePreference().getImportance());
            dto.setVicePreference(vpDto);
        }

        if (userProfile.getPetsPreference() != null) {
            PetsPreferenceDto ppDto = new PetsPreferenceDto();
            if (userProfile.getPetsPreference().getPets() != null) {
                ppDto.setPets(userProfile.getPetsPreference().getPets().stream().map(p -> {
                    PetDto pDto = new PetDto();
                    pDto.setPetId(p.getPetId());
                    if (p.getPetType() != null) pDto.setPetType(new PetTypeDto(p.getPetType().getPetTypeId(), p.getPetType().getName()));
                    pDto.setQuantity(p.getQuantity());
                    pDto.setIsAllowed(p.getIsAllowed());
                    return pDto;
                }).toList());
            }
            ppDto.setImportance(userProfile.getPetsPreference().getImportance());
            dto.setPetsPreference(ppDto);
        }

        if (userProfile.getTravelPreference() != null) {
            TravelPreferenceDto tpDto = new TravelPreferenceDto();
            if (userProfile.getTravelPreference().getFrequency() != null)
                tpDto.setFrequency(new TravelFrequencyDto(userProfile.getTravelPreference().getFrequency().getTravelFrequencyId(), userProfile.getTravelPreference().getFrequency().getName()));
            if (userProfile.getTravelPreference().getDuration() != null)
                tpDto.setDuration(new TravelDurationDto(userProfile.getTravelPreference().getDuration().getTravelDurationId(), userProfile.getTravelPreference().getDuration().getName()));
            if (userProfile.getTravelPreference().getDistance() != null)
                tpDto.setDistance(new TravelDistanceDto(userProfile.getTravelPreference().getDistance().getTravelDistanceId(), userProfile.getTravelPreference().getDistance().getName()));
            if (userProfile.getTravelPreference().getGroupSize() != null)
                tpDto.setGroupSize(new TravelGroupSizeDto(userProfile.getTravelPreference().getGroupSize().getTravelGroupSizeId(), userProfile.getTravelPreference().getGroupSize().getName()));
            tpDto.setImportance(userProfile.getTravelPreference().getImportance());
            dto.setTravelPreference(tpDto);
        }

        if (userProfile.getDietPreference() != null) {
            DietPreferenceDto dpDto = new DietPreferenceDto();
            dpDto.setRestrictions(userProfile.getDietPreference().getRestrictions());
            dpDto.setImportance(userProfile.getDietPreference().getImportance());
            dto.setDietPreference(dpDto);
        }

        return dto;
    }

}
