package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class GenderPreferenceDto {
    @JsonProperty("gender")
    private GenderDto gender;
    private Boolean trans;
    @JsonProperty("orientation")
    private OrientationDto orientation;

    public GenderDto getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }

    @JsonProperty("isTrans")
    public Boolean getTrans() {
        return trans;
    }

    public void setTrans(Boolean trans) {
        this.trans = trans;
    }

    public OrientationDto getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationDto orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GenderPreferenceDto))
            return false;
        GenderPreferenceDto other = (GenderPreferenceDto) o;
        return Objects.equals(gender, other.gender) && Objects.equals(trans, other.trans)
                && Objects.equals(orientation, other.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, trans, orientation);
    }
}