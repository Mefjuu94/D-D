package org.example.Character.Mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.Character.Feature;

import java.util.ArrayList;

import static org.example.Character.JSONMapper.MAPPER;

public class MapFeatures {

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
}
