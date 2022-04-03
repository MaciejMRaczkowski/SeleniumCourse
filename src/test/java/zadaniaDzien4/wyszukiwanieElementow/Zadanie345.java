package zadaniaDzien4.wyszukiwanieElementow;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadanie345 {

    public static void main(String[] args) {

        String userEmail = "ran432kfhjemail@mail.com";
        String title = "Mr";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.className("user_login")).click();

        WebElement registerEmailInput = driver.findElement(By.id("email_create"));
        registerEmailInput.sendKeys(userEmail);
        driver.findElement(By.id("SubmitCreate")).click();

        // wybierz title
        if (title == "Mr")
            driver.findElement(By.id("id_gender1")).click();
        else if (title == "Mrs")
            driver.findElement(By.id("id_gender2")).click();

        // wyszukanie first name
        // WebElement firstNameInput = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        if (firstNameInput.isDisplayed()) {
            firstNameInput.sendKeys("John");
        } else {
            throw new ElementNotInteractableException("firstNameInput");
        }

        // wyszukanie last name
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        if (lastNameInput.isDisplayed()) {
            lastNameInput.sendKeys("Doe");
        } else {
            throw new ElementNotInteractableException("lastNameInput");
        }

        // wyszukanie email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        if (emailInput.isDisplayed()) {
            emailInput.clear();
            emailInput.sendKeys(userEmail);
        } else {
            throw new ElementNotInteractableException("emailInput");
        }

        // wyszukanie password
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        if (passwordInput.isDisplayed()) {
            passwordInput.sendKeys("qwerty12345");
        } else {
            throw new ElementNotInteractableException("passwordInput");
        }

        // dropdowny
        WebElement dayElement = driver.findElement(By.id("days"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("20");

        WebElement monthsElement = driver.findElement(By.id("months"));
        Select monthsSelect = new Select(monthsElement);
        monthsSelect.selectByValue("9");

        WebElement yearsElement = driver.findElement(By.id("years"));
        Select yearsSelect = new Select(yearsElement);
        yearsSelect.selectByValue("2000");

        // wyszukanie przycisku Register i klikniecie
        WebElement submitAccountButton = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]"));
        if (submitAccountButton.isDisplayed()) {
            submitAccountButton.click();
        } else {
            throw new ElementNotInteractableException("submitAccountButton");
        }

        // cssSelector
        WebElement myAddressesElement = driver.findElement(By.cssSelector("#center_column > div > div > ul > li:nth-child(4) > a > span"));
        WebElement myPersonalInformationElement = driver.findElement(By.cssSelector("#center_column > div > div > ul > li:nth-child(5) > a > span"));

        driver.quit();
    }
}
