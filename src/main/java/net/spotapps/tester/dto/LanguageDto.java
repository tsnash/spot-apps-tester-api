package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LanguageDto {

    @JsonProperty("languageId")
    private Long languageId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("fluency")
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
