package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "viceTypeId",
        "name"
})
public class ViceTypeDto {

    @JsonProperty("viceTypeId")
    private Long viceTypeId;

    @JsonProperty("name")
    private String name;

    public ViceTypeDto() {}

    public ViceTypeDto(Long id, String name) {
        this.viceTypeId = id;
        this.name = name;
    }

    public Long getViceTypeId() {
        return viceTypeId;
    }

    public void setViceTypeId(Long id) {
        this.viceTypeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViceTypeDto other = (ViceTypeDto) o;
        return Objects.equals(viceTypeId, other.viceTypeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viceTypeId, name);
    }

    @Override
    public String toString() {
        return "ViceTypeDto [viceTypeId=" + viceTypeId + ", name=" + name + "]";
    }
}
