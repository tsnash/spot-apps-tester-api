package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "openness",
        "conscientiousness",
        "extraversion",
        "agreeableness",
        "neuroticism"
})
@Schema(description = "Represents a user's social personality traits based on the Big Five model.")
public class SocialPersonalityDto {

    @JsonProperty("openness")
    @Schema(description = "The openness trait.")
    private PersonalityScaleDto openness;

    @JsonProperty("conscientiousness")
    @Schema(description = "The conscientiousness trait.")
    private PersonalityScaleDto conscientiousness;

    @JsonProperty("extraversion")
    @Schema(description = "The extraversion trait.")
    private PersonalityScaleDto extraversion;

    @JsonProperty("agreeableness")
    @Schema(description = "The agreeableness trait.")
    private PersonalityScaleDto agreeableness;

    @JsonProperty("neuroticism")
    @Schema(description = "The neuroticism trait.")
    private PersonalityScaleDto neuroticism;

    public PersonalityScaleDto getOpenness() {
        return openness;
    }

    public void setOpenness(PersonalityScaleDto openness) {
        this.openness = openness;
    }

    public PersonalityScaleDto getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(PersonalityScaleDto conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    public PersonalityScaleDto getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(PersonalityScaleDto extraversion) {
        this.extraversion = extraversion;
    }

    public PersonalityScaleDto getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(PersonalityScaleDto agreeableness) {
        this.agreeableness = agreeableness;
    }

    public PersonalityScaleDto getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(PersonalityScaleDto neuroticism) {
        this.neuroticism = neuroticism;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SocialPersonalityDto))
            return false;
        SocialPersonalityDto other = (SocialPersonalityDto) o;
        return Objects.equals(openness, other.openness) && Objects.equals(conscientiousness, other.conscientiousness)
                && Objects.equals(extraversion, other.extraversion)
                && Objects.equals(agreeableness, other.agreeableness) && Objects.equals(neuroticism, other.neuroticism);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openness, conscientiousness, extraversion, agreeableness, neuroticism);
    }

    @Override
    public String toString() {
        return "SocialPersonalityDto [openness=" + openness + ", conscientiousness=" + conscientiousness
                + ", extraversion=" + extraversion + ", agreeableness=" + agreeableness + ", neuroticism=" + neuroticism
                + "]";
    }
}