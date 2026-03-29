package net.spotapps.tester.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.AssertTrue;

@Entity
@Table(name = "age_preferences")
public class AgePreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "The day of the user's birth", example = "01")
    @Column(name = "birth_day")
    private String day;

    @Schema(description = "The month of the user's birth", example = "January")
    @Column(name = "birth_month")
    private String month;

    @Schema(description = "The year of the user's birth", example = "1990")
    @Column(name = "birth_year")
    private String year;

    @Schema(description = "The minimum age the user is interested in")
    @Column(name = "min_age")
    @Min(18)
    private Integer minAge;

    @Schema(description = "The maximum age the user is interested in")
    @Column(name = "max_age")
    @Min(18)
    private Integer maxAge;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        if (minAge != null) {
            if (minAge < 0) {
                throw new IllegalArgumentException("Minimum age cannot be negative");
            }
        }
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        if (maxAge != null) {
            if (maxAge < 0) {
                throw new IllegalArgumentException("Maximum age cannot be negative");
            }
        }
        this.maxAge = maxAge;
    }

    public void setAgeRange(Integer minAge, Integer maxAge) {
        if (minAge != null && maxAge != null && minAge > maxAge) {
            throw new IllegalArgumentException("Minimum age cannot be greater than maximum age");
        }
        setMinAge(minAge);
        setMaxAge(maxAge);
    }

    @AssertTrue(message = "Minimum age must be less than or equal to maximum age")
    private boolean isAgeRangeValid() {
        return minAge == null || maxAge == null || minAge <= maxAge;
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
        if (!(obj instanceof AgePreference))
            return false;
        AgePreference other = (AgePreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "AgePreference [userId=" + userId + "]";
    }
}
