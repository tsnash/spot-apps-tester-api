package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "personalityScaleId",
        "name"
})
@Schema(description = "Represents a rating on a personality scale.")
public class PersonalityScaleDto {

    @JsonProperty("personalityScaleId")
    @Schema(description = "The unique identifier for the personality scale level.", example = "3")
    private Long personalityScaleId;

    @JsonProperty("name")
    @Schema(description = "The name/description of the personality scale level.", example = "neutral")
    private String name;

    public PersonalityScaleDto() {
    }

    public PersonalityScaleDto(Long id, String name) {
        this.personalityScaleId = id;
        this.name = name;
    }

    public Long getPersonalityScaleId() {
        return personalityScaleId;
    }

    public void setPersonalityScaleId(Long id) {
        this.personalityScaleId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PersonalityScaleDto other = (PersonalityScaleDto) o;
        return Objects.equals(personalityScaleId, other.personalityScaleId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalityScaleId, name);
    }

    @Override
    public String toString() {
        return "PersonalityScaleDto [personalityScaleId=" + personalityScaleId + ", name=" + name + "]";
    }
}
