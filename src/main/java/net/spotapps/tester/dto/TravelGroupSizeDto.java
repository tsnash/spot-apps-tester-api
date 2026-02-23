package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "travelGroupSizeId",
        "name"
})
public class TravelGroupSizeDto {

    @JsonProperty("travelGroupSizeId")
    private Long travelGroupSizeId;

    @JsonProperty("name")
    private String name;

    public TravelGroupSizeDto() {}

    public TravelGroupSizeDto(Long id, String name) {
        this.travelGroupSizeId = id;
        this.name = name;
    }

    public Long getTravelGroupSizeId() {
        return travelGroupSizeId;
    }

    public void setTravelGroupSizeId(Long id) {
        this.travelGroupSizeId = id;
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
        TravelGroupSizeDto other = (TravelGroupSizeDto) o;
        return Objects.equals(travelGroupSizeId, other.travelGroupSizeId) && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelGroupSizeId, name);
    }

    @Override
    public String toString() {
        return "TravelGroupSizeDto [travelGroupSizeId=" + travelGroupSizeId + ", name=" + name + "]";
    }
}
