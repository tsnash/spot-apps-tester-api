package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class LanguagePreferenceDto {
    @JsonProperty("languagesSpoken")
    private List<LanguageDto> languagesSpoken;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<LanguageDto> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<LanguageDto> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LanguagePreferenceDto))
            return false;
        LanguagePreferenceDto other = (LanguagePreferenceDto) o;
        return Objects.equals(importance, other.importance) && Objects.equals(languagesSpoken, other.languagesSpoken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importance, languagesSpoken);
    }

    @Override
    public String toString() {
        return "LanguagePreferenceDto [languagesSpoken=" + languagesSpoken + ", importance=" + importance + "]";
    }
}