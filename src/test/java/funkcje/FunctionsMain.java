package funkcje;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionsMain {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        // getText()
//        driver.get("https://pl.wikipedia.org/");
//        WebElement element = driver.findElement(By.id("main-page-column1"));
//        System.out.println(element.getText());
//        System.out.println(element.getAttribute("innerText"));

        // getAttribute()
//        driver.get("https://pl.wikipedia.org/");
        //String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        //System.out.println(atrybut);

//        WebElement searchInput = driver.findElement(By.name("search"));
//        searchInput.sendKeys("Selenium");
//
//        // getText() nic tutaj nie zwroci bo innerText jest puste
//        System.out.println(
//                "getText(): " + searchInput.getText());
//
//        System.out.println(
//                "getAttribute(): "+ searchInput.getAttribute("value"));
//
//        String tag = driver.findElement(By.id("main-page-content")).getTagName();
//        System.out.println(tag);

        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
//        if(search.isEnabled()) {
//            search.sendKeys("Selenium");
//            search.submit();
//        } else {
//            throw new ElementNotInteractableException("searchInput");
//        }

        if (search.isDisplayed()) {
            search.sendKeys("Selenium");
            search.submit();
        } else {
            throw new ElementNotInteractableException("searchInput");
        }
    }
}
