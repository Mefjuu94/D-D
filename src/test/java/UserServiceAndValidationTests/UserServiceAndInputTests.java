import org.example.Character.Feature;
import org.example.Character.Spell;
import org.example.UserService.ValidationService;
import org.example.UserService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceAndInputTests {

    @Mock
    private Scanner scanner;
    private UserService userService;

    private void setScannerResponse(String response) {
        when(scanner.nextLine()).thenReturn(response);
    }

    private void setScannerMultipleResponseForSpellsTest(String first, String second, String third, String fourth) {
        when(scanner.nextLine()).thenReturn(first).thenReturn(second).thenReturn(third).thenReturn(fourth);
    }

    @Test
    public void getCharacterNameUnHappyTest() {
        setScannerMultipleResponseForSpellsTest("it", "12a", "aLongNicknameAboweMaxLenght", "OkNickname");
        userService = new UserService(scanner);
        Assertions.assertEquals("OkNickname", userService.getCharacterName());
    }

    @Test
    public void getCharacterRaceHappyTest() {
        setScannerMultipleResponseForSpellsTest("99", "-1", "avca", "5"); //half-orc
        String response = "Race{raceName='\"Half-Orc\"', bonuses=[AbilityBonus{name='STR', value=2}, AbilityBonus{name='CON', value=1}], speed=30, size='[\"Medium\"]', languages=[Common, Orc], proficiencies=[Skill: Intimidation]}";
        userService = new UserService(scanner);
        Assertions.assertEquals(response, userService.chooseRace().toString());
    }

    @Test
    public void getCharacterClassHappyTest() {
        setScannerMultipleResponseForSpellsTest("-1", " 999 213", "somethingWrong", "8"); // rogue
        String response = "CharacterClass{name='\"Rogue\"', availableSkills=[Skill: Acrobatics, Skill: Athletics, Skill: Deception, Skill: Insight, Skill: Intimidation, Skill: Investigation, Skill: Perception, Skill: Performance, Skill: Persuasion, Skill: Sleight of Hand, Skill: Stealth], proficiencies=[Light Armor, Simple Weapons, Longswords, Rapiers, Shortswords, Hand crossbows, Thieves' Tools, Saving Throw: DEX, Saving Throw: INT], startingEquipment=[Item{name='Leather Armor', quantity=1}, Item{name='Dagger', quantity=2}, Item{name='Thieves' Tools', quantity=1}]}";
        userService = new UserService(scanner);
        Assertions.assertEquals(response, userService.chooseClass().toString());
    }

    @Test
    public void getFeatureListHappyTest() {
        setScannerResponse("8");
        userService = new UserService(scanner);
        List<Feature> result = new ArrayList<>();
        result.add(new Feature("Expertise"));
        result.add(new Feature("Sneak Attack"));
        result.add(new Feature("Thieves' Cant"));
        userService.chooseClass();
        Assertions.assertEquals(result, userService.getFeatureList());
    }

    @Test
    public void chooseSpellsHappyTest() {
        userService = new UserService(scanner);
        List<Spell> result = new ArrayList<>();
        result.add(new Spell("Burning Hands")); //0
        result.add(new Spell("Shield"));        //13
        result.add(new Spell("Sleep"));         //15

        setScannerMultipleResponseForSpellsTest("9", "-1", "adda", "155");
        userService.chooseClass();
        setScannerMultipleResponseForSpellsTest("023 ad", "0", "13", "15");
        Assertions.assertEquals(result, userService.chooseSpells());
        List<Spell> emptyResult = new ArrayList<>();

        userService = new UserService(scanner);
        setScannerResponse("0");
        userService.chooseClass();

        Assertions.assertEquals(emptyResult, userService.chooseSpells()); // barbarian has no spells
    }

    @Test
    public void chooseCharacterBackstoryUnhappyAndHappyPathTest() {
        userService = new UserService(scanner);
        String result = "At least good Result";
        setScannerMultipleResponseForSpellsTest("", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mattis varius mollis. Integer tempor sodales venenatis. Curabitur facilisis tempor dapibus. Cras eu odio diam. Donec gravida placerat arcu, at pellentesque massa blandit nec. Nulla sodales quis mi euismod pellentesque. Curabitur non tincidunt odio. Suspendisse tristique sagittis mattis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam id dui lacus. Duis egestas felis vitae elementum iaculis. Proin semper magna nisi, in posuere metus tincidunt in. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur vehicula ante ut ipsum venenatis, a ultricies ipsum molestie. Vivamus eu interdum leo. Cras quis vestibulum arcu. Curabitur id felis et sapien semper faucibus. Praesent ultricies mi vel quam rutrum finibus. Proin non mollis sem. Maecenas lobortis, orci ut auctor dapibus, lacus elit ullamcorper justo, pellentesque dapibus orci eros sit amet nunc. Praesent a volutpat lacus. Suspendisse efficitur ligula eget arcu ornare, vel varius nulla ultrices. Praesent efficitur tincidunt diam, eu volutpat leo finibus nec. Cras tincidunt tempor ex, a bibendum velit facilisis et. Mauris quis libero quis enim efficitur gravida. Donec dictum hendrerit risus, malesuada ullamcorper metus fringilla a. Pellentesque condimentum convallis efficitur. In blandit lacus id metus fermentum malesuada. Cras vestibulum odio ut orci tincidunt, hendrerit auctor leo laoreet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut dui est.",
                "", "At least good Result"); // should 3times repeat 1. abowe required, 2. too long string, 3. empty string 4. OK String should pass

        Assertions.assertEquals(result, userService.backStory());
    }
}
