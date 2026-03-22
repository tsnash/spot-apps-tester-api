package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long childId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "life_stage_id")
    private LifeStage lifeStage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private ChildGender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "household_status_id")
    private HouseholdStatus inHousehold;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private ChildrenPreference childrenPreference;

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public LifeStage getLifeStage() {
        return lifeStage;
    }

    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }

    public ChildGender getGender() {
        return gender;
    }

    public void setGender(ChildGender gender) {
        this.gender = gender;
    }

    public HouseholdStatus getInHousehold() {
        return inHousehold;
    }

    public void setInHousehold(HouseholdStatus inHousehold) {
        this.inHousehold = inHousehold;
    }

    public ChildrenPreference getChildrenPreference() {
        return childrenPreference;
    }

    public void setChildrenPreference(ChildrenPreference childrenPreference) {
        this.childrenPreference = childrenPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Child))
            return false;
        Child other = (Child) o;
        if (childId != null && other.getChildId() != null) {
            return Objects.equals(childId, other.getChildId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (childId != null) {
            return Objects.hash(childId);
        }
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Child [childId=" + childId + "]";
    }
}
