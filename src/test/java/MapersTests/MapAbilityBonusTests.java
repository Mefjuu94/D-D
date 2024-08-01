import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.Character.AbilityBonus;
import org.example.Character.JSONMapper;
import org.example.Character.Mappers.MapAbilityBonus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MapAbilityBonusTests {

    //index 2
    private final List<AbilityBonus> abilityBonuses = new ArrayList<>();
    private final MapAbilityBonus testObject = new MapAbilityBonus();

    private final ArrayNode outputMapper;
    private final ArrayNode badOutputMapper;
    {
        try {
            outputMapper = (ArrayNode) JSONMapper.MAPPER.readTree("[{\"ability_score\":{\"index\":\"dex\",\"name\":\"DEX\",\"url\":\"/api/ability-scores/dex\"},\"bonus\":2}]");
            badOutputMapper = (ArrayNode) JSONMapper.MAPPER.readTree("[{\"ability_score\":{\"index\":\"dex\",\"name\":\"DEX\",\"url\":\"/api/ability-scores/dex\"},\"noslda\":2}]");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void MapAbilityBonusTestsHappyPath() {
        abilityBonuses.add(new AbilityBonus("DEX",2));
        Assertions.assertEquals(abilityBonuses,testObject.mapAbilityBonus(outputMapper));
    }

    @Test
    public void MapAbilityBonusUnHappyPath(){
        Assertions.assertNotEquals(abilityBonuses,testObject.mapAbilityBonus(outputMapper));
    }

    @Test
    public void mapperUnHappyPathIndexOutOfBoundsException(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->testObject.mapAbilityBonus(badOutputMapper));
    }

}
