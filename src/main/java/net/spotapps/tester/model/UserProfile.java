package net.spotapps.tester.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user_profiles")
@NamedEntityGraph(name = "UserProfile.withAssociations", attributeNodes = {
        @NamedAttributeNode("images"),
        @NamedAttributeNode("interests"),
        @NamedAttributeNode("contactPreference"),
        @NamedAttributeNode("locationPreference"),
        @NamedAttributeNode("agePreference"),
        @NamedAttributeNode(value = "socialPersonality", subgraph = "social-subgraph"),
        @NamedAttributeNode(value = "genderPreference", subgraph = "gender-subgraph"),
        @NamedAttributeNode(value = "relationshipPreference", subgraph = "relationship-subgraph"),
        @NamedAttributeNode(value = "childrenPreference", subgraph = "children-subgraph"),
        @NamedAttributeNode(value = "religionPreference", subgraph = "religion-subgraph"),
        @NamedAttributeNode(value = "educationPreference", subgraph = "education-subgraph"),
        @NamedAttributeNode(value = "vicePreference", subgraph = "vice-subgraph"),
        @NamedAttributeNode(value = "petsPreference", subgraph = "pets-subgraph"),
        @NamedAttributeNode(value = "travelPreference", subgraph = "travel-subgraph")
}, subgraphs = {
        @NamedSubgraph(name = "gender-subgraph", attributeNodes = {
                @NamedAttributeNode("gender"),
                @NamedAttributeNode("orientation")
        }),
        @NamedSubgraph(name = "social-subgraph", attributeNodes = {
                @NamedAttributeNode("openness"),
                @NamedAttributeNode("conscientiousness"),
                @NamedAttributeNode("extraversion"),
                @NamedAttributeNode("agreeableness"),
                @NamedAttributeNode("neuroticism")
        }),
        @NamedSubgraph(name = "relationship-subgraph", attributeNodes = {
                @NamedAttributeNode("relationshipStatus"),
                @NamedAttributeNode("relationshipPractices"),
                @NamedAttributeNode("relationshipInterests")
        }),
        @NamedSubgraph(name = "children-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "children", subgraph = "child-details-subgraph")
        }),
        @NamedSubgraph(name = "child-details-subgraph", attributeNodes = {
                @NamedAttributeNode("lifeStage"),
                @NamedAttributeNode("gender"),
                @NamedAttributeNode("inHousehold")
        }),
        @NamedSubgraph(name = "religion-subgraph", attributeNodes = {
                @NamedAttributeNode("religion")
        }),
        @NamedSubgraph(name = "education-subgraph", attributeNodes = {
                @NamedAttributeNode("highestDegree")
        }),
        @NamedSubgraph(name = "vice-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "vices", subgraph = "vice-details-subgraph")
        }),
        @NamedSubgraph(name = "vice-details-subgraph", attributeNodes = {
                @NamedAttributeNode("viceType"),
                @NamedAttributeNode("frequency")
        }),
        @NamedSubgraph(name = "pets-subgraph", attributeNodes = {
                @NamedAttributeNode(value = "pets", subgraph = "pet-details-subgraph")
        }),
        @NamedSubgraph(name = "pet-details-subgraph", attributeNodes = {
                @NamedAttributeNode("petType")
        }),
        @NamedSubgraph(name = "travel-subgraph", attributeNodes = {
                @NamedAttributeNode("frequency"),
                @NamedAttributeNode("duration"),
                @NamedAttributeNode("distance"),
                @NamedAttributeNode("groupSize")
        })
})
public class UserProfile {

    @Id
    @Schema(description = "The unique identifier, shared with and derived from the associated User entity")
    @Column(name = "user_id")
    private Long userId;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Schema(description = "List of references to images of the user")
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("imageId ASC")
    private Set<UserImage> images = new LinkedHashSet<>();

    @Schema(description = "The contact information and preferences of the user")
    @JsonPropertyDescription("The contact information and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ContactPreference contactPreference;

    @Schema(description = "The location and proximity preferences of the user")
    @JsonPropertyDescription("The location and proximity preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private LocationPreference locationPreference;

    @Schema(description = "The socializing personality traits of the user")
    @JsonPropertyDescription("The socializing personality traits of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private SocialPersonality socialPersonality;

    @Schema(description = "The gender identity and preferences of the user")
    @JsonPropertyDescription("The gender identity and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private GenderPreference genderPreference;

    @Schema(description = "The relationship status and style preferences of the user")
    @JsonPropertyDescription("The relationship status and style preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private RelationshipPreference relationshipPreference;

    @Schema(description = "The child having status and preferences of the user")
    @JsonPropertyDescription("The child having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ChildrenPreference childrenPreference;

    @Schema(description = "The age and ranged preferences of the user")
    @JsonPropertyDescription("The age and ranged preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private AgePreference agePreference;

    @Schema(description = "The religious practice and preferences of the user")
    @JsonPropertyDescription("The religious practice and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ReligionPreference religionPreference;

    @Schema(description = "The education status and preferences of the user")
    @JsonPropertyDescription("The education status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private EducationPreference educationPreference;

    @Schema(description = "The language speaking status and preferences of the user")
    @JsonPropertyDescription("The language speaking status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private LanguagePreference languagePreference;

    @Schema(description = "The extracurricular partakings and preferences of the user")
    @JsonPropertyDescription("The extracurricular partakings and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private VicePreference vicePreference;

    @Schema(description = "The pet having status and preferences of the user")
    @JsonPropertyDescription("The pet having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private PetsPreference petsPreference;

    @Schema(description = "The preferences of the user regarding the dynamics centered around travel")
    @JsonPropertyDescription("The preferences of the user regarding the dynamics centered around travel")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private TravelPreference travelPreference;

    @Schema(description = "The dietary restrictions and preferences of the user")
    @JsonPropertyDescription("The dietary restrictions and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private DietPreference dietPreference;

    @Schema(description = "The things and activities the user is interested in")
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("interestId ASC")
    private Set<UserInterest> interests = new LinkedHashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<UserImage> getImages() {
        return images;
    }

    public void setImages(Set<UserImage> images) {
        if (this.images == null) {
            this.images = new LinkedHashSet<>();
        }
        this.images.clear();
        if (images != null) {
            this.images.addAll(images);
        }
    }

    public ContactPreference getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(ContactPreference contactPreference) {
        this.contactPreference = contactPreference;
    }

    public LocationPreference getLocationPreference() {
        return locationPreference;
    }

    public void setLocationPreference(LocationPreference locationPreference) {
        this.locationPreference = locationPreference;
    }

    public SocialPersonality getSocialPersonality() {
        return socialPersonality;
    }

    public void setSocialPersonality(SocialPersonality socialPersonality) {
        this.socialPersonality = socialPersonality;
    }

    public GenderPreference getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(GenderPreference genderPreference) {
        this.genderPreference = genderPreference;
    }

    public RelationshipPreference getRelationshipPreference() {
        return relationshipPreference;
    }

    public void setRelationshipPreference(RelationshipPreference relationshipPreference) {
        this.relationshipPreference = relationshipPreference;
    }

    public ChildrenPreference getChildrenPreference() {
        return childrenPreference;
    }

    public void setChildrenPreference(ChildrenPreference childrenPreference) {
        this.childrenPreference = childrenPreference;
    }

    public AgePreference getAgePreference() {
        return agePreference;
    }

    public void setAgePreference(AgePreference agePreference) {
        this.agePreference = agePreference;
    }

    public ReligionPreference getReligionPreference() {
        return religionPreference;
    }

    public void setReligionPreference(ReligionPreference religionPreference) {
        this.religionPreference = religionPreference;
    }

    public EducationPreference getEducationPreference() {
        return educationPreference;
    }

    public void setEducationPreference(EducationPreference educationPreference) {
        this.educationPreference = educationPreference;
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(LanguagePreference languagePreference) {
        this.languagePreference = languagePreference;
    }

    public VicePreference getVicePreference() {
        return vicePreference;
    }

    public void setVicePreference(VicePreference vicePreference) {
        this.vicePreference = vicePreference;
    }

    public PetsPreference getPetsPreference() {
        return petsPreference;
    }

    public void setPetsPreference(PetsPreference petsPreference) {
        this.petsPreference = petsPreference;
    }

    public TravelPreference getTravelPreference() {
        return travelPreference;
    }

    public void setTravelPreference(TravelPreference travelPreference) {
        this.travelPreference = travelPreference;
    }

    public DietPreference getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(DietPreference dietPreference) {
        this.dietPreference = dietPreference;
    }

    public Set<UserInterest> getInterests() {
        return interests;
    }

    public void setInterests(Set<UserInterest> interests) {
        if (this.interests == null) {
            this.interests = new LinkedHashSet<>();
        }
        this.interests.clear();
        if (interests != null) {
            this.interests.addAll(interests);
        }
    }

    @Override
    public int hashCode() {
        if (userId != null) {
            return Objects.hash(userId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserProfile [userId=" + userId + "]";
    }

}
