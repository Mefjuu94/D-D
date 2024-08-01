package org.example;

import org.example.Character.Character;
import org.example.Character.*;
import org.example.UserService.UserService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        UserService userService = new UserService();

        //String name = userService.getCharacterName();
        //Race race = userService.chooseRace();

        userService.chooseClass();
        System.out.println(userService.backStory());

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