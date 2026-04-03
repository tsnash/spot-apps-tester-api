package net.spotapps.tester.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

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

    @OneToMany(mappedBy = "childrenPreference", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("childId ASC")
    private Set<Child> children = new LinkedHashSet<>();

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

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        if (this.children == null) {
            this.children = new LinkedHashSet<>();
        }
        // Null out existing children's parent reference to maintain consistency
        this.children.forEach(child -> child.setChildrenPreference(null));
        this.children.clear();
        if (children != null) {
            for (Child child : children) {
                child.setChildrenPreference(this);
                this.children.add(child);
            }
        }
    }

    public void addChild(Child child) {
        if (child != null) {
            this.children.add(child);
            child.setChildrenPreference(this);
        }
    }

    public void removeChild(Child child) {
        if (child != null) {
            this.children.remove(child);
            child.setChildrenPreference(null);
        }
    }

    public Boolean getMoreChildren() {
        return moreChildren;
    }

    public void setMoreChildren(Boolean moreChildren) {
        this.moreChildren = moreChildren;
    }

    @Override
    public int hashCode() {
        if (userId != null) {
            return Objects.hash(userId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ChildrenPreference))
            return false;
        ChildrenPreference other = (ChildrenPreference) obj;
        if (userId != null && other.getUserId() != null) {
            return Objects.equals(userId, other.getUserId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "ChildrenPreference [userId=" + userId + "]";
    }
}
