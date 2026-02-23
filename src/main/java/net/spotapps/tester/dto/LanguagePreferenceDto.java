package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguagePreferenceDto {
    @JsonProperty("languagesSpoken")
    private List<LanguageDto> languagesSpoken;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<LanguageDto> getLanguagesSpoken() { return languagesSpoken; }
    public void setLanguagesSpoken(List<LanguageDto> languagesSpoken) { this.languagesSpoken = languagesSpoken; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
}
