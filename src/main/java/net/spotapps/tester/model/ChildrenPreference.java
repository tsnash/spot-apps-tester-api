package net.spotapps.tester.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "children_preferences")
public class ChildrenPreference {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    @Schema(description = "List of user's children")
    @OneToMany(mappedBy = "childrenPreference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children;

    @Schema(description = "Indicates if the user wants more children")
    @Column(name = "more_children")
    private Boolean moreChildren;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Boolean getMoreChildren() {
        return moreChildren;
    }

    public void setMoreChildren(Boolean moreChildren) {
        this.moreChildren = moreChildren;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ChildrenPreference other = (ChildrenPreference) obj;
        return Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "ChildrenPreference [userId=" + userId + "]";
    }
}
