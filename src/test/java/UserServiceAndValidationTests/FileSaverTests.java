import org.example.Character.Character;
import org.example.Character.*;
import org.example.UserService.FileSaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private Character emptytestCharacter = new Character("Empty", new Race("race", new ArrayList<>(), 100, "S", new ArrayList<>(), new ArrayList<>())
            , "back", features, new CharacterClass("Class", availableSkills, proficiencies1, items), spells, new ArrayList<>(), proficiencies1);


    @TempDir
    static Path tempDir;


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
    public void testIfFileOrCharacterNameExistTrue() throws IOException {
        Path specificDir = Paths.get("src/main/resources/Characters");

        if (!Files.exists(specificDir)) {
            Files.createDirectories(specificDir);
        }

        Path tempFile = specificDir.resolve("Test.txt");
        if (!Files.exists(tempFile)) {
            Files.createFile(tempFile);
        }

        tempFile.toFile().deleteOnExit();

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
        String preetyString = "*character name: Test\n" +
                "*race: Elf\n" +
                "*race bonuses: \n" +
                "- DEX | value: 2\n" +
                "*speed: 30\n" +
                "*size: Medium\n" +
                "*languages: Common, Elvish\n" +
                "*race proficiencies: \n" +
                "- Perception\n" +
                "*backstory:\n" +
                "Test Pala\n" +
                "*features: \n" +
                "- Divine Sense\n" +
                "- Lay on Hands\n" +
                "*class name: Paladin\n" +
                "*class skills: \n" +
                "- Athletics\n" +
                "- Insight\n" +
                "- Intimidation\n" +
                "- Religion\n" +
                "*class proficiencies: \n" +
                "- All armor\n" +
                "- Shields\n" +
                "- Simple Weapons\n" +
                "- Martial Weapons\n" +
                "- Saving Throw: WIS\n" +
                "- Saving Throw: CHA\n" +
                "*starting equipment: \n" +
                "- Chain Mail | quantity: 1\n" +
                "*spells: \n" +
                "- Bless\n" +
                "- Heroism\n" +
                "- Shield of Faith\n";

        Assertions.assertEquals(preetyString.replaceAll("\r", ""),
                testObject.createCharacterDescription(testCharacter).replaceAll("\r", ""));
        //because "contents have diferences only in line separators"
    }

    @Test
    public void testIfFileIsSavedCorrectly() {
        testCharacter = createTestCharacter();
        Path specificDir = Paths.get("src/main/resources/Characters");
        Path tempFile = specificDir.resolve("Test.txt");
        if (!Files.exists(tempFile) && !Files.exists(specificDir)) {
            tempFile = specificDir.resolve("Test.txt");
        }
        tempFile.toFile().deleteOnExit();
        Assertions.assertTrue(testObject.saveCharacter(testObject.createCharacterDescription(testCharacter)));
    }

}
