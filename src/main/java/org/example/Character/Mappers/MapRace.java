package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.Character.AbilityBonus;
import org.example.Character.Race;

import java.util.ArrayList;
import java.util.List;

import static org.example.Character.JSONMapper.MAPPER;

public class MapRace {

    public Race mapRace(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);

            //System.out.println(JSON);

            List<AbilityBonus> bonuses = new ArrayList<>();
            Object[] bonusName = jsonNode.get("ability_bonuses").findValuesAsText("name").toArray();
            Object[] bonusValue = jsonNode.get("ability_bonuses").findValuesAsText("bonus").toArray();

            for (int i = 0; i <bonusName.length ; i++) {
                // System.out.println("bonuses! " + bonusName[i] + " " + bonusValue[i]);
                String name = bonusName[i].toString();
                int value = Integer.parseInt(bonusValue[i].toString());
                bonuses.add(new AbilityBonus(name,value));
            }

            String speedString = jsonNode.get("speed").toString();
            int speed = Integer.parseInt(speedString);

            String size = jsonNode.findValues("size").toString();
            //System.out.println("size: " + size);

            List<String> languages = new ArrayList<>();
            JsonNode languagesNode = jsonNode.path("languages");
            for (JsonNode language : languagesNode) {
                languages.add(language.path("name").asText());
            }
            //System.out.println("languages: " + languages);

            List<String> proficiencies = new ArrayList<>();
            JsonNode proficencesNode = jsonNode.path("starting_proficiencies");
            for (JsonNode profi : proficencesNode) {
                proficiencies.add(profi.path("name").asText());
            }
            //System.out.println("proficences: " + proficiencies);

            return new Race(bonuses,speed,size,languages,proficiencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
