package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.Character.AbilityBonus;

import static org.example.Character.JSONMapper.MAPPER;

public class MapAbilityBonus {


    public AbilityBonus mapClassFeatures(String JSON){
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);


            return new AbilityBonus("",0);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
