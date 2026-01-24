package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactPreferenceDto {

    @JsonProperty(required = true)
    @JsonPropertyDescription("The first name of the user")
    @Size(max = 100)
    @NotBlank
    private String firstName;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The last name of the user")
    @Size(max = 100)
    @NotBlank
    private String lastName;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The phone number of the user")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Phone number must be in E.164 format")
    @Size(max = 16)
    @NotBlank
    private String phoneNumber;

    @JsonProperty(required = true)
    @JsonPropertyDescription("The email address of the user")
    @Email
    @Size(max = 255)
    @NotBlank
    private String emailAddress;

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
}
