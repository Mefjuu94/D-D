import org.example.Character.Mappers.MapSpells;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapSpellsTests {
    //index 7
    private final String outputMapper = "[Spells{spellName='[Alarm, Animal Friendship, Cure Wounds, Detect Magic, Detect Poison and Disease, Fog Cloud, Goodberry, Hunter's Mark, Jump, Longstrider, Speak with Animals]'}]";
    private final String outputResponseBody = "{\"count\":11,\"results\":[{\"index\":\"alarm\",\"name\":\"Alarm\",\"url\":\"/api/spells/alarm\"},{\"index\":\"animal-friendship\",\"name\":\"Animal Friendship\",\"url\":\"/api/spells/animal-friendship\"},{\"index\":\"cure-wounds\",\"name\":\"Cure Wounds\",\"url\":\"/api/spells/cure-wounds\"},{\"index\":\"detect-magic\",\"name\":\"Detect Magic\",\"url\":\"/api/spells/detect-magic\"},{\"index\":\"detect-poison-and-disease\",\"name\":\"Detect Poison and Disease\",\"url\":\"/api/spells/detect-poison-and-disease\"},{\"index\":\"fog-cloud\",\"name\":\"Fog Cloud\",\"url\":\"/api/spells/fog-cloud\"},{\"index\":\"goodberry\",\"name\":\"Goodberry\",\"url\":\"/api/spells/goodberry\"},{\"index\":\"hunters-mark\",\"name\":\"Hunter's Mark\",\"url\":\"/api/spells/hunters-mark\"},{\"index\":\"jump\",\"name\":\"Jump\",\"url\":\"/api/spells/jump\"},{\"index\":\"longstrider\",\"name\":\"Longstrider\",\"url\":\"/api/spells/longstrider\"},{\"index\":\"speak-with-animals\",\"name\":\"Speak with Animals\",\"url\":\"/api/spells/speak-with-animals\"}]}";
    private final String badOutputMapper = "{\"ability_score\":{\"index\":\"dex\",\"name\":\"DEX\",\"url\":\"/api/ability-scores/dex\"},\"noslda\":2}";
    private final MapSpells testObject = new MapSpells();

    @Test
    public void mapperHappyPath() {
        String resultForString = testObject.mapClassSpells(outputResponseBody).toString();
        Assertions.assertEquals(outputMapper, resultForString);
    }

    @Test
    public void mapperUNHappyPathNull() {
        String resultForString = testObject.mapClassSpells(outputResponseBody).toString();
        Assertions.assertNotEquals("", resultForString);
    }

    @Test
    public void mapperUnHappyPathNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> testObject.mapClassSpells(badOutputMapper));
    }
}
