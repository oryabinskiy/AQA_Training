package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oleg on 01.06.17.
 */
public class AdminPage extends BasePage {

    private WebElement login;
    private WebElement password;

    @FindBy(id = "password-conf")
    private WebElement passwordConf;
    @FindBy(xpath = ".//*[@id='header']/div[2]/div[5]/div[1]")
    private WebElement QuickMenu;
    @FindBy(xpath = ".//*[@id='header']/div[2]/div[5]/div[2]/div/ul/li[3]/div/a")
    private WebElement addNewUserItem;
    static String locator = ".//*[@id='status-messages']/ul/li";
    @FindBy(className = "ui-dialog-titlebar-close")
    private WebElement widgetCloseButton;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public AdminPage createNewUser(String username, String mail, String userPassword) {
        waitForElementClickable(widgetCloseButton).click();
        clickOnElement(QuickMenu);
        clickOnElement(addNewUserItem);

        WebElement newUserLogin = waitForElementClickable(login);
        clearAndTypeToElement(username+getCurrentDate()+mail, newUserLogin);
        clearAndTypeToElement(userPassword,password);
        clearAndTypeToElement(userPassword,passwordConf);

        passwordConf.submit();
        return this;
    }

    public void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getLocator() {
        return locator;
    }


}
