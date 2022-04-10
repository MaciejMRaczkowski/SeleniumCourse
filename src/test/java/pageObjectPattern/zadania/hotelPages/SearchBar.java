package pageObjectPattern.zadania.hotelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {
    private WebDriver driver;

    @FindBy(id = "hotel_cat_name")
    private WebElement hotelSelect;

    @FindBy(id = "check_in_time")
    private WebElement checkInInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchRoomButton;

    public SearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForHotel(String hotelName, String checkIn, String checkOut) {
        hotelSelect.click();
        WebElement hotel = driver.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li"));
        hotel.click();
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
        searchRoomButton.click();
    }
}
