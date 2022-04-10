package pageObjectPattern.zadania.hotelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    private WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement newUserEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void startCreatingAnAccount(String email) {
        newUserEmailInput.sendKeys(email);
        createAnAccountButton.click();
    }

    public void logIn(String email, String password){
        loginEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLoginButton.click();
    }
}
