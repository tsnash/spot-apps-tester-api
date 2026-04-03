package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstName",
        "lastName",
        "phoneNumber",
        "emailAddress",
        "emailVerified"
})
@Schema(description = "Represents how a user prefers to be contacted.")
public class ContactPreferenceDto {

    @JsonProperty("firstName")
    @Schema(description = "The first name of the user", example = "John")
    @Size(max = 16)
    private String firstName;

    @JsonProperty("lastName")
    @Schema(description = "The last name of the user", example = "Smith")
    @Size(max = 16)
    private String lastName;

    @JsonProperty("phoneNumber")
    @Schema(description = "The phone number of the user", example = "+1234567890")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format")
    @Size(max = 16)
    private String phoneNumber;

    @JsonProperty("emailAddress")
    @Schema(description = "The email address of the user", example = "john.smith@example.com")
    @Email
    @Size(max = 255)
    private String emailAddress;

    @JsonProperty("emailVerified")
    @Schema(description = "Indicates whether the email address has been verified", example = "true")
    private Boolean emailVerified;

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

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ContactPreferenceDto))
            return false;
        ContactPreferenceDto other = (ContactPreferenceDto) o;
        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(emailAddress, other.emailAddress)
                && Objects.equals(emailVerified, other.emailVerified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress, emailVerified);
    }

    @Override
    public String toString() {
        return "ContactPreferenceDto [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
                + phoneNumber + ", emailAddress=" + emailAddress + ", emailVerified=" + emailVerified + "]";
    }
}