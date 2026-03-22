package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AgePreferenceDto {
    @JsonProperty("day")
    private String day;
    @JsonProperty("month")
    private String month;
    @JsonProperty("year")
    private String year;
    @JsonProperty("minAge")
    private Integer minAge;
    @JsonProperty("maxAge")
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