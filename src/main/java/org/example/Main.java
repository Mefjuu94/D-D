package org.example;

import org.example.Character.Character;
import org.example.Character.CharacterClass;
import org.example.Character.Race;
import org.example.Character.Spell;
import org.example.UserService.FileSaver;
import org.example.UserService.UserService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        UserService userService = new UserService();
        FileSaver fileSaver = new FileSaver();

        String name = userService.getCharacterName();

        while (fileSaver.checkIfFileOrCharacterExist(name)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Character " + name + " arleady exist! Change name:");
            name = (scanner.nextLine());
        }

        Race race = userService.chooseRace();
        CharacterClass characterClass = userService.chooseClass();
        List<Spell> spells = userService.chooseSpells();
        String backStory = userService.backStory();

        Character character = new Character(name,race,backStory,userService.getFeatureList(),characterClass,spells,race.getLanguages(),race.getProficiencies());

        fileSaver.saveCharacter(fileSaver.createCharacterDescription(character));

    }
}