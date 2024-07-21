import org.example.Character.Mappers.MapCharacterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapAbilityBonusTests {

    //TODO ogarnąć skąd wziąć te dane
    private final String outputMapper = "";
    private final String outputResponseBody = "";
    MapCharacterClass testObject = new MapCharacterClass();


    public void mapperHappyPath(){
        String resultForString = testObject.mapCharacterClass(outputResponseBody).toString();
        Assertions.assertEquals(outputMapper,resultForString);
    }


    public void mapperUNHappyPath(){
        Assertions.assertNotEquals(outputMapper," ");
    }

}
