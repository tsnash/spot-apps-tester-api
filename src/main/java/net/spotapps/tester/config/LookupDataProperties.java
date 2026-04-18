package net.spotapps.tester.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tester.lookups")
public class LookupDataProperties {

    private List<String> genders;
    private List<String> orientations;
    private List<String> personalityScales;
    private List<String> relationshipStatuses;
    private List<String> relationshipPractices;
    private List<String> relationshipInterests;
    private List<ReligionProperties> religions;
    private List<String> lifeStages;
    private List<String> childGenders;
    private List<String> householdStatuses;
    private List<String> educationDegrees;
    private List<String> fluencyLevels;
    private List<String> viceTypes;
    private List<String> viceFrequencies;
    private List<String> petTypes;
    private List<String> travelFrequencies;
    private List<String> travelDurations;
    private List<String> travelDistances;
    private List<String> travelGroupSizes;

    public List<String> getGenders() {
        return genders;
    }

    public void setGenders(List<String> genders) {
        this.genders = genders;
    }

    public List<String> getOrientations() {
        return orientations;
    }

    public void setOrientations(List<String> orientations) {
        this.orientations = orientations;
    }

    public List<String> getPersonalityScales() {
        return personalityScales;
    }

    public void setPersonalityScales(List<String> personalityScales) {
        this.personalityScales = personalityScales;
    }

    public List<String> getRelationshipStatuses() {
        return relationshipStatuses;
    }

    public void setRelationshipStatuses(List<String> relationshipStatuses) {
        this.relationshipStatuses = relationshipStatuses;
    }

    public List<String> getRelationshipPractices() {
        return relationshipPractices;
    }

    public void setRelationshipPractices(List<String> relationshipPractices) {
        this.relationshipPractices = relationshipPractices;
    }

    public List<String> getRelationshipInterests() {
        return relationshipInterests;
    }

    public void setRelationshipInterests(List<String> relationshipInterests) {
        this.relationshipInterests = relationshipInterests;
    }

    public List<ReligionProperties> getReligions() {
        return religions;
    }

    public void setReligions(List<ReligionProperties> religions) {
        this.religions = religions;
    }

    public List<String> getLifeStages() {
        return lifeStages;
    }

    public void setLifeStages(List<String> lifeStages) {
        this.lifeStages = lifeStages;
    }

    public List<String> getChildGenders() {
        return childGenders;
    }

    public void setChildGenders(List<String> childGenders) {
        this.childGenders = childGenders;
    }

    public List<String> getHouseholdStatuses() {
        return householdStatuses;
    }

    public void setHouseholdStatuses(List<String> householdStatuses) {
        this.householdStatuses = householdStatuses;
    }

    public List<String> getEducationDegrees() {
        return educationDegrees;
    }

    public void setEducationDegrees(List<String> educationDegrees) {
        this.educationDegrees = educationDegrees;
    }

    public List<String> getFluencyLevels() {
        return fluencyLevels;
    }

    public void setFluencyLevels(List<String> fluencyLevels) {
        this.fluencyLevels = fluencyLevels;
    }

    public List<String> getViceTypes() {
        return viceTypes;
    }

    public void setViceTypes(List<String> viceTypes) {
        this.viceTypes = viceTypes;
    }

    public List<String> getViceFrequencies() {
        return viceFrequencies;
    }

    public void setViceFrequencies(List<String> viceFrequencies) {
        this.viceFrequencies = viceFrequencies;
    }

    public List<String> getPetTypes() {
        return petTypes;
    }

    public void setPetTypes(List<String> petTypes) {
        this.petTypes = petTypes;
    }

    public List<String> getTravelFrequencies() {
        return travelFrequencies;
    }

    public void setTravelFrequencies(List<String> travelFrequencies) {
        this.travelFrequencies = travelFrequencies;
    }

    public List<String> getTravelDurations() {
        return travelDurations;
    }

    public void setTravelDurations(List<String> travelDurations) {
        this.travelDurations = travelDurations;
    }

    public List<String> getTravelDistances() {
        return travelDistances;
    }

    public void setTravelDistances(List<String> travelDistances) {
        this.travelDistances = travelDistances;
    }

    public List<String> getTravelGroupSizes() {
        return travelGroupSizes;
    }

    public void setTravelGroupSizes(List<String> travelGroupSizes) {
        this.travelGroupSizes = travelGroupSizes;
    }

    public static class ReligionProperties {
        private String name;
        private String branch;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }
    }
}
