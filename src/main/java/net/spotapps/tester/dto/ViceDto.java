package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "viceId",
        "viceType",
        "frequency"
})
@Schema(description = "Represents a user's vice, including its unique identifier, type, and frequency.")
public class ViceDto {

    @JsonProperty("viceId")
    @Schema(description = "The unique identifier of the user's vice.", example = "1")
    private Long viceId;

    @JsonProperty("viceType")
    @Schema(description = "The type of the user's vice.")
    private ViceTypeDto viceType;

    @JsonProperty("frequency")
    @Schema(description = "The frequency of the user's vice.")
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ViceDto viceDto = (ViceDto) o;
        return Objects.equals(viceId, viceDto.viceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceId);
    }
}
