package zadaniaDzien4.wyszukiwanieElementow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadanie345 {

    public static void main(String[] args) {

        String userEmail = "random123123email@mail.com";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.className("user_login")).click();

        WebElement registerEmailInput = driver.findElement(By.id("email_create"));
        registerEmailInput.sendKeys(userEmail);
        driver.findElement(By.id("SubmitCreate")).click();

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

        // wyszukanie przycisku Register i klikniecie
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
    }
}
