package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenderPreferenceDto {
    @JsonProperty("gender")
    private GenderDto gender;
    @JsonProperty("isTrans")
    private boolean isTrans;
    @JsonProperty("orientation")
    private OrientationDto orientation;

    public GenderDto getGender() { return gender; }
    public void setGender(GenderDto gender) { this.gender = gender; }
    public boolean isTrans() { return isTrans; }
    public void setTrans(boolean isTrans) { this.isTrans = isTrans; }
    public OrientationDto getOrientation() { return orientation; }
    public void setOrientation(OrientationDto orientation) { this.orientation = orientation; }
}
