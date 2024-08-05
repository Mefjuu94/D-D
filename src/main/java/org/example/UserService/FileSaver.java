package org.example.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Character.Character;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.Character.JSONMapper.MAPPER;

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

        List<String> proficences = character.getCharacterClass().getProficiencies();
        List<String> newProficencies = new ArrayList<>();
        if (!proficences.isEmpty()) {
            for (String proficence : proficences) {
                newProficencies.add("&&" + proficence);
            }
            character.getCharacterClass().setProficiencies(newProficencies);
        }

        return makePreetyString(character);
    }

    private String makePreetyString(Object o) {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        // Konwersja obiektu do pretty string

        String mapperString;
        try {
            mapperString = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String emptyListToNoone = mapperString.replaceAll("\\[ ]", "none");
        String deleteAllSigns = emptyListToNoone.replaceAll("[\\[\\]\\{\\},\"\\\\]", "");
        String replaceSkill = deleteAllSigns.replaceAll("Skill:", "\n       skill name: ");
        String repalceProficiencies = replaceSkill.replaceAll("&&", "\n       proficiency name: ");
        String deleteUnnecessaryLines = repalceProficiencies.replaceAll("(?m)^\\s*\\r?\\n|\\r?\\n\\s*(?!.*\\r?\\n)", "");
        String deleteBrackets = deleteUnnecessaryLines.replaceAll("} ],", "");
        String splitCamelCase = deleteBrackets.replaceAll("([a-z])([A-Z])", "$1 $2");
        mapperString = splitCamelCase.replaceAll("  ", " ");

        return mapperString;
    }

    public void saveCharacter(String preetyString) {

        FileWriter writer;
        try {
            writer = new FileWriter(file + "/" + characterName + ".txt");
            writer.write(preetyString);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

}
