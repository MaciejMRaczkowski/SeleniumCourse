package zadaniaDzien4.wyszukiwanieElementow;

//Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora By.name:
//
//
//        (pole tekstowe) Hotel Location
//        (przycisk) Search Now
//        (pole tekstowe) Enter your e-mail (pole na dole stron)
//        (przycisk) Subscribe
//        Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//        Hotel Location - Warsaw
//        Enter your e-mail - test@test.com
//Dodatkowo kliknij przycisk Serach Now, używając metody Submit np.
//
//        findElement(By.name("q")).submit();

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // szukanie elementow
        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
        WebElement enterYourEmailInput = driver.findElement(By.name("email"));
        WebElement submitNewsletterButton = driver.findElement(By.name("submitNewsletter"));

        hotelLocationInput.sendKeys("Warsaw");
        enterYourEmailInput.sendKeys("test@test.com");

        searchNowButton.click();
    }
}
