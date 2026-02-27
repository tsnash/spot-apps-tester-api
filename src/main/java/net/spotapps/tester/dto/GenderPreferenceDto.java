package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenderPreferenceDto {
    @JsonProperty("gender")
    private GenderDto gender;
    private Boolean trans;
    @JsonProperty("orientation")
    private OrientationDto orientation;

    public GenderDto getGender() { return gender; }
    public void setGender(GenderDto gender) { this.gender = gender; }
    @JsonProperty("isTrans")
    public Boolean getTrans() { return trans; }
    public void setTrans(Boolean trans) { this.trans = trans; }
    public OrientationDto getOrientation() { return orientation; }
    public void setOrientation(OrientationDto orientation) { this.orientation = orientation; }
}
