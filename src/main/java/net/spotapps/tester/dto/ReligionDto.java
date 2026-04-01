package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "religionId",
        "religionName",
        "branchName"
})
@Schema(description = "Represents a religion and its branch.")
public class ReligionDto {

    @JsonProperty("religionId")
    @Schema(description = "The unique identifier for the religion.", example = "1")
    private Long religionId;

    @JsonProperty("religionName")
    @Schema(description = "The name of the religion.", example = "christianity")
    private String religionName;

    @JsonProperty("branchName")
    @Schema(description = "The name of the religious branch.", example = "catholic")
    private String branchName;

    public ReligionDto() {
    }

    public Long getReligionId() {
        return religionId;
    }

    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ReligionDto that = (ReligionDto) o;
        return Objects.equals(religionId, that.religionId) &&
                Objects.equals(religionName, that.religionName) &&
                Objects.equals(branchName, that.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(religionId, religionName, branchName);
    }

    @Override
    public String toString() {
        return "ReligionDto [religionId=" + religionId + ", religionName=" + religionName + ", branchName=" + branchName
                + "]";
    }
}
