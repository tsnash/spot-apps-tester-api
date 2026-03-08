package net.spotapps.tester.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ChildrenPreferenceDto {
    @JsonProperty("children")
    private List<ChildDto> children;
    @JsonProperty("moreChildren")
    private Boolean moreChildren;

    public List<ChildDto> getChildren() { return children; }
    public void setChildren(List<ChildDto> children) { this.children = children; }
    public Boolean getMoreChildren() { return moreChildren; }
    public void setMoreChildren(Boolean moreChildren) { this.moreChildren = moreChildren; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildrenPreferenceDto)) return false;
        ChildrenPreferenceDto other = (ChildrenPreferenceDto) o;
        return Objects.equals(moreChildren, other.moreChildren);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moreChildren);
    }
}