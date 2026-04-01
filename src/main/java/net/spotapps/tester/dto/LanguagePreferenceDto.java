package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "languagesSpoken",
        "importance"
})
@Schema(description = "Represents a user's spoken languages and their preference for matching.")
public class LanguagePreferenceDto {

    @JsonProperty("languagesSpoken")
    @Schema(description = "A list of languages spoken by the user.")
    private List<LanguageDto> languagesSpoken;

    @JsonProperty("importance")
    @Schema(description = "How important language matching is to the user.", minimum = "1", maximum = "5", example = "3")
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