package pageObjectPattern.zadania;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.zadania.hotelPages.AuthenticationPage;
import pageObjectPattern.zadania.hotelPages.RegistrationPage;

import java.time.Duration;

public class Zadanie1Test {

    private WebDriver driver;

    @Test
    public void registerUserTest() {
        //driver = Utils.createChromeDriver();
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // sign in powinno tez byc w page object patter
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.startCreatingAnAccount("jo3432445hnd2q321@mail.com");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser("John", "Doe", "qwerty");

        WebElement alert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));

        Assertions.assertTrue(alert.isDisplayed());
    }
}
