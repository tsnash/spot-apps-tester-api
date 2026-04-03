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
    @Column(name = "user_id")
    private Long userId;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("imageId ASC")
    private Set<UserImage> images = new LinkedHashSet<>();

    @JsonPropertyDescription("The contact information and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ContactPreference contactPreference;

    @JsonPropertyDescription("The location and proximity preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private LocationPreference locationPreference;

    @JsonPropertyDescription("The socializing personality traits of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private SocialPersonality socialPersonality;

    @JsonPropertyDescription("The gender identity and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private GenderPreference genderPreference;

    @JsonPropertyDescription("The relationship status and style preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private RelationshipPreference relationshipPreference;

    @JsonPropertyDescription("The child having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ChildrenPreference childrenPreference;

    @JsonPropertyDescription("The age and ranged preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private AgePreference agePreference;

    @JsonPropertyDescription("The religious practice and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private ReligionPreference religionPreference;

    @JsonPropertyDescription("The education status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private EducationPreference educationPreference;

    @JsonPropertyDescription("The language speaking status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private LanguagePreference languagePreference;

    @JsonPropertyDescription("The extracurricular partakings and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private VicePreference vicePreference;

    @JsonPropertyDescription("The pet having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private PetsPreference petsPreference;

    @JsonPropertyDescription("The preferences of the user regarding the dynamics centered around travel")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private TravelPreference travelPreference;

    @JsonPropertyDescription("The dietary restrictions and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private DietPreference dietPreference;

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
        this.images.forEach(image -> image.setUserProfile(null));
        this.images.clear();
        for (UserImage image : images) {
            image.setUserProfile(this);
            this.images.add(image);
        }
    }

    public void addImage(UserImage image) {
        if (image != null) {
            this.images.add(image);
            image.setUserProfile(this);
        }
    }

    public void removeImage(UserImage image) {
        if (image != null) {
            this.images.remove(image);
            image.setUserProfile(null);
        }
    }

    public ContactPreference getContactPreference() {
        return contactPreference;
    }

    public void setContactPreference(ContactPreference contactPreference) {
        if (this.contactPreference != null && this.contactPreference != contactPreference) {
            this.contactPreference.setUserProfile(null);
        }
        this.contactPreference = contactPreference;
        if (contactPreference != null && contactPreference.getUserProfile() != this) {
            contactPreference.setUserProfile(this);
        }
    }

    public LocationPreference getLocationPreference() {
        return locationPreference;
    }

    public void setLocationPreference(LocationPreference locationPreference) {
        if (this.locationPreference != null && this.locationPreference != locationPreference) {
            this.locationPreference.setUserProfile(null);
        }
        this.locationPreference = locationPreference;
        if (locationPreference != null && locationPreference.getUserProfile() != this) {
            locationPreference.setUserProfile(this);
        }
    }

    public SocialPersonality getSocialPersonality() {
        return socialPersonality;
    }

    public void setSocialPersonality(SocialPersonality socialPersonality) {
        if (this.socialPersonality != null && this.socialPersonality != socialPersonality) {
            this.socialPersonality.setUserProfile(null);
        }
        this.socialPersonality = socialPersonality;
        if (socialPersonality != null && socialPersonality.getUserProfile() != this) {
            socialPersonality.setUserProfile(this);
        }
    }

    public GenderPreference getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(GenderPreference genderPreference) {
        if (this.genderPreference != null && this.genderPreference != genderPreference) {
            this.genderPreference.setUserProfile(null);
        }
        this.genderPreference = genderPreference;
        if (genderPreference != null && genderPreference.getUserProfile() != this) {
            genderPreference.setUserProfile(this);
        }
    }

    public RelationshipPreference getRelationshipPreference() {
        return relationshipPreference;
    }

    public void setRelationshipPreference(RelationshipPreference relationshipPreference) {
        if (this.relationshipPreference != null && this.relationshipPreference != relationshipPreference) {
            this.relationshipPreference.setUserProfile(null);
        }
        this.relationshipPreference = relationshipPreference;
        if (relationshipPreference != null && relationshipPreference.getUserProfile() != this) {
            relationshipPreference.setUserProfile(this);
        }
    }

    public ChildrenPreference getChildrenPreference() {
        return childrenPreference;
    }

    public void setChildrenPreference(ChildrenPreference childrenPreference) {
        if (this.childrenPreference != null && this.childrenPreference != childrenPreference) {
            this.childrenPreference.setUserProfile(null);
        }
        this.childrenPreference = childrenPreference;
        if (childrenPreference != null && childrenPreference.getUserProfile() != this) {
            childrenPreference.setUserProfile(this);
        }
    }

    public AgePreference getAgePreference() {
        return agePreference;
    }

    public void setAgePreference(AgePreference agePreference) {
        if (this.agePreference != null && this.agePreference != agePreference) {
            this.agePreference.setUserProfile(null);
        }
        this.agePreference = agePreference;
        if (agePreference != null && agePreference.getUserProfile() != this) {
            agePreference.setUserProfile(this);
        }
    }

    public ReligionPreference getReligionPreference() {
        return religionPreference;
    }

    public void setReligionPreference(ReligionPreference religionPreference) {
        if (this.religionPreference != null && this.religionPreference != religionPreference) {
            this.religionPreference.setUserProfile(null);
        }
        this.religionPreference = religionPreference;
        if (religionPreference != null && religionPreference.getUserProfile() != this) {
            religionPreference.setUserProfile(this);
        }
    }

    public EducationPreference getEducationPreference() {
        return educationPreference;
    }

    public void setEducationPreference(EducationPreference educationPreference) {
        if (this.educationPreference != null && this.educationPreference != educationPreference) {
            this.educationPreference.setUserProfile(null);
        }
        this.educationPreference = educationPreference;
        if (educationPreference != null && educationPreference.getUserProfile() != this) {
            educationPreference.setUserProfile(this);
        }
    }

    public LanguagePreference getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(LanguagePreference languagePreference) {
        if (this.languagePreference != null && this.languagePreference != languagePreference) {
            this.languagePreference.setUserProfile(null);
        }
        this.languagePreference = languagePreference;
        if (languagePreference != null && languagePreference.getUserProfile() != this) {
            languagePreference.setUserProfile(this);
        }
    }

    public VicePreference getVicePreference() {
        return vicePreference;
    }

    public void setVicePreference(VicePreference vicePreference) {
        if (this.vicePreference != null && this.vicePreference != vicePreference) {
            this.vicePreference.setUserProfile(null);
        }
        this.vicePreference = vicePreference;
        if (vicePreference != null && vicePreference.getUserProfile() != this) {
            vicePreference.setUserProfile(this);
        }
    }

    public PetsPreference getPetsPreference() {
        return petsPreference;
    }

    public void setPetsPreference(PetsPreference petsPreference) {
        if (this.petsPreference != null && this.petsPreference != petsPreference) {
            this.petsPreference.setUserProfile(null);
        }
        this.petsPreference = petsPreference;
        if (petsPreference != null && petsPreference.getUserProfile() != this) {
            petsPreference.setUserProfile(this);
        }
    }

    public TravelPreference getTravelPreference() {
        return travelPreference;
    }

    public void setTravelPreference(TravelPreference travelPreference) {
        if (this.travelPreference != null && this.travelPreference != travelPreference) {
            this.travelPreference.setUserProfile(null);
        }
        this.travelPreference = travelPreference;
        if (travelPreference != null && travelPreference.getUserProfile() != this) {
            travelPreference.setUserProfile(this);
        }
    }

    public DietPreference getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(DietPreference dietPreference) {
        if (this.dietPreference != null && this.dietPreference != dietPreference) {
            this.dietPreference.setUserProfile(null);
        }
        this.dietPreference = dietPreference;
        if (dietPreference != null && dietPreference.getUserProfile() != this) {
            dietPreference.setUserProfile(this);
        }
    }

    public Set<UserInterest> getInterests() {
        return interests;
    }

    public void setInterests(Set<UserInterest> interests) {
        if (this.interests == null) {
            this.interests = new LinkedHashSet<>();
        }
        this.interests.forEach(interest -> interest.setUserProfile(null));
        this.interests.clear();
        for (UserInterest interest : interests) {
            interest.setUserProfile(this);
            this.interests.add(interest);
        }
    }

    public void addInterest(UserInterest interest) {
        if (interest != null) {
            this.interests.add(interest);
            interest.setUserProfile(this);
        }
    }

    public void removeInterest(UserInterest interest) {
        if (interest != null) {
            this.interests.remove(interest);
            interest.setUserProfile(null);
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
