package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildDto {

    @JsonProperty("childId")
    private Long childId;

    @JsonProperty("lifeStage")
    private LifeStageDto lifeStage;

    @JsonProperty("gender")
    private ChildGenderDto gender;

    @JsonProperty("inHousehold")
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildDto childDto = (ChildDto) o;
        return Objects.equals(childId, childDto.childId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childId);
    }
}
