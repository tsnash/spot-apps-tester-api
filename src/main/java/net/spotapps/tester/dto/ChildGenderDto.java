package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "childGenderId",
        "name"
})
public class ChildGenderDto {

    @JsonProperty("childGenderId")
    private Long childGenderId;

    @JsonProperty("name")
    private String name;

    public ChildGenderDto() {
    }

    public ChildGenderDto(Long id, String name) {
        this.childGenderId = id;
        this.name = name;
    }

    public Long getChildGenderId() {
        return childGenderId;
    }

    public void setChildGenderId(Long id) {
        this.childGenderId = id;
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
        ChildGenderDto other = (ChildGenderDto) o;
        return Objects.equals(childGenderId, other.childGenderId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childGenderId, name);
    }

    @Override
    public String toString() {
        return "ChildGenderDto [childGenderId=" + childGenderId + ", name=" + name + "]";
    }
}
