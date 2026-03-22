package net.spotapps.tester.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "genderId",
        "name"
})
public class GenderDto {

    @JsonProperty("genderId")
    private Long genderId;

    @JsonProperty("name")
    private String name;

    public GenderDto() {
    }

    public GenderDto(Long id, String name) {
        this.genderId = id;
        this.name = name;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long id) {
        this.genderId = id;
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
        GenderDto other = (GenderDto) o;
        return Objects.equals(genderId, other.genderId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId, name);
    }

    @Override
    public String toString() {
        return "GenderDto [genderId=" + genderId + ", name=" + name + "]";
    }
}
