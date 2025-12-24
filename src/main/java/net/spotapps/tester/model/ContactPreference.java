package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
    private String firstName;

    @Schema(description = "The last name of the user", example = "Doe")
    @Column(name = "last_name")
    private String lastName;

    @Schema(description = "The phone number of the user", example = "+15550199")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Schema(description = "The email address of the user", example = "jane.doe@example.com")
    @Column(name = "email_address")
    private String emailAddress;

    @Schema(description = "Indicates if the user has verified their email address")
    @Column(name = "email_verified")
    private Boolean emailVerified;
    
}
