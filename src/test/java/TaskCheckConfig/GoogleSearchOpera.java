package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverInfo;

public class GoogleSearchOpera {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver",
                "src/main/resources/drivers/operadriver.exe");

        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();

        driver.get("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Coderslab");
        element.submit();
        driver.quit();
    }
}
