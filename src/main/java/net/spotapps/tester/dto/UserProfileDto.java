package net.spotapps.tester.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Represents a user's complete profile, including all preferences and interests.")
public class UserProfileDto {

    @JsonProperty(required = true)
    @Schema(description = "The unique identifier, shared with and derived from the associated User entity", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long userId;

    @JsonProperty(required = true)
    @Schema(description = "List of references to images of the user", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<UserImageDto> images;

    @JsonProperty(required = true)
    @Schema(description = "The things and activities the user is interested in", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<UserInterestDto> interests;

    @JsonProperty(value = "contactPreference", required = true)
    @Schema(description = "The user's contact preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ContactPreferenceDto contactPreference;

    @JsonProperty(value = "locationPreference", required = true)
    @Schema(description = "The user's location preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private LocationPreferenceDto locationPreference;

    @JsonProperty(value = "socialPersonality", required = true)
    @Schema(description = "The user's social personality attributes", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private SocialPersonalityDto socialPersonality;

    @JsonProperty(value = "genderPreference", required = true)
    @Schema(description = "The user's gender preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private GenderPreferenceDto genderPreference;

    @JsonProperty(value = "relationshipPreference", required = true)
    @Schema(description = "The user's relationship preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private RelationshipPreferenceDto relationshipPreference;

    @JsonProperty(value = "childrenPreference", required = true)
    @Schema(description = "The user's children preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ChildrenPreferenceDto childrenPreference;

    @JsonProperty(value = "agePreference", required = true)
    @Schema(description = "The user's age preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private AgePreferenceDto agePreference;

    @JsonProperty(value = "religionPreference", required = true)
    @Schema(description = "The user's religion preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private ReligionPreferenceDto religionPreference;

    @JsonProperty(value = "educationPreference", required = true)
    @Schema(description = "The user's education preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private EducationPreferenceDto educationPreference;

    @JsonProperty(value = "languagePreference", required = true)
    @Schema(description = "The user's language preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private LanguagePreferenceDto languagePreference;

    @JsonProperty(value = "vicePreference", required = true)
    @Schema(description = "The user's vice preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private VicePreferenceDto vicePreference;

    @JsonProperty(value = "petsPreference", required = true)
    @Schema(description = "The user's pets preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private PetsPreferenceDto petsPreference;

    @JsonProperty(value = "travelPreference", required = true)
    @Schema(description = "The user's travel preferences", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    private TravelPreferenceDto travelPreference;

    @JsonProperty(value = "dietPreference", required = true)
    @Schema(description = "The user's diet preferences", requiredMode = Schema.RequiredMode.REQUIRED)
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

        dto.setImages(mapImages(userProfile));
        dto.setInterests(mapInterests(userProfile));
        dto.setContactPreference(mapContactPreference(userProfile.getContactPreference()));
        dto.setLocationPreference(mapLocationPreference(userProfile.getLocationPreference()));
        dto.setSocialPersonality(mapSocialPersonality(userProfile.getSocialPersonality()));
        dto.setGenderPreference(mapGenderPreference(userProfile.getGenderPreference()));
        dto.setRelationshipPreference(mapRelationshipPreference(userProfile.getRelationshipPreference()));
        dto.setChildrenPreference(mapChildrenPreference(userProfile.getChildrenPreference()));
        dto.setAgePreference(mapAgePreference(userProfile.getAgePreference()));
        dto.setReligionPreference(mapReligionPreference(userProfile.getReligionPreference()));
        dto.setEducationPreference(mapEducationPreference(userProfile.getEducationPreference()));
        dto.setLanguagePreference(mapLanguagePreference(userProfile.getLanguagePreference()));
        dto.setVicePreference(mapVicePreference(userProfile.getVicePreference()));
        dto.setPetsPreference(mapPetsPreference(userProfile.getPetsPreference()));
        dto.setTravelPreference(mapTravelPreference(userProfile.getTravelPreference()));
        dto.setDietPreference(mapDietPreference(userProfile.getDietPreference()));

        return dto;
    }

    private static List<UserImageDto> mapImages(UserProfile userProfile) {
        if (userProfile.getImages() == null)
            return java.util.Collections.emptyList();
        return userProfile.getImages().stream()
                .map(image -> {
                    UserImageDto imageDto = new UserImageDto();
                    imageDto.setImageId(image.getImageId());
                    imageDto.setImage(image.getImage());
                    return imageDto;
                })
                .toList();
    }

    private static List<UserInterestDto> mapInterests(UserProfile userProfile) {
        if (userProfile.getInterests() == null)
            return java.util.Collections.emptyList();
        return userProfile.getInterests().stream()
                .map(interest -> {
                    UserInterestDto interestDto = new UserInterestDto();
                    interestDto.setInterestId(interest.getInterestId());
                    interestDto.setInterest(interest.getInterest());
                    return interestDto;
                })
                .toList();
    }

    private static ContactPreferenceDto mapContactPreference(net.spotapps.tester.model.ContactPreference cp) {
        if (cp == null)
            return new ContactPreferenceDto();
        ContactPreferenceDto dto = new ContactPreferenceDto();
        dto.setFirstName(cp.getFirstName());
        dto.setLastName(cp.getLastName());
        dto.setPhoneNumber(cp.getPhoneNumber());
        dto.setEmailAddress(cp.getEmailAddress());
        return dto;
    }

    private static LocationPreferenceDto mapLocationPreference(net.spotapps.tester.model.LocationPreference lp) {
        if (lp == null)
            return new LocationPreferenceDto();
        LocationPreferenceDto dto = new LocationPreferenceDto();
        dto.setUseLocal(lp.getUseLocal());
        dto.setDistanceInMiles(lp.getDistanceInMiles());
        dto.setDistanceInKilometers(lp.getDistanceInKilometers());
        return dto;
    }

    private static SocialPersonalityDto mapSocialPersonality(net.spotapps.tester.model.SocialPersonality sp) {
        if (sp == null)
            return new SocialPersonalityDto();
        SocialPersonalityDto dto = new SocialPersonalityDto();
        dto.setOpenness(toDto(sp.getOpenness()));
        dto.setConscientiousness(toDto(sp.getConscientiousness()));
        dto.setExtraversion(toDto(sp.getExtraversion()));
        dto.setAgreeableness(toDto(sp.getAgreeableness()));
        dto.setNeuroticism(toDto(sp.getNeuroticism()));
        return dto;
    }

    private static PersonalityScaleDto toDto(net.spotapps.tester.model.PersonalityScale ps) {
        if (ps == null)
            return null;
        return new PersonalityScaleDto(ps.getPersonalityScaleId(), ps.getName());
    }

    private static GenderPreferenceDto mapGenderPreference(net.spotapps.tester.model.GenderPreference gp) {
        if (gp == null)
            return new GenderPreferenceDto();
        GenderPreferenceDto dto = new GenderPreferenceDto();
        if (gp.getGender() != null)
            dto.setGender(new GenderDto(gp.getGender().getGenderId(), gp.getGender().getName()));
        dto.setTrans(gp.getTrans());
        if (gp.getOrientation() != null)
            dto.setOrientation(
                    new OrientationDto(gp.getOrientation().getOrientationId(), gp.getOrientation().getName()));
        return dto;
    }

    private static RelationshipPreferenceDto mapRelationshipPreference(
            net.spotapps.tester.model.RelationshipPreference rp) {
        if (rp == null)
            return new RelationshipPreferenceDto();
        RelationshipPreferenceDto dto = new RelationshipPreferenceDto();
        if (rp.getRelationshipStatus() != null)
            dto.setRelationshipStatus(new RelationshipStatusDto(rp.getRelationshipStatus().getRelationshipStatusId(),
                    rp.getRelationshipStatus().getName()));
        if (rp.getRelationshipPractices() != null)
            dto.setRelationshipPractices(rp.getRelationshipPractices().stream()
                    .map(p -> new RelationshipPracticeDto(p.getRelationshipPracticeId(), p.getName()))
                    .collect(Collectors.toSet()));
        if (rp.getRelationshipInterests() != null)
            dto.setRelationshipInterests(rp.getRelationshipInterests().stream()
                    .map(i -> new RelationshipInterestDto(i.getRelationshipInterestId(), i.getName()))
                    .collect(Collectors.toSet()));
        return dto;
    }

    private static ChildrenPreferenceDto mapChildrenPreference(net.spotapps.tester.model.ChildrenPreference cp) {
        if (cp == null)
            return new ChildrenPreferenceDto();
        ChildrenPreferenceDto dto = new ChildrenPreferenceDto();
        dto.setMoreChildren(cp.getMoreChildren());
        if (cp.getChildren() != null) {
            dto.setChildren(cp.getChildren().stream().map(c -> {
                ChildDto childDto = new ChildDto();
                childDto.setChildId(c.getChildId());
                if (c.getLifeStage() != null)
                    childDto.setLifeStage(
                            new LifeStageDto(c.getLifeStage().getLifeStageId(), c.getLifeStage().getName()));
                if (c.getGender() != null)
                    childDto.setGender(new ChildGenderDto(c.getGender().getChildGenderId(), c.getGender().getName()));
                if (c.getInHousehold() != null)
                    childDto.setInHousehold(new HouseholdStatusDto(c.getInHousehold().getHouseholdStatusId(),
                            c.getInHousehold().getName()));
                return childDto;
            }).toList());
        }
        return dto;
    }

    private static AgePreferenceDto mapAgePreference(net.spotapps.tester.model.AgePreference ap) {
        if (ap == null)
            return new AgePreferenceDto();
        AgePreferenceDto dto = new AgePreferenceDto();
        dto.setDay(ap.getDay());
        dto.setMonth(ap.getMonth());
        dto.setYear(ap.getYear());
        dto.setMinAge(ap.getMinAge());
        dto.setMaxAge(ap.getMaxAge());
        return dto;
    }

    private static ReligionPreferenceDto mapReligionPreference(net.spotapps.tester.model.ReligionPreference rp) {
        if (rp == null)
            return new ReligionPreferenceDto();
        ReligionPreferenceDto dto = new ReligionPreferenceDto();
        if (rp.getReligion() != null) {
            ReligionDto rDto = new ReligionDto();
            rDto.setReligionId(rp.getReligion().getReligionId());
            rDto.setReligionName(rp.getReligion().getReligionName());
            rDto.setBranchName(rp.getReligion().getBranchName());
            dto.setReligion(rDto);
        }
        dto.setImportance(rp.getImportance());
        dto.setSameReligion(rp.getSameReligion());
        return dto;
    }

    private static EducationPreferenceDto mapEducationPreference(net.spotapps.tester.model.EducationPreference ep) {
        if (ep == null)
            return new EducationPreferenceDto();
        EducationPreferenceDto dto = new EducationPreferenceDto();
        if (ep.getHighestDegree() != null)
            dto.setHighestDegree(new EducationDegreeDto(ep.getHighestDegree().getEducationDegreeId(),
                    ep.getHighestDegree().getName()));
        dto.setConcentration(ep.getConcentration());
        dto.setImportance(ep.getImportance());
        return dto;
    }

    private static LanguagePreferenceDto mapLanguagePreference(net.spotapps.tester.model.LanguagePreference lp) {
        if (lp == null)
            return new LanguagePreferenceDto();
        LanguagePreferenceDto dto = new LanguagePreferenceDto();
        if (lp.getLanguagesSpoken() != null) {
            dto.setLanguagesSpoken(lp.getLanguagesSpoken().stream().map(l -> {
                LanguageDto lDto = new LanguageDto();
                lDto.setLanguageId(l.getLanguageId());
                lDto.setName(l.getName());
                if (l.getFluency() != null)
                    lDto.setFluency(new FluencyLevelDto(l.getFluency().getFluencyLevelId(), l.getFluency().getName()));
                return lDto;
            }).toList());
        }
        dto.setImportance(lp.getImportance());
        return dto;
    }

    private static VicePreferenceDto mapVicePreference(net.spotapps.tester.model.VicePreference vp) {
        if (vp == null)
            return new VicePreferenceDto();
        VicePreferenceDto dto = new VicePreferenceDto();
        if (vp.getVices() != null) {
            dto.setVices(vp.getVices().stream().map(v -> {
                ViceDto vDto = new ViceDto();
                vDto.setViceId(v.getViceId());
                if (v.getViceType() != null)
                    vDto.setViceType(new ViceTypeDto(v.getViceType().getViceTypeId(), v.getViceType().getName()));
                if (v.getFrequency() != null)
                    vDto.setFrequency(
                            new ViceFrequencyDto(v.getFrequency().getViceFrequencyId(), v.getFrequency().getName()));
                return vDto;
            }).toList());
        }
        dto.setImportance(vp.getImportance());
        return dto;
    }

    private static PetsPreferenceDto mapPetsPreference(net.spotapps.tester.model.PetsPreference pp) {
        if (pp == null)
            return new PetsPreferenceDto();
        PetsPreferenceDto dto = new PetsPreferenceDto();
        if (pp.getPets() != null) {
            dto.setPets(pp.getPets().stream().map(p -> {
                PetDto pDto = new PetDto();
                pDto.setPetId(p.getPetId());
                if (p.getPetType() != null)
                    pDto.setPetType(new PetTypeDto(p.getPetType().getPetTypeId(), p.getPetType().getName()));
                pDto.setQuantity(p.getQuantity());
                return pDto;
            }).toList());
        }
        dto.setImportance(pp.getImportance());
        dto.setIsAllowed(pp.getIsAllowed());
        return dto;
    }

    private static TravelPreferenceDto mapTravelPreference(net.spotapps.tester.model.TravelPreference tp) {
        if (tp == null)
            return new TravelPreferenceDto();
        TravelPreferenceDto dto = new TravelPreferenceDto();
        if (tp.getFrequency() != null)
            dto.setFrequency(
                    new TravelFrequencyDto(tp.getFrequency().getTravelFrequencyId(), tp.getFrequency().getName()));
        if (tp.getDuration() != null)
            dto.setDuration(new TravelDurationDto(tp.getDuration().getTravelDurationId(), tp.getDuration().getName()));
        if (tp.getDistance() != null)
            dto.setDistance(new TravelDistanceDto(tp.getDistance().getTravelDistanceId(), tp.getDistance().getName()));
        if (tp.getGroupSize() != null)
            dto.setGroupSize(
                    new TravelGroupSizeDto(tp.getGroupSize().getTravelGroupSizeId(), tp.getGroupSize().getName()));
        dto.setImportance(tp.getImportance());
        return dto;
    }

    private static DietPreferenceDto mapDietPreference(net.spotapps.tester.model.DietPreference dp) {
        if (dp == null)
            return new DietPreferenceDto();
        DietPreferenceDto dto = new DietPreferenceDto();
        if (dp.getRestrictions() != null) {
            dto.setRestrictions(new HashSet<>(dp.getRestrictions()));
        }
        dto.setImportance(dp.getImportance());
        return dto;
    }

}
