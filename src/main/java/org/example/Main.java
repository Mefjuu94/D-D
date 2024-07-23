package org.example;

import org.example.ApiServiceConnections.*;
import org.example.Character.*;
import org.example.Character.Mappers.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        //features zwraca ArrayList<feature>

        String temp = "{\n" +
                "  \"index\": \"elf\",\n" +
                "  \"name\": \"Elf\",\n" +
                "  \"speed\": 30,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"dex\",\n" +
                "        \"name\": \"DEX\",\n" +
                "        \"url\": \"/api/ability-scores/dex\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    }\n" +
                "  ],\n" +
                "  \"age\": \"Although elves reach physical maturity at about the same age as humans, the elven understanding of adulthood goes beyond physical growth to encompass worldly experience. An elf typically claims adulthood and an adult name around the age of 100 and can live to be 750 years old.\",\n" +
                "  \"alignment\": \"Elves love freedom, variety, and self-expression, so they lean strongly toward the gentler aspects of chaos. They value and protect others' freedom as well as their own, and they are more often good than not.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [\n" +
                "    {\n" +
                "      \"index\": \"skill-perception\",\n" +
                "      \"name\": \"Skill: Perception\",\n" +
                "      \"url\": \"/api/proficiencies/skill-perception\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"elvish\",\n" +
                "      \"name\": \"Elvish\",\n" +
                "      \"url\": \"/api/languages/elvish\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Elvish. Elvish is fluid, with subtle intonations and intricate grammar. Elven literature is rich and varied, and their songs and poems are famous among other races. Many bards learn their language so they can add Elvish ballads to their repertoires.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"darkvision\",\n" +
                "      \"name\": \"Darkvision\",\n" +
                "      \"url\": \"/api/traits/darkvision\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"fey-ancestry\",\n" +
                "      \"name\": \"Fey Ancestry\",\n" +
                "      \"url\": \"/api/traits/fey-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"trance\",\n" +
                "      \"name\": \"Trance\",\n" +
                "      \"url\": \"/api/traits/trance\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"keen-senses\",\n" +
                "      \"name\": \"Keen Senses\",\n" +
                "      \"url\": \"/api/traits/keen-senses\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [\n" +
                "    {\n" +
                "      \"index\": \"high-elf\",\n" +
                "      \"name\": \"High Elf\",\n" +
                "      \"url\": \"/api/subraces/high-elf\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"url\": \"/api/races/elf\"\n" +
                "}";



        MapRace mapRace = new MapRace();
        mapRace.mapRace(temp);







    }
}