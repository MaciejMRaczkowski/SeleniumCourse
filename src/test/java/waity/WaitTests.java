package waity;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTests {

    @Test
    public void noWaitAtAll() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");

        WebElement button = driver.findElement(By.id("button1"));
        button.click();
    }

    @Test
    public void waitWithSleep() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");

        Thread.sleep(5000);

        WebElement button = driver.findElement(By.id("button1"));
        button.click();
    }

    @Test
    public void waitWithImplicitlyWait() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");

        // robimy to tylko jeden raz na test!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement button = driver.findElement(By.id("button1"));
        button.click();
    }

    @Test
    public void waitWithExplicitWait() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.id("button1"));

        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();
    }

}
