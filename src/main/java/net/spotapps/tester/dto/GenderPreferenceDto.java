package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenderPreferenceDto {
    @JsonProperty("gender")
    private GenderDto gender;
    private Boolean isTrans;
    @JsonProperty("orientation")
    private OrientationDto orientation;

    public GenderDto getGender() { return gender; }
    public void setGender(GenderDto gender) { this.gender = gender; }
    @JsonProperty("isTrans")
    public Boolean getTrans() { return isTrans; }
    public void setTrans(Boolean isTrans) { this.isTrans = isTrans; }
    public OrientationDto getOrientation() { return orientation; }
    public void setOrientation(OrientationDto orientation) { this.orientation = orientation; }
}
