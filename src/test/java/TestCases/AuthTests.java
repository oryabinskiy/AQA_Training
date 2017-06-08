package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Created by oleg on 19.05.17.
 */
public class AuthTests extends BaseUITest {

    private static final String DEMOSTORE_URL = "https://demostore.x-cart.com/admin/admin.php";

    String adminLogin = "bit-bucket@x-cart.com";
    String adminPassword = "master";
    String username = "roagold";
    String email = "@gmail.com";
    String password = "Test123";


    @Test
    public void UserShouldBeLoginToAdminWithButtonClick() {
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .clickSubmitButton()
                .getPageUrl();

        assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeLoginToAdminWithSubmitForm(){
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .submitForm()
                .getPageUrl();

        assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeLoginToAdminWithEnterKey(){
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .clickEnterKey()
                .getPageUrl();

        assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeRegistered(){
        WebElement adminPage = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo(adminLogin, adminPassword)
                .submitForm()
                .createNewUser(username, email, password)
                .waitForElementPresent(AdminPage.getLocator());
        assertTrue(adminPage.isDisplayed());
        assertEquals(adminPage.getText(), "Warning: You are not allowed to do this in demo mode.");
    }

}
