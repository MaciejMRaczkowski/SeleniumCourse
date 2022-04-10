package bdd.wyklad;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    private WebDriver driver;

    @Given("an open browser with {string}")
    public void anOpenBrowserWithGoogleCom(String website) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(website);
    }

    @When("a keyword {string} is entered in input field")
    public void aKeywordIsEnteredInInputField(String keyword) {
        driver.findElement(By.id("L2AGLb")).click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("the first one should contain {}")
    public void theFirstOneShouldContain(String keyword) {
        System.out.println(keyword);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
