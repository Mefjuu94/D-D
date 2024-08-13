package org.example.Character;

import java.util.List;

public class Race {

    private String raceName;
    private List<AbilityBonus> bonuses;
    private int speed;
    private String size;
    private List<String> languages;
    private List<String> proficiencies;

    public Race(String raceName,List<AbilityBonus> bonuses, int speed, String size, List<String> languages, List<String> proficiencies) {
        this.raceName = raceName;
        this.bonuses = bonuses;
        this.speed = speed;
        this.size = size;
        this.languages = languages;
        this.proficiencies = proficiencies;
    }

    public String getRaceName() {return raceName;}

    public void setRaceName(String raceName) {this.raceName = raceName;}

    public List<AbilityBonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<AbilityBonus> bonuses) {
        this.bonuses = bonuses;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceName='" + raceName + '\'' +
                ", bonuses=" + bonuses +
                ", speed=" + speed +
                ", size='" + size + '\'' +
                ", languages=" + languages +
                ", proficiencies=" + proficiencies +
                '}';
    }
}
