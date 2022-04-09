package pageObjectPattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.LoginPage;
import utils.Utils;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.createChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWithProperCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");
        Assertions.assertEquals("John Doe", loginPage.getLoggedUsername());
    }

    @Test
    public void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "wrongPassword");
        Assertions.assertTrue(loginPage.isAuthenticationFailedDisplayed());
    }
}
