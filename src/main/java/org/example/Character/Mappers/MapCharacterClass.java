package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.Character.AbilityBonus;
import org.example.Character.CharacterClass;
import org.example.Character.Item;
import org.example.Character.Race;

import java.util.ArrayList;
import java.util.List;

import static org.example.Character.JSONMapper.MAPPER;

public class MapCharacterClass {

    public CharacterClass mapCharacterClass(String JSON) {
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);

            List<String> avaibleSkills = new ArrayList<>();
            List<String> startingProficences = new ArrayList<>();
            List<Item> startingEquipment = new ArrayList<>();

            Object[] skills = jsonNode.path("proficiency_choices").findValuesAsText("name").toArray();
            System.out.println();
            for (Object skill : skills) {
                String name = skill.toString();
                avaibleSkills.add(name);
            }

            Object[] proficences = jsonNode.get("proficiencies").findValuesAsText("name").toArray();
            for (Object proficence : proficences) {
                String name = proficence.toString();
                startingProficences.add(name);
            }

            Object[] items = jsonNode.path("starting_equipment").findValuesAsText("name").toArray();
            Object[] quantityItems = jsonNode.path("starting_equipment").findValuesAsText("quantity").toArray();
            for (int i = 0; i < items.length; i++) {
                String name = items[i].toString();
                int quantityOfItem = Integer.parseInt(quantityItems[i].toString());
                startingEquipment.add(new Item(name,quantityOfItem));
            }

            return new CharacterClass(avaibleSkills, startingProficences, startingEquipment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
