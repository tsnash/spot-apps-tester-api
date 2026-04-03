package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "householdStatusId",
        "name"
})
@Schema(description = "Represents the household status of a child or user.")
public class HouseholdStatusDto {

    @JsonProperty("householdStatusId")
    @Schema(description = "The unique identifier for the household status.", example = "1")
    private Long householdStatusId;

    @JsonProperty("name")
    @Schema(description = "The name of the household status.", example = "full-time")
    private String name;

    public HouseholdStatusDto() {
    }

    public HouseholdStatusDto(Long id, String name) {
        this.householdStatusId = id;
        this.name = name;
    }

    public Long getHouseholdStatusId() {
        return householdStatusId;
    }

    public void setHouseholdStatusId(Long id) {
        this.householdStatusId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        HouseholdStatusDto other = (HouseholdStatusDto) o;
        return Objects.equals(householdStatusId, other.householdStatusId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(householdStatusId, name);
    }

    @Override
    public String toString() {
        return "HouseholdStatusDto [householdStatusId=" + householdStatusId + ", name=" + name + "]";
    }
}
