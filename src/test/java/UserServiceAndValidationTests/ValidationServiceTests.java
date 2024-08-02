import org.example.UserService.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationServiceTests {

    @Test
    public void InputServiceAlphabetHappyTest() {
        String myTestString = "MyTestString";
        Assertions.assertTrue(ValidationService.onlyAlphabets(myTestString));
    }

    @Test
    public void InputServiceAlphabetUnHappyTest() {
        String myTestString = "My Test String";
        Assertions.assertFalse(ValidationService.onlyAlphabets(myTestString));
    }

    @Test
    public void InputServiceAlphabetUnHappyNullTest() {
        String myTestString = null;
        Assertions.assertFalse(ValidationService.onlyAlphabets(myTestString));
    }

    @Test
    public void InputServiceDigitHappyTest() {
        String myTestString = "123";
        Assertions.assertTrue(ValidationService.onlyDigits(myTestString));
    }

    @Test
    public void InputServiceDigitUnHappyTest() {
        String myTestString = "123asd";
        Assertions.assertFalse(ValidationService.onlyDigits(myTestString));
    }

    @Test
    public void InputServiceDigitUnHappyEmptyStringTest() {
        String myTestString = " ";
        Assertions.assertFalse(ValidationService.onlyDigits(myTestString));
    }
}
