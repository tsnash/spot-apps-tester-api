package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "religions", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "religion_name", "branch_name" })
})
public class Religion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "religion_id")
    private Long religionId;

    @NotNull
    @Column(name = "religion_name", nullable = false)
    private String religionName;

    @NotNull
    @Column(name = "branch_name", nullable = false)
    private String branchName;

    public Religion() {
    }

    public Religion(String religionName, String branchName) {
        setReligionName(religionName);
        setBranchName(branchName);
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
        this.religionName = Objects.requireNonNull(religionName);
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = Objects.requireNonNullElse(branchName, "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Religion))
            return false;
        Religion religion = (Religion) o;
        return Objects.equals(religionName, religion.religionName) &&
                Objects.equals(branchName, religion.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(religionName, branchName);
    }

    @Override
    public String toString() {
        return "Religion [religionId=" + religionId + ", religionName=" + religionName + ", branchName=" + branchName
                + "]";
    }
}
