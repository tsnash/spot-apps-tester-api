package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "contact_preferences")
public class ContactPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;
    
    @Schema(description = "The first name of the user", example = "Jane")
    @Column(name = "first_name")
    @Size(max = 100)
    private String firstName;

    @Schema(description = "The last name of the user", example = "Doe")
    @Column(name = "last_name")
    @Size(max = 100)
    private String lastName;

    @Schema(description = "The phone number of the user", example = "+15551234567")
    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format")
    @Size(max = 16)
    private String phoneNumber;

    @Schema(description = "The email address of the user", example = "jane.doe@example.com")
    @Column(name = "email_address")
    @Email
    @Size(max = 255)
    private String emailAddress;

    @Schema(description = "Indicates if the user has verified their email address")
    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ContactPreference other = (ContactPreference) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "ContactPreference [userId=" + userId + "]";
    }

}
