package zadaniaDzien4.wyszukiwanieElementow;

//Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora By.id:
//
//
//        (pole tekstowe) Hotel Location
//        (przycisk) Search Now
//        (pole tekstowe) Enter your e-mail (pole na dole stron)
//        Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//        Hotel Location - Warsaw
//        Enter your e-mail - test@test.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // szukanie elementow
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
        WebElement enterYourEmailInput = driver.findElement(By.id("newsletter-input"));

        hotelLocationInput.sendKeys("Warsaw");
        enterYourEmailInput.sendKeys("test@test.com");
    }
}
