package org.example.Character;

import java.util.List;

public class Character {

    private String name;
    private Race race;
    private String backstory;
    private List<Feature> features;
    private Class Class;
    private List<Spell> spells;
    private List<String> languages;
    private List<String> proficiencies;

    public Character(String name, Race race, String backstory, List<Feature> features, java.lang.Class aClass, List<Spell> spells, List<String> languages, List<String> proficiencies) {
        this.name = name;
        this.race = race;
        this.backstory = backstory;
        this.features = features;
        Class = aClass;
        this.spells = spells;
        this.languages = languages;
        this.proficiencies = proficiencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }



    public void setClass(java.lang.Class aClass) {
        Class = aClass;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
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
        return "Character{" +
                "name='" + name + '\'' +
                ", race=" + race +
                ", backstory='" + backstory + '\'' +
                ", features=" + features.toString() +
                ", Class=" + Class +
                ", spells=" + spells +
                ", languages=" + languages +
                ", proficiencies=" + proficiencies +
                '}';
    }
}
