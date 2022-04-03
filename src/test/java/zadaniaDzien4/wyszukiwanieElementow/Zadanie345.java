package zadaniaDzien4.wyszukiwanieElementow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Zadanie345 {

    public static void main(String[] args) {

        String userEmail = "ran4324m123423423email@mail.com";
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
        firstNameInput.sendKeys("John");

        // wyszukanie last name
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        lastNameInput.sendKeys("Doe");

        // wyszukanie email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.clear();
        emailInput.sendKeys(userEmail);

        // wyszukanie password
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("qwerty12345");

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
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

        // cssSelector
        WebElement myAddressesElement = driver.findElement(By.cssSelector("#center_column > div > div > ul > li:nth-child(4) > a > span"));
        WebElement myPersonalInformationElement = driver.findElement(By.cssSelector("#center_column > div > div > ul > li:nth-child(5) > a > span"));
    }
}
