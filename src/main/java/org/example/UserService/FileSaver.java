package org.example.UserService;

import org.example.Character.*;
import org.example.Character.Character;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FileSaver {

    private final File file = new File("src/main/resources/Characters/");
    private String characterName = "";

    public boolean checkIfFileOrCharacterExist(String name) {
        List<String> files = List.of(Objects.requireNonNull(file.list()));
        System.out.println("Names used: " + files);

        return files.contains(name + ".txt");
    }

    public String createCharacterDescription(Character character) {
        setCharacterName(character.getCharacterName());
        return makePrettyString(character);
    }

    private String makePrettyString(Character character) {

        String prettyString = "";

        String characterName = "*character name: " + character.getCharacterName() + "\n";
        String nameRaceString = "*race: " + character.getRace().getRaceName() + "\n";
        List<AbilityBonus> ab = character.getRace().getBonuses();
        String raceBonuses = "";
        for (AbilityBonus abilityBonus : ab) {
            raceBonuses = raceBonuses + "- " + abilityBonus.getBonusName() + " | value: " + abilityBonus.getValue() + "\n";
        }
        raceBonuses = "*race bonuses: \n" + raceBonuses;

        String speed = "*speed: " + character.getRace().getSpeed() + "\n";
        String size = "*size: " + character.getRace().getSize() + "\n";
        String languages = "*languages: " + character.getRace().getLanguages().toString() + "\n";

        String raceProficiencies = "*race proficiencies: \n";
        List<String> raceProficienciesList = character.getRace().getProficiencies();
        if (character.getRace().getProficiencies().isEmpty()) {
            raceProficiencies = "*race proficiencies: none" + "\n";
        } else
        for (String s : raceProficienciesList) {
            raceProficiencies = raceProficiencies + "- " + s + "\n";
        }

        String backstory = "*backstory:\n" + character.getBackstory() + "\n";
        String features = "*features: \n";
        List<Feature> fet = character.getFeatures();
        if (character.getFeatures().isEmpty()) {
            features = "*features: none" + "\n";
        } else
            for (Feature feature : fet) {
                features = features + "- " + feature.getFeatureName() + "\n";
            }

        String characterClassName = "*class name: " + character.getCharacterClass().getClassName() + "\n";

        String characterClassSkills = "*class skills: \n";
        List<String> characterClassSkillsList = character.getCharacterClass().getAvailableSkills();
        if (characterClassSkillsList.isEmpty()) {
            characterClassSkills = "*class skills: none" + "\n";
        } else
            for (String s : characterClassSkillsList) {
                characterClassSkills = characterClassSkills + "- " + s + "\n";
            }
        characterClassSkills = characterClassSkills.replaceAll("Skill: ", "");


        String characterClassProficiencies = "*class proficiencies: \n";
        List<String> characterClassproficienciessList = character.getCharacterClass().getProficiencies();
        if (characterClassproficienciessList.isEmpty()) {
            characterClassSkills = "*class proficiencies: none" + "\n";
        } else
            for (String s : characterClassproficienciessList) {
                characterClassProficiencies = characterClassProficiencies + "- " + s + "\n";
            }
        characterClassProficiencies = characterClassProficiencies.replaceAll("proficiency name: ", "");


        String startingEquipment = "*starting equipment: \n";
        List<Item> startingEquipmentList = character.getCharacterClass().getStartingEquipment();
        if (startingEquipmentList.isEmpty()) {
            startingEquipment = "*starting equipment: empty equipment\n";
        } else
            for (Item item : startingEquipmentList) {
                startingEquipment = startingEquipment + "- " + item.getItemName() + " | quantity: " + item.getQuantity() + "\n";
            }


        String spells = "*spells: \n";
        List<Spell> spellsList = character.getSpells();
        if (spellsList.isEmpty()) {
            spells = "*spells: none\n";
        } else
            for (Spell spell : spellsList) {
                spells = spells + "- " + spell.getSpellName() + "\n";
            }


        prettyString = characterName + nameRaceString + raceBonuses + speed + size + languages + raceProficiencies +
                backstory + features + characterClassName + characterClassSkills +
                characterClassProficiencies + startingEquipment + spells;

        prettyString = prettyString.replaceAll("[\\[\\]]", "");

        System.out.println(prettyString);

        return prettyString;
    }

    public boolean saveCharacter(String preetyString) {

        FileWriter writer;
        try {
            writer = new FileWriter(file + "/" + characterName + ".txt");
            writer.write(preetyString);
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

}