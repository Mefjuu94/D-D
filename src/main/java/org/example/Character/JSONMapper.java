package org.example.Character;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;

public class JSONMapper {

    public final JsonMapper MAPPER = new JsonMapper();

    //Mappers have been created for Race, AbilityBonus, Class, Feature, Spell;

    public Race mapRace(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);

            List<AbilityBonus> bonuses = new ArrayList<>();
            Object[] bonusName = jsonNode.get("ability_bonuses").findValuesAsText("name").toArray();
            Object[] bonusValue = jsonNode.get("ability_bonuses").findValuesAsText("bonus").toArray();

            for (int i = 0; i <bonusName.length ; i++) {
                System.out.println("bonuses! " + bonusName[i] + " " + bonusValue[i]);
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

            List<String> proficiencies = new ArrayList<>();  //co to jest?
//            JsonNode proficencesNode = jsonNode.path("proficiencies").path();
//            for (JsonNode profi : proficencesNode) {
//                proficiencies.add(profi.path("name").asText());
//            }
//            System.out.println("proficences: " + proficiencies);

            return new Race(bonuses,speed,size,languages,proficiencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Feature> mapClassFeatures(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);
            List<Feature> featureList = new ArrayList<>();
            String feature = jsonNode.findValues("name").toString();
            featureList.add(new Feature(feature));
            return featureList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO OGARNĄĆ KTÓrE TO SPELE KLASOWE
    public List<Spells> mapClassSpells(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);
            List<Spells> spellList = new ArrayList<>();
            String spell = jsonNode.findValues("name").toString();

            return spellList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }




}
