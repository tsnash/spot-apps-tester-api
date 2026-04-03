package net.spotapps.tester.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "life_stages")
public class LifeStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "life_stage_id")
    private Long lifeStageId;

    @NotNull
    @Column(name = "name", nullable = false, unique = true, updatable = false)
    private String name;

    public LifeStage() {
    }

    public LifeStage(String name) {
        setName(name);
    }

    public Long getLifeStageId() {
        return lifeStageId;
    }

    public void setLifeStageId(Long lifeStageId) {
        this.lifeStageId = lifeStageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LifeStage))
            return false;
        LifeStage that = (LifeStage) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "LifeStage [lifeStageId=" + lifeStageId + ", name=" + name + "]";
    }
}
