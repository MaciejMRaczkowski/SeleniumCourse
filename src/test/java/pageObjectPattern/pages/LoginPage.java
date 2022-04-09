package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement singInButton;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/ul/li")
    private WebElement authenticationFailedMessage;

    // to powinno znalezc sie w oddzielnym page albo element
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement usernameLabel;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        singInButton.click();
    }

    // to powinno znalezc sie w oddzielnym page albo element
    public String getLoggedUsername() {
        return usernameLabel.getText();
    }

    public boolean isAuthenticationFailedDisplayed() {
        return authenticationFailedMessage.isDisplayed();
    }
}
