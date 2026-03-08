package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SocialPersonalityDto {
    @JsonProperty("openness")
    private PersonalityScaleDto openness;
    @JsonProperty("conscientiousness")
    private PersonalityScaleDto conscientiousness;
    @JsonProperty("extraversion")
    private PersonalityScaleDto extraversion;
    @JsonProperty("agreeableness")
    private PersonalityScaleDto agreeableness;
    @JsonProperty("neuroticism")
    private PersonalityScaleDto neuroticism;

    public PersonalityScaleDto getOpenness() { return openness; }
    public void setOpenness(PersonalityScaleDto openness) { this.openness = openness; }
    public PersonalityScaleDto getConscientiousness() { return conscientiousness; }
    public void setConscientiousness(PersonalityScaleDto conscientiousness) { this.conscientiousness = conscientiousness; }
    public PersonalityScaleDto getExtraversion() { return extraversion; }
    public void setExtraversion(PersonalityScaleDto extraversion) { this.extraversion = extraversion; }
    public PersonalityScaleDto getAgreeableness() { return agreeableness; }
    public void setAgreeableness(PersonalityScaleDto agreeableness) { this.agreeableness = agreeableness; }
    public PersonalityScaleDto getNeuroticism() { return neuroticism; }
    public void setNeuroticism(PersonalityScaleDto neuroticism) { this.neuroticism = neuroticism; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialPersonalityDto)) return false;
        SocialPersonalityDto other = (SocialPersonalityDto) o;
        return Objects.equals(openness, other.openness) && Objects.equals(conscientiousness, other.conscientiousness) && Objects.equals(extraversion, other.extraversion) && Objects.equals(agreeableness, other.agreeableness) && Objects.equals(neuroticism, other.neuroticism);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openness, conscientiousness, extraversion, agreeableness, neuroticism);
    }
}