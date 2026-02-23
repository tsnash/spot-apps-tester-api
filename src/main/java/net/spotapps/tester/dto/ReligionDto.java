package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "religionId",
        "religionName",
        "branchName"
})
public class ReligionDto {

    @JsonProperty("religionId")
    private Long religionId;

    @JsonProperty("religionName")
    private String religionName;

    @JsonProperty("branchName")
    private String branchName;

    public ReligionDto() {}

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
        return "ReligionDto [religionId=" + religionId + ", religionName=" + religionName + ", branchName=" + branchName + "]";
    }
}
