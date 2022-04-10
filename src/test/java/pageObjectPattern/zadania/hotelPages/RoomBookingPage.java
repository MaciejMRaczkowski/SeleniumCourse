package pageObjectPattern.zadania.hotelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RoomBookingPage {

    private WebDriver driver;

    public RoomBookingPage(WebDriver driver) {
        this.driver = driver;
    }

        public void bookRoom(String quantity, String roomName) {
        WebElement quantityInput = driver.findElement(
                By.xpath(
                        "//p[text()='" + roomName + "']/..//input"));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);


        WebElement bookNowButton = driver.findElement(By.xpath(
                "//p[text()='" + roomName + "']/..//@data-id-product/.."));
        bookNowButton.click();


    }
//    public void bookRoom(String quantity, String roomName) {
//        List<WebElement> rooms = driver.findElements(By.xpath("//*[@id=\"category_data_cont\"]/div"));
//
//        WebElement targetRoom = null;
//        for (WebElement room : rooms
//        ) {
//            if (room.getText().contains(roomName)) {
//                targetRoom = room;
//                break;
//            }
//        }
//        System.out.println(targetRoom.getText());
//        WebElement quantityInput = targetRoom.findElement(By.tagName("input"));
//        quantityInput.clear();
//        quantityInput.sendKeys(quantity);
//        WebElement bookNowButton = targetRoom.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[3]/div/div[2]/a/span"));
//        bookNowButton.click();
//    }
}
