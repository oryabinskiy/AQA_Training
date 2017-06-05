package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oleg on 01.06.17.
 */
public class AdminPage extends BasePage {


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void clearAndTypeToElement(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }
}
