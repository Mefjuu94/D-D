package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.Character.AbilityBonus;
import org.example.Character.Race;

import java.util.ArrayList;
import java.util.List;

import static org.example.Character.JSONMapper.MAPPER;

public class MapRace {

    public Race mapRace(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);


            List<AbilityBonus> bonuses = new ArrayList<>();
            ArrayNode bonusesArray = (ArrayNode) jsonNode.get("ability_bonuses");
            MapAbilityBonus mapAbilityBonus = new MapAbilityBonus();
            bonuses = mapAbilityBonus.mapAbilityBonus(bonusesArray);


            String speedString = jsonNode.get("speed").toString();
            int speed = Integer.parseInt(speedString);

            String size = jsonNode.findValues("size").toString();

            List<String> languages = new ArrayList<>();
            JsonNode languagesNode = jsonNode.path("languages");
            for (JsonNode language : languagesNode) {
                languages.add(language.path("name").asText());
            }

            List<String> proficiencies = new ArrayList<>();
            JsonNode proficencesNode = jsonNode.path("starting_proficiencies");
            for (JsonNode profi : proficencesNode) {
                proficiencies.add(profi.path("name").asText());
            }

            return new Race(bonuses,speed,size,languages,proficiencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
