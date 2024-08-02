package org.example.Character;

import java.util.List;

public class CharacterClass {

    private String className;
    private List<String> availableSkills;
    private List<String> proficiencies;
    private List<Item> startingEquipment;

    public CharacterClass(String className, List<String> availableSkills, List<String> proficiencies, List<Item> startingEquipment) {
        this.className = className;
        this.availableSkills = availableSkills;
        this.proficiencies = proficiencies;
        this.startingEquipment = startingEquipment;
    }

    public List<String> getAvailableSkills() {
        return availableSkills;
    }

    public void setAvailableSkills(List<String> availableSkills) {
        this.availableSkills = availableSkills;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Item> getStartingEquipment() {
        return startingEquipment;
    }

    public void setStartingEquipment(List<Item> startingEquipment) {
        this.startingEquipment = startingEquipment;
    }

    public String getClassName() {return className;}

    public void setClassName(String className) {this.className = className;}

    @Override
    public String toString() {
        return "CharacterClass{" +
                "name='" + className + '\'' +
                ", availableSkills=" + availableSkills +
                ", proficiencies=" + proficiencies +
                ", startingEquipment=" + startingEquipment +
                '}';
    }
}
