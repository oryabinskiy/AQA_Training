package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oleg on 01.06.17.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".input [name='login']")
    private WebElement emailField;

    @FindBy(css = ".input [name='password']")
    private WebElement passwordField;

    @FindBy(css = ".input [name='login']")
    private WebElement passwordConfirmationField;

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void clearAndTypeToElement(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public HomePage openHomePage(){
        driver.get("https://demostore.x-cart.com/");
        driver.manage().window().maximize();
        return this;
    }

//    public HomePage openSignUpForm(){
//        WebElement signInButton = driver.findElement(By.cssSelector(".header_bar-sign_in [type='button']"));
//        signInButton.click();
//        return this;
//    }

    public HomePage enterRegistrationInfo(String email, String password, String passwordConfirmation){
        enterEmail(email);
        enterPassword(password);
        enterPasswordConfirmation(passwordConfirmation);
        return this;
    }

    public HomePage submitRegistration(){
        passwordConfirmationField.submit();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void enterEmail(String emailAddress) {
        emailField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }



}
