package pageObjectPattern.zadania.hotelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddressPage {
    private WebDriver driver;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "submitAddress")
    private WebElement createButton;

    @FindBy(id = "id_country")
    private WebElement countryDropdown;

    public CreateNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillForm(String address, String postalCode, String city, String country, String homePhone){
        addressInput.sendKeys(address);
        postcodeInput.sendKeys(postalCode);
        cityInput.sendKeys(city);
        phoneInput.sendKeys(homePhone);
        countryDropdown.sendKeys(country);
    }
    public void createAddress(){
        createButton.click();
    }
}
