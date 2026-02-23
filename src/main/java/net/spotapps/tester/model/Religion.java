package net.spotapps.tester.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "religions")
public class Religion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "religion_id")
    private Long religionId;

    @Column(name = "religion_name", nullable = false)
    private String religionName;

    @Column(name = "branch_name")
    private String branchName;

    public Religion() {}

    public Religion(String religionName, String branchName) {
        this.religionName = religionName;
        this.branchName = branchName;
    }

    public Long getReligionId() {
        return religionId;
    }

    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Religion religion = (Religion) o;
        return Objects.equals(religionId, religion.religionId) &&
               Objects.equals(religionName, religion.religionName) &&
               Objects.equals(branchName, religion.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(religionId, religionName, branchName);
    }

    @Override
    public String toString() {
        return "Religion [religionId=" + religionId + ", religionName=" + religionName + ", branchName=" + branchName + "]";
    }
}
