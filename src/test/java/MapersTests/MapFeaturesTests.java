import org.example.Character.Mappers.MapFeatures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapFeaturesTests {

    //index 2
    private final String outputMapper = "[Feature{featureName='Bonus Proficiency'}, Feature{featureName='Disciple of Life'}, Feature{featureName='Divine Domain'}, Feature{featureName='Domain Spells'}, Feature{featureName='Spellcasting: Cleric'}]";
    private final String outputResponseBody = "{\"count\":5,\"results\":[{\"index\":\"bonus-proficiency\",\"name\":\"Bonus Proficiency\",\"url\":\"/api/features/bonus-proficiency\"},{\"index\":\"disciple-of-life\",\"name\":\"Disciple of Life\",\"url\":\"/api/features/disciple-of-life\"},{\"index\":\"divine-domain\",\"name\":\"Divine Domain\",\"url\":\"/api/features/divine-domain\"},{\"index\":\"domain-spells-1\",\"name\":\"Domain Spells\",\"url\":\"/api/features/domain-spells-1\"},{\"index\":\"spellcasting-cleric\",\"name\":\"Spellcasting: Cleric\",\"url\":\"/api/features/spellcasting-cleric\"}]}";
    private final String badOutputMapper = "{\"ability_score\":{\"index\":\"dex\",\"name\":\"DEX\",\"url\":\"/api/ability-scores/dex\"},\"noslda\":2}";
    private final MapFeatures testObject = new MapFeatures();

    @Test
    public void mapperHappyPath() {
        String resultForString = testObject.mapClassFeatures(outputResponseBody).toString();
        Assertions.assertEquals(outputMapper, resultForString);
    }

    @Test
    public void mapperUnHappyPathNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> testObject.mapClassFeatures(badOutputMapper));
    }
}
