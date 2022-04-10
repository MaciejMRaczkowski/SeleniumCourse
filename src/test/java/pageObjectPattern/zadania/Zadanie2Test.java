package pageObjectPattern.zadania;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectPattern.zadania.hotelPages.AuthenticationPage;
import pageObjectPattern.zadania.hotelPages.RoomBookingPage;
import pageObjectPattern.zadania.hotelPages.SearchBar;
import utils.Utils;

public class Zadanie2Test {

    @Test
    public void searchForHotelTest() {
        WebDriver driver = Utils.createChromeDriver();

        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a")).click();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.logIn("costamcokolwiek@test.com", "adminadmin");

        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a"));
        homeButton.click();

        SearchBar searchBar = new SearchBar(driver);
        searchBar.searchForHotel("The Hotel Prime", "14-04-2022", "25-04-2022");

        RoomBookingPage roomBookingPage = new RoomBookingPage(driver);
        roomBookingPage.bookRoom("3", "luxury Rooms");
    }
}
