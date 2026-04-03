package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "gender",
        "isTrans",
        "orientation"
})
@Schema(description = "Represents a user's gender and orientation preferences.")
public class GenderPreferenceDto {

    @JsonProperty("gender")
    @Schema(description = "The gender identity of the user.")
    private GenderDto gender;

    @JsonProperty("isTrans")
    @Schema(description = "Indicates if the user identifies as transgender.", example = "false")
    private Boolean trans;

    @JsonProperty("orientation")
    @Schema(description = "The sexual orientation of the user.")
    private OrientationDto orientation;

    public GenderDto getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }

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

    @Override
    public String toString() {
        return "GenderPreferenceDto [gender=" + gender + ", trans=" + trans + ", orientation=" + orientation + "]";
    }
}