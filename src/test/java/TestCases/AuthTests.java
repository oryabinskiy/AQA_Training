package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


/**
 * Created by oleg on 19.05.17.
 */
public class AuthTests extends BaseUITest {

    private static final String DEMOSTORE_URL = "https://demostore.x-cart.com/admin/admin.php";
    private static final String DEMOSTOREX_URL = "https://demostore.x-cart.com";

    @Test
    public void UserShouldBeLoginToAdminWithButtonClick() {
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .clickSubmitButton()
                .getPageUrl();

        Assert.assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeLoginToAdminWithSubmitForm(){
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .submitForm()
                .getPageUrl();

        Assert.assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeLoginToAdminWithEnterKey(){
        String currentPageUrl = new LoginPage(driver)
                .openXCartSite()
                .enterLoginInfo("bit-bucket@x-cart.com", "master")
                .clickEnterKey()
                .getPageUrl();

        Assert.assertEquals(currentPageUrl, DEMOSTORE_URL, "Current URL is different from expected");
    }

    @Test
    public void UserShouldBeSignedUp(){
        String currentPageUrl = new HomePage(driver)
                .openHomePage()
                .openSignUpForm()
                .enterRegistrationInfo("roagold+2@gmail.com","Test123","Test123")
                .submitRegistration()
                .getPageUrl();

        Assert.assertEquals(currentPageUrl, DEMOSTOREX_URL, "Current URL is different from expected");
    }
}
