package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "languageId",
        "name",
        "fluency"
})
@Schema(description = "Represents a language spoken by a user and their fluency level.")
public class LanguageDto {

    @JsonProperty("languageId")
    @Schema(description = "The unique identifier for the language.", example = "1")
    private Long languageId;

    @JsonProperty("name")
    @Schema(description = "The name of the language.", example = "English")
    private String name;

    @JsonProperty("fluency")
    @Schema(description = "The fluency level of the user in this language.")
    private FluencyLevelDto fluency;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FluencyLevelDto getFluency() {
        return fluency;
    }

    public void setFluency(FluencyLevelDto fluency) {
        this.fluency = fluency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LanguageDto that = (LanguageDto) o;
        return Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId);
    }
}
