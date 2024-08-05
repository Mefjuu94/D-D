package org.example.UserService;

import org.example.ApiServiceConnections.*;
import org.example.Character.CharacterClass;
import org.example.Character.Feature;
import org.example.Character.Mappers.MapCharacterClass;
import org.example.Character.Mappers.MapFeatures;
import org.example.Character.Mappers.MapRace;
import org.example.Character.Mappers.MapSpells;
import org.example.Character.Race;
import org.example.Character.Spell;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private Scanner scanner = new Scanner(System.in);
    protected int numberInput;

    private String characterName; //    First, user is prompted about the name of the character;
    private int raceIndex = 99;//    Second user is prompted about the race;
    private int classIndex = 99;//    Third user is prompted about the class;

    private final ArrayList<Spell> mySpells = new ArrayList<>();//    Fourth user is able to select spells/cantrips if available (can be done via a list and number of the spell);
    private final List<Feature> featureList = new ArrayList<>();
    private String backStory;//    Fifth user can write background for the character;
    private final HttpClient client = HttpClient.newHttpClient();

//    At the end character is saved to the file with character name as title of the file.

    public UserService(Scanner scanner){
        this.scanner = scanner;
    }

    public UserService(){
    }

    public String getCharacterName() {
        System.out.println("Set name of your character:");
        characterName = scanner.nextLine();
        while (!ValidationService.onlyAlphabets(characterName) ||
                characterName.length() > 25 || characterName.length() < 3) {
            System.out.println("Character name is wrong!\n*Lenght > 3\n*Only Alphabets!\n*No whitespaces\nTry again!");
            characterName = scanner.nextLine();
        }
        return characterName;
    }

    public Race chooseRace() {
        System.out.println("Select your Race:");

        RaceInformationHandler raceInformationHandler = new RaceInformationHandler(client);
        MapRace mapRace = new MapRace();

        for (int i = 0; i < ApiConnectionConstants.RACES.length; i++) {
            System.out.println(i + ". " + ApiConnectionConstants.RACES[i]);
        }

        String input = scanner.nextLine(); //
        while (!ValidationService.onlyDigits(input) || !ifPharseProperly(input) ||
                numberInput > ApiConnectionConstants.RACES.length -1 || numberInput < 0){
            System.out.println("try again! Select number 0-" + (ApiConnectionConstants.RACES.length-1));
            input = scanner.nextLine();
        }
        setRaceIndex(numberInput);
        System.out.println("Your choice: " + ApiConnectionConstants.RACES[raceIndex]);

        return mapRace.mapRace(raceInformationHandler.getRaceInformation(raceIndex).body());
    }

    public CharacterClass chooseClass() {
        System.out.println("Select your Class:");

        ClassInformationHandler classInformationHandler = new ClassInformationHandler(client);
        MapCharacterClass mapCharacterClass = new MapCharacterClass();

        for (int i = 0; i < ApiConnectionConstants.CLASSES.length; i++) {
            System.out.println(i + ". " + ApiConnectionConstants.CLASSES[i]);
        }

        String input = scanner.nextLine();
        while (!ValidationService.onlyDigits(input) || !ifPharseProperly(input) ||
                numberInput > ApiConnectionConstants.CLASSES.length -1 || numberInput < 0){
            System.out.println("try again! Select number 0-" + (ApiConnectionConstants.CLASSES.length-1));
            input = scanner.nextLine();
        }
        setClassIndex(numberInput);
        System.out.println("Your choice: " + ApiConnectionConstants.CLASSES[classIndex]);
        featureList.addAll(featuresOfClass(classIndex));

        return mapCharacterClass.mapCharacterClass(classInformationHandler.getClassInformation(classIndex).body());
    }

    private List<Feature> featuresOfClass(int index) {
        ClassFeaturesHandler classFeaturesHandler = new ClassFeaturesHandler(client);
        MapFeatures mapFeatures = new MapFeatures();
        return mapFeatures.mapClassFeatures(classFeaturesHandler.getClassFeatures(index).body());
    }

    private boolean ifPharseProperly(String input) {
        try {
            setNumberInput(Integer.parseInt(input));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Must be number!");
            return false;
        }
    }

    public ArrayList<Spell> chooseSpells() {

        ClassSpellsHandler classSpellsHandler = new ClassSpellsHandler(client);
        MapSpells mapSpells = new MapSpells();

        ArrayList<Spell> spells = mapSpells.mapClassSpells(classSpellsHandler.getClassSpells(classIndex).body());

        if (spells.size() > 3) {
            System.out.println("Select your (3) spells by number:");

            for (int i = 0; i < spells.size(); i++) {
                System.out.println(i + ". " + spells.get(i).getSpellName() );
            }

            while (mySpells.size() < 3) {
                String input = scanner.nextLine();
                if (!ValidationService.onlyDigits(input) || !ifPharseProperly(input) ||
                        numberInput > spells.size() -1 || numberInput < 0) {
                    System.out.println("try again! Select number 0-" + (spells.size() - 1));
                } else {
                    System.out.println("Your choice: " + spells.get(Integer.parseInt(input)).getSpellName());
                    mySpells.add(spells.get(Integer.parseInt(input)));
                    System.out.println("Select next Spell");
                }
            }
        }
        return mySpells;
    }

    public String backStory(){
        System.out.println("What's your character backstory?\n*MAX 300 AND MIN 1 SIGN!");

        String input = scanner.nextLine();
        while (input.length() > 300 || input.length() < 3 ){
            System.out.println("Something going wrong!\n IT CANT BE EMPTY!\n MAX 300 AND MIN 1 SIGN!\n" );
            input = scanner.nextLine();
        }
        backStory = input;
        return input;
    }

    private void summary(){
            System.out.println("Summary:");
            System.out.println("name: " + characterName +
                    "\nRace: " + ApiConnectionConstants.RACES[raceIndex] +
                    "\nClass: " + ApiConnectionConstants.CLASSES[classIndex] +
                    "\nSpells: " + mySpells +
                    "\nbackstory: " + backStory);
    }

    public void setNumberInput(int numberInput) {
        this.numberInput = numberInput;
    }
    public void setRaceIndex(int raceIndex) {
        this.raceIndex = raceIndex;
    }
    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }
    public List<Feature> getFeatureList() {
        return featureList;
    }

}
