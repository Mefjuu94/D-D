package org.example.Character;

import java.util.List;

public class Character {

    private String characterName;
    private Race race;
    private String backstory;
    private List<Feature> features;
    private CharacterClass characterClass;
    private List<Spell> spells;
    private List<String> languages;
    private List<String> proficiencies;

    public Character(String characterName, Race race, String backstory, List<Feature> features, CharacterClass characterClass, List<Spell> spells, List<String> languages, List<String> proficiencies) {
        this.characterName = characterName;
        this.race = race;
        this.backstory = backstory;
        this.features = features;
        this.characterClass = characterClass;
        this.spells = spells;
        this.languages = languages;
        this.proficiencies = proficiencies;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
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
                "characterName='" + characterName + '\'' +
                ", race=" + race +
                ", backstory='" + backstory + '\'' +
                ", features=" + features +
                ", characterClass=" + characterClass +
                ", spells=" + spells +
                ", languages=" + languages +
                ", proficiencies=" + proficiencies +
                '}';
    }
}
