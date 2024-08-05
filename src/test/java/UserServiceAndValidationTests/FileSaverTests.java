import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Character.Character;
import org.example.Character.*;
import org.example.UserService.FileSaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSaverTests {

    private final FileSaver testObject = new FileSaver();
    private Character testCharacter;
    List<String> availableSkills = new ArrayList<>();
    List<String> proficiencies1 = new ArrayList<>();
    List<Feature> features = new ArrayList<>();
    List<Spell> spells = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    private Character emptytestCharacter = new Character("Empty",new Race("race",new ArrayList<>(),100,"S",new ArrayList<>(),new ArrayList<>())
           ,"back",features,new CharacterClass("Class",availableSkills,proficiencies1,items),spells,new ArrayList<>(),proficiencies1);

    private Character createTestCharacter() {
        List<AbilityBonus> bonuses = new ArrayList<>();
        bonuses.add(new AbilityBonus("DEX", 2));
        List<String> languages = new ArrayList<>();
        languages.add("Common");
        languages.add("Elvish");
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Perception");

        features.add(new Feature("Divine Sense"));
        features.add(new Feature("Lay on Hands"));

        availableSkills.add("Athletics");
        availableSkills.add("Insight");
        availableSkills.add("Intimidation");
        availableSkills.add("Religion");

        proficiencies1.add("All armor");
        proficiencies1.add("Shields");
        proficiencies1.add("Simple Weapons");
        proficiencies1.add("Martial Weapons");
        proficiencies1.add("Saving Throw: WIS");
        proficiencies1.add("Saving Throw: CHA");

        items.add(new Item("Chain Mail", 1));

        spells.add(new Spell("Bless"));
        spells.add(new Spell("Heroism"));
        spells.add(new Spell("Shield of Faith"));
        List<String> proficiencies2 = new ArrayList<>();
        proficiencies2.add("Perception");
        //String testCharacterToString = "Character{characterName='Test', race=Race{raceName='\"Elf\"', bonuses=[AbilityBonus{bonusName='DEX', value=2}], speed=30, size='[\"Medium\"]', languages=[Common, Elvish], proficiencies=[Skill: Perception]}, backstory='Test Pala', features=[Feature{featureName='Divine Sense'}, Feature{featureName='Lay on Hands'}], characterClass=CharacterClass{className='\"Paladin\"', availableSkills=[Skill: Athletics, Skill: Insight, Skill: Intimidation, Skill: Medicine, Skill: Persuasion, Skill: Religion], proficiencies=[All armor, Shields, Simple Weapons, Martial Weapons, Saving Throw: WIS, Saving Throw: CHA], startingEquipment=[Item{itemName='Chain Mail', quantity=1}]}, spells=[Spell{spellName='Bless'}, Spell{spellName='Heroism'}, Spell{spellName='Shield of Faith'}], languages=[Common, Elvish], proficiencies=[Skill: Perception]}";

        Race testRace = new Race("Elf", new ArrayList<>(), 30, "Medium", new ArrayList<>(), new ArrayList<>());
        testRace.setBonuses(bonuses);
        testRace.setLanguages(languages);
        testRace.setProficiencies(proficiencies);

        CharacterClass testCharacterClass = new CharacterClass("Paladin", availableSkills, proficiencies1, items);
        return new Character("Test", testRace, "Test Pala", features, testCharacterClass, spells, testRace.getLanguages(), testRace.getProficiencies());
    }

    @Test
    public void testIfFileOrCharacterNameExistTrue() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/Characters/Test.txt");
            writer.write("null");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        testCharacter = createTestCharacter();
        Assertions.assertTrue(testObject.checkIfFileOrCharacterExist(testCharacter.getCharacterName()));
    }

    @Test
    public void testIfFileOrCharacterNameExistFalse() {
        testCharacter = createTestCharacter();
        Assertions.assertFalse(testObject.checkIfFileOrCharacterExist("TestCharacterFalse"));
    }

    @Test
    public void createCharacterDescriptionTest() {
        testCharacter = createTestCharacter();
        String preetyString = " character Name : Test\n" +
                " race : \n" +
                "  race Name : Elf\n" +
                "  bonuses : \n" +
                "   bonus Name : DEX\n" +
                "   value : 2\n" +
                "  speed : 30\n" +
                "  size : Medium\n" +
                "  languages : Common Elvish \n" +
                "  proficiencies : Perception \n" +
                " backstory : Test Pala\n" +
                " features : \n" +
                "  feature Name : Divine Sense\n" +
                "  feature Name : Lay on Hands\n" +
                " character Class : \n" +
                "  class Name : Paladin\n" +
                "  available Skills : Athletics Insight Intimidation Religion \n" +
                "  proficiencies : \n" +
                "    proficiency name: All armor \n" +
                "    proficiency name: Shields \n" +
                "    proficiency name: Simple Weapons \n" +
                "    proficiency name: Martial Weapons \n" +
                "    proficiency name: Saving Throw: WIS \n" +
                "    proficiency name: Saving Throw: CHA \n" +
                "  starting Equipment : \n" +
                "   item Name : Chain Mail\n" +
                "   quantity : 1\n" +
                " spells : \n" +
                "  spell Name : Bless\n" +
                "  spell Name : Heroism\n" +
                "  spell Name : Shield of Faith\n" +
                " languages : Common Elvish \n" +
                " proficiencies : Perception ";

        Assertions.assertEquals(preetyString.replaceAll("\r", ""),
                testObject.createCharacterDescription(testCharacter).replaceAll("\r", ""));
        //because "contents have diferences only in line separators"
    }

    @Test
    public void createCharacterDescriptionTestFail() {
        testCharacter = createTestCharacter();
        String preetyString = "Nothing interesting here";
        Assertions.assertNotEquals(preetyString.replaceAll("\r", ""),
                testObject.createCharacterDescription(testCharacter).replaceAll("\r", ""));
    }


    //TODO end this method and method who save file need to be done!
    @Test
    public void createCharacterDescriptionTestEmptyFail() {
        String preetyString = "Nothing interesting here";
        Assertions.assertEquals("Exception.class",
                testObject.createCharacterDescription(emptytestCharacter));
    }

}
