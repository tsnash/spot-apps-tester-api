package net.spotapps.tester.dto.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "traceId"
})
@Schema(description = "Represents additional data related to but not part of the request response.")
public class Metadata {

    @JsonProperty("traceId")
    @Schema(description = "A unique identifier for the request, used for tracking and logging.", example = "550e8400-e29b-41d4-a716-446655440000")
    private String traceId;

    public Metadata() {
    }

    public Metadata(String traceId) {
        setTraceId(traceId);
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(traceId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Metadata other = (Metadata) obj;
        return Objects.equals(traceId, other.traceId);
    }

    @Override
    public String toString() {
        return "Metadata [traceId=" + traceId + "]";
    }

}
