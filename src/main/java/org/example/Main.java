package org.example;

import org.example.ApiServiceConnections.ClassInformationHandler;
import org.example.ApiServiceConnections.RaceInformationHandler;
import org.example.Character.Character;
import org.example.Character.*;
import org.example.Character.Mappers.MapCharacterClass;
import org.example.Character.Mappers.MapRace;
import org.example.UserService.UserService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        UserService userService = new UserService();

        //String name = userService.getCharacterName();
        //Race race = userService.chooseRace();

//        userService.chooseClass();
        MapRace mapc = new MapRace();
        RaceInformationHandler cls = new RaceInformationHandler(HttpClient.newHttpClient());
        String s = cls.getRaceInformation(7).body();
        Race c = mapc.mapRace(s);

        System.out.println(c.getRaceName());




//        CharacterClass characterClass = userService.chooseClass();
//        List<Spell> spells = userService.chooseSpells();
//
//        String backStory = userService.backStory();
//
//
//        Character character = new Character(name,race,backStory,userService.getFeatureList(),characterClass,spells,race.getLanguages(),race.getProficiencies());
//        System.out.println(character.toString());
    }
}