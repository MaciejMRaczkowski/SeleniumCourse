package pageObjectPattern.zadania;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.zadania.hotelPages.AuthenticationPage;
import pageObjectPattern.zadania.hotelPages.CreateNewAddressPage;

import java.time.Duration;

public class Zadanie4Steps {
    private WebDriver driver;

    @Given("user is logged in on account page")
    public void userIsLoggedInOnAccountPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.logIn("johnd@mail.com", "qwerty");

    }

    @When("user click add my first address")
    public void userClickAddMyFirstAddress() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[1]/a/span")).click();
    }

    @When("user fills form with data {string}, {string}, {string}, {string}, {string}")
    public void userFillsFormWithData(String address, String postalCode, String city, String country, String homePhone) {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.fillForm(address, postalCode, city, country, homePhone);

    }
    @And("click Save button to add first address")
    public void clickSaveButtonToAddFirstAddress() {
        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.createAddress();
    }

    @Then("first address is added")
    public void firstAddressIsAdded() {
        WebElement firstAddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul"));
        Assertions.assertTrue(firstAddress.isDisplayed());
    }
}
