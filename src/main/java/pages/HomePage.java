package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oleg on 01.06.17.
 */
public class HomePage extends BasePage {

    private static final String baseURL = "https://demostore.x-cart.com/";

    @FindBy(className = "header_bar-sign_in")
    private WebElement signInButton;

    @FindBy(id = "login-email")
    private WebElement email;

    @FindBy(id ="login-password")
    private WebElement pass;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(baseURL);
        return this;
    }

    public HomePage openSignInForm(){
        waitForElementClickable(signInButton).click();
        return this;
    }

    public void inputLoginData(String userLogin) {
        WebElement emailField = waitForElementClickable(email);
        clearAndTypeToElement(userLogin, email);
    }

    public void inputPasswordData(String userPassword) {
        WebElement passwordField = waitForElementClickable(pass);
        clearAndTypeToElement(userPassword, pass);
    }

    public HomePage loginAsUser(String login, String password){
        inputLoginData(login);
        inputPasswordData(password);
        pass.submit();
        return this;
    }


}
