package net.spotapps.tester.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VicePreferenceDto {
    @JsonProperty("vices")
    private List<ViceDto> vices;
    @JsonProperty("importance")
    @Min(1)
    @Max(5)
    private Integer importance;

    public List<ViceDto> getVices() { return vices; }
    public void setVices(List<ViceDto> vices) { this.vices = vices; }
    public Integer getImportance() { return importance; }
    public void setImportance(Integer importance) { this.importance = importance; }
}
