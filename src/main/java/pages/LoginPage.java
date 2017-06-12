package pages;

import Utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by oleg on 30.05.17.
 */
public class LoginPage extends BasePage {

    private WebElement login;
    private WebElement password;

    @FindBy(css = "button[class*=submit]")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openXCartSite() {
        LogUtils.testStep("Open site");
        driver.get("https://demostore.x-cart.com/admin/admin.php?target=login");
        return this;
    }

    public LoginPage enterLoginInfo(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return this;
    }

    public void enterLogin(String loginName) {
        clearAndTypeToElement(loginName, driver.findElement(By.name("login")));
    }

    public void enterPassword(String passwordValue) {
        clearAndTypeToElement(passwordValue, driver.findElement(By.name("password")));
    }

    public AdminPage submitForm(){
        password.submit();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    public AdminPage clickSubmitButton() {
        submitButton.click();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    public AdminPage clickEnterKey() {
        password.sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, AdminPage.class);
    }

}
