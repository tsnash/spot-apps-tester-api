package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViceDto {

    @JsonProperty("viceId")
    private Long viceId;

    @JsonProperty("viceType")
    private ViceTypeDto viceType;

    @JsonProperty("frequency")
    private ViceFrequencyDto frequency;

    public Long getViceId() {
        return viceId;
    }

    public void setViceId(Long viceId) {
        this.viceId = viceId;
    }

    public ViceTypeDto getViceType() {
        return viceType;
    }

    public void setViceType(ViceTypeDto viceType) {
        this.viceType = viceType;
    }

    public ViceFrequencyDto getFrequency() {
        return frequency;
    }

    public void setFrequency(ViceFrequencyDto frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViceDto viceDto = (ViceDto) o;
        return Objects.equals(viceId, viceDto.viceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceId);
    }
}
