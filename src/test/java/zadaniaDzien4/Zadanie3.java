package zadaniaDzien4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Wejdź na stronę: https://www.google.com
        driver.get("https://www.google.com");
//        Wejdź na stronę: https://coderslab.pl/pl
        driver.get("https://coderslab.pl/pl");
//        Cofnij się do strony: https://www.google.com
        driver.navigate().back();
//        Wejdź na stronę: https://mystore-testlab.coderslab.pl/index.php
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
//        Cofnij się do strony: https://www.google.com
        driver.navigate().back();
//        Powróć do strony: https://mystore-testlab.coderslab.pl/index.php
        driver.navigate().forward();
//        Odśwież stronę: https://mystore-testlab.coderslab.pl/index.php
        driver.navigate().refresh();

        driver.quit();
    }
}
