package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "childId",
        "lifeStage",
        "gender",
        "inHousehold"
})
@Schema(description = "Represents a child associated with a user profile.")
public class ChildDto {

    @JsonProperty("childId")
    @Schema(description = "The unique identifier for the child.", example = "1")
    private Long childId;

    @JsonProperty("lifeStage")
    @Schema(description = "The stage of life the child is in.")
    private LifeStageDto lifeStage;

    @JsonProperty("gender")
    @Schema(description = "The gender of the child.")
    private ChildGenderDto gender;

    @JsonProperty("inHousehold")
    @Schema(description = "Indicates whether the child is in the household.")
    private HouseholdStatusDto inHousehold;

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public LifeStageDto getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(LifeStageDto lifeStage) {
        this.lifeStage = lifeStage;
    }

    public ChildGenderDto getGender() {
        return gender;
    }

    public void setGender(ChildGenderDto gender) {
        this.gender = gender;
    }

    public HouseholdStatusDto getInHousehold() {
        return inHousehold;
    }

    public void setInHousehold(HouseholdStatusDto inHousehold) {
        this.inHousehold = inHousehold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ChildDto childDto = (ChildDto) o;
        return Objects.equals(childId, childDto.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childId);
    }
}
