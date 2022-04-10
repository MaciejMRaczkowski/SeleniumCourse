package bdd.zadania;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadanie2Steps {

    private WebDriver driver;

    @Given("user is on authentication page")
    public void userIsOnAuthenticationPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }

    @When("user inputs registration email as {string}")
    public void userInputsRegistrationEmail(String email) {
        WebElement emailRegistration = driver.findElement(By.id("email_create"));
        ((WebElement) emailRegistration).sendKeys(email);
    }

    @And("user clicks Create an account button")
    public void userClicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user fills form with data {string}, {string}, {string}")
    public void userFillsFormWithData(String firstName, String lastName, String passwd) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
    }

    @And("user clicks Register button")
    public void userClicksRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("user is registered")
    public void userIsRegistered() {
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));

        Assertions.assertTrue(alert.isDisplayed());
    }
}
