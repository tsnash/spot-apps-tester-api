package net.spotapps.tester.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserProfiles")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "images",
    "contact",
    "location",
    "social",
    "gender",
    "relationship",
    "children",
    "age",
    "religion",
    "education",
    "language",
    "vice",
    "pets",
    "travel",
    "diet",
    "interests"
})
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique identifier, generated by UserProfileService on addition", position = 1)
    @JsonPropertyDescription("The unique identifier, generated by UserProfileService on addition")
    @Column(name = "user_id")
    private Long userId;

    @ApiModelProperty(notes = "List of references to images of the user", position = 2)
    @JsonProperty(required = true)
    @JsonPropertyDescription("List of references to images of the user")
    @OneToMany(mappedBy = "userProfile")
    @JoinColumn(name = "images", nullable = false)
    private List<UserImage> images;

    @ApiModelProperty(notes = "The contact information and preferences of the user", position = 3)
    @JsonPropertyDescription("The contact information and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "contact")
    private ContactPreference contact;

    @ApiModelProperty(notes = "The location and proximity preferences of the user", position = 4)
    @JsonPropertyDescription("The location and proximity preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "location")
    private LocationPreference location;

    @ApiModelProperty(notes = "The socializing preference of the user", position = 5)
    @JsonPropertyDescription("The socializing preference of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "social")
    private SocialPreference social;

    @ApiModelProperty(notes = "The gender identity and preferences of the user", position = 6)
    @JsonPropertyDescription("The gender identity and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "gender")
    private GenderPreference gender;

    @ApiModelProperty(notes = "The relationship status and style preferences of the user", position = 7)
    @JsonPropertyDescription("The relationship status and style preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "relationship")
    private RelationshipPreference relationship;

    @ApiModelProperty(notes = "The child having status and preferences of the user", position = 8)
    @JsonPropertyDescription("The child having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "children")
    private ChildrenPreference children;

    @ApiModelProperty(notes = "The age and ranged preferences of the user", position = 9)
    @JsonPropertyDescription("The age and ranged preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "age")
    private AgePreference age;

    @ApiModelProperty(notes = "The religious practice and preferences of the user", position = 10)
    @JsonPropertyDescription("The religious practice and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "religion")
    private ReligionPreference religion;

    @ApiModelProperty(notes = "The education status and preferences of the user", position = 11)
    @JsonPropertyDescription("The education status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "education")
    private EducationPreference education;

    @ApiModelProperty(notes = "The language speaking status and preferences of the user", position = 12)
    @JsonPropertyDescription("The language speaking status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "language")
    private LanguagePreference language;

    @ApiModelProperty(notes = "The extracurricular partakings and preferences of the user", position = 13)
    @JsonPropertyDescription("The extracurricular partakings and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "vice")
    private VicePreference vice;

    @ApiModelProperty(notes = "The pet having status and preferences of the user", position = 14)
    @JsonPropertyDescription("The pet having status and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "pets")
    private PetsPreference pets;

    @ApiModelProperty(notes = "The preferences of the user regarding the dynamics centered around travel", position = 15)
    @JsonPropertyDescription("The preferences of the user regarding the dynamics centered around travel")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "travel")
    private TravelPreference travel;

    @ApiModelProperty(notes = "The dietary restrictions and preferences of the user", position = 16)
    @JsonPropertyDescription("The dietary restrictions and preferences of the user")
    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "diet")
    private DietPreference diet;

    @ApiModelProperty(notes = "The things and activities the user is interested in", position = 17)
    @JsonProperty(required = true)
    @JsonPropertyDescription("The things and activities the user is interested in")
    @OneToMany(mappedBy = "userProfile")
    @JoinColumn(name = "interests", nullable = false)
    private List<UserInterest> interests;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UserImage> getImages() {
        return images;
    }

    public void setImages(List<UserImage> images) {
        this.images = images;
    }

    public ContactPreference getContact() {
        return contact;
    }

    public void setContact(ContactPreference contact) {
        this.contact = contact;
    }

    public LocationPreference getLocation() {
        return location;
    }

    public void setLocation(LocationPreference location) {
        this.location = location;
    }

    public SocialPreference getSocial() {
        return social;
    }

    public void setSocial(SocialPreference social) {
        this.social = social;
    }

    public GenderPreference getGender() {
        return gender;
    }

    public void setGender(GenderPreference gender) {
        this.gender = gender;
    }

    public RelationshipPreference getRelationship() {
        return relationship;
    }

    public void setRelationship(RelationshipPreference relationship) {
        this.relationship = relationship;
    }

    public ChildrenPreference getChildren() {
        return children;
    }

    public void setChildren(ChildrenPreference children) {
        this.children = children;
    }

    public AgePreference getAge() {
        return age;
    }

    public void setAge(AgePreference age) {
        this.age = age;
    }

    public ReligionPreference getReligion() {
        return religion;
    }

    public void setReligion(ReligionPreference religion) {
        this.religion = religion;
    }

    public EducationPreference getEducation() {
        return education;
    }

    public void setEducation(EducationPreference education) {
        this.education = education;
    }

    public LanguagePreference getLanguage() {
        return language;
    }

    public void setLanguage(LanguagePreference language) {
        this.language = language;
    }

    public VicePreference getVice() {
        return vice;
    }

    public void setVice(VicePreference vice) {
        this.vice = vice;
    }

    public PetsPreference getPets() {
        return pets;
    }

    public void setPets(PetsPreference pets) {
        this.pets = pets;
    }

    public TravelPreference getTravel() {
        return travel;
    }

    public void setTravel(TravelPreference travel) {
        this.travel = travel;
    }

    public DietPreference getDiet() {
        return diet;
    }

    public void setDiet(DietPreference diet) {
        this.diet = diet;
    }

    public List<UserInterest> getInterests() {
        return interests;
    }

    public void setInterests(List<UserInterest> interests) {
        this.interests = interests;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((images == null) ? 0 : images.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((social == null) ? 0 : social.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
        result = prime * result + ((children == null) ? 0 : children.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((religion == null) ? 0 : religion.hashCode());
        result = prime * result + ((education == null) ? 0 : education.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((vice == null) ? 0 : vice.hashCode());
        result = prime * result + ((pets == null) ? 0 : pets.hashCode());
        result = prime * result + ((travel == null) ? 0 : travel.hashCode());
        result = prime * result + ((diet == null) ? 0 : diet.hashCode());
        result = prime * result + ((interests == null) ? 0 : interests.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserProfile other = (UserProfile) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (images == null) {
            if (other.images != null)
                return false;
        } else if (!images.equals(other.images))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (location == null) {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (social == null) {
            if (other.social != null)
                return false;
        } else if (!social.equals(other.social))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (relationship == null) {
            if (other.relationship != null)
                return false;
        } else if (!relationship.equals(other.relationship))
            return false;
        if (children == null) {
            if (other.children != null)
                return false;
        } else if (!children.equals(other.children))
            return false;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (religion == null) {
            if (other.religion != null)
                return false;
        } else if (!religion.equals(other.religion))
            return false;
        if (education == null) {
            if (other.education != null)
                return false;
        } else if (!education.equals(other.education))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (vice == null) {
            if (other.vice != null)
                return false;
        } else if (!vice.equals(other.vice))
            return false;
        if (pets == null) {
            if (other.pets != null)
                return false;
        } else if (!pets.equals(other.pets))
            return false;
        if (travel == null) {
            if (other.travel != null)
                return false;
        } else if (!travel.equals(other.travel))
            return false;
        if (diet == null) {
            if (other.diet != null)
                return false;
        } else if (!diet.equals(other.diet))
            return false;
        if (interests == null) {
            if (other.interests != null)
                return false;
        } else if (!interests.equals(other.interests))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [userId=" + userId + ", images=" + images + ", contact=" + contact + ", location="
                + location + ", social=" + social + ", gender=" + gender + ", relationship=" + relationship
                + ", children=" + children + ", age=" + age + ", religion=" + religion + ", education=" + education
                + ", language=" + language + ", vice=" + vice + ", pets=" + pets + ", travel=" + travel + ", diet="
                + diet + ", interests=" + interests + "]";
    }

    

}
