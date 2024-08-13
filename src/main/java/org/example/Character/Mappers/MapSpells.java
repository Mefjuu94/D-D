package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.Character.Feature;
import org.example.Character.Spell;

import java.util.ArrayList;

import static org.example.Character.JSONMapper.MAPPER;

public class MapSpells {

    public ArrayList<Spell> mapClassSpells(String JSON) {
        try {
            JsonNode jsonNode = MAPPER.readTree(JSON);
            ArrayList<Spell> spellsList = new ArrayList<>();
            Object[] spell = jsonNode.get("results").findValuesAsText("name").toArray();
            for (Object o : spell) {
                spellsList.add(new Spell(o.toString()));
            }
            return spellsList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
