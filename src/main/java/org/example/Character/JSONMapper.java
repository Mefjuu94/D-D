package org.example.Character;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;

public class JSONMapper {

    public static final JsonMapper MAPPER = new JsonMapper();

    //Mappers have been created for Race, AbilityBonus, Class, Feature, Spell;

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



    public ArrayList<Feature> mapClassFeatures(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);
            ArrayList<Feature> featureList = new ArrayList<>();
            Feature feature = new Feature(jsonNode.get("results").findValuesAsText("name").toString());
            featureList.add(feature);
            return featureList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO OGARNĄĆ KTÓrE TO SPELE KLASOWE
    public ArrayList<Spell> mapClassSpells(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);
            ArrayList<Spell> spellsList = new ArrayList<>();
            Spell spell = new Spell(jsonNode.get("results").findValuesAsText("name").toString());
            spellsList.add(spell);
            return spellsList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }




}
