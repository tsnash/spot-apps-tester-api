package net.spotapps.tester.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "children",
        "moreChildren"
})
@Schema(description = "Represents a user's affinity towards children.")
public class ChildrenPreferenceDto {

    @JsonProperty("children")
    @Schema(description = "A list of children associated with the user.")
    private List<ChildDto> children;

    @JsonProperty("moreChildren")
    @Schema(description = "Indicates whether the user is open to having more children.", example = "true")
    private Boolean moreChildren;

    public List<ChildDto> getChildren() {
        return children;
    }

    public void setChildren(List<ChildDto> children) {
        this.children = children;
    }

    public Boolean getMoreChildren() {
        return moreChildren;
    }

    public void setMoreChildren(Boolean moreChildren) {
        this.moreChildren = moreChildren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ChildrenPreferenceDto))
            return false;
        ChildrenPreferenceDto other = (ChildrenPreferenceDto) o;
        return Objects.equals(moreChildren, other.moreChildren) && Objects.equals(children, other.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moreChildren, children);
    }

    @Override
    public String toString() {
        return "ChildrenPreferenceDto [children=" + children + ", moreChildren=" + moreChildren + "]";
    }
}