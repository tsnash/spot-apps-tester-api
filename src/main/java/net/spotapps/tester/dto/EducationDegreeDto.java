package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "educationDegreeId",
        "name"
})
public class EducationDegreeDto {

    @JsonProperty("educationDegreeId")
    private Long educationDegreeId;

    @JsonProperty("name")
    private String name;

    public EducationDegreeDto() {
    }

    public EducationDegreeDto(Long id, String name) {
        this.educationDegreeId = id;
        this.name = name;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long id) {
        this.educationDegreeId = id;
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
        EducationDegreeDto other = (EducationDegreeDto) o;
        return Objects.equals(educationDegreeId, other.educationDegreeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationDegreeId, name);
    }

    @Override
    public String toString() {
        return "EducationDegreeDto [educationDegreeId=" + educationDegreeId + ", name=" + name + "]";
    }
}
