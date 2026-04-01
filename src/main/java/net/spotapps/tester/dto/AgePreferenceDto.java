package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "month",
        "year",
        "minAge",
        "maxAge"
})
@Schema(description = "Represents a user's age preferences, including their own birth date and the preferred age range for potential matches.")
public class AgePreferenceDto {

    @JsonProperty("day")
    @Schema(description = "The day of the user's birth in the format DD", example = "01", minimum = "01", maximum = "31")
    private String day;

    @JsonProperty("month")
    @Schema(description = "The month of the user's birth in the format MM", example = "01", minimum = "01", maximum = "12")
    private String month;

    @JsonProperty("year")
    @Schema(description = "The year of the user's birth in the format YYYY", example = "1990", minimum = "1900")
    private String year;

    @JsonProperty("minAge")
    @Schema(description = "The minimum preferred age", example = "25", minimum = "18")
    private Integer minAge;

    @JsonProperty("maxAge")
    @Schema(description = "The maximum preferred age", example = "35", minimum = "18")
    private Integer maxAge;

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
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AgePreferenceDto))
            return false;
        AgePreferenceDto other = (AgePreferenceDto) o;
        return Objects.equals(day, other.day) && Objects.equals(month, other.month) && Objects.equals(year, other.year)
                && Objects.equals(minAge, other.minAge) && Objects.equals(maxAge, other.maxAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, minAge, maxAge);
    }
}