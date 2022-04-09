package pageObjectPattern.zadania;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class Zadanie1Test {

    private WebDriver driver;

    @Test
    public void registerUserTest() {
        driver = Utils.createChromeDriver();
    }
}
