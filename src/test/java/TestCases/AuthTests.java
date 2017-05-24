package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by oleg on 19.05.17.
 */
public class AuthTests extends BaseUITest {

    String adminURL = "https://demostore.x-cart.com/admin/admin.php?target=login";
    String adminLogin = "bit-bucket@x-cart.com";
    String adminPassword = "master";
    String newUserEmail = "testemail@gmail.com";
    String newUserPass = "Test123";
    WebDriverWait wait;

    @Test
    public void UserShouldBeLoginToAdmin() {
        driver.get(adminURL);
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys(adminLogin);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(adminPassword);

        password.submit();
    }

    @Test
    public void UserShouldBeLoginToAdminByClickOnButton() {
        driver.get(adminURL);
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys(adminLogin);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(adminPassword);

        driver.findElement(By.xpath("//button[contains(@class,'submit')]"));
    }

    @Test
    public void UserShouldBeLoginToAdminByTapOnEnterKey() {
        driver.get(adminURL);
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys(adminLogin);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(adminPassword);

        password.sendKeys(Keys.ENTER);

    }

    @Test(priority = 1)
    public void CreateUser() {
        driver.get(adminURL);
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys(adminLogin);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(adminPassword);

        password.submit();

        wait = new WebDriverWait(driver, 10);

        WebElement closePopupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-dialog-titlebar-close")));

        closePopupBtn.click();

        WebElement addNewBtn = driver.findElement(By.xpath(".//*[@id='leftMenu']/ul[1]/li[3]/div[1]/span"));
        addNewBtn.click();
        WebElement addNewUserBtn = driver.findElement(By.xpath(".//*[@id='leftMenu']/ul[1]/li[3]/div[2]/ul/li[3]/div/a"));
        addNewUserBtn.click();

        WebElement emailField = driver.findElement(By.xpath(".//*[@id='login']"));
        emailField.sendKeys(newUserEmail);
        WebElement passwordField = driver.findElement(By.xpath(".//*[@id='password']"));
        passwordField.sendKeys(newUserPass);
        WebElement confirmPassword = driver.findElement(By.xpath(".//*[@id='password-conf']"));
        confirmPassword.sendKeys(newUserPass);

        confirmPassword.submit();

    }


    @Test(priority = 2)
    public void Login(){
        driver.get(adminURL);
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys(newUserEmail);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys(newUserPass);

        driver.findElement(By.xpath("//button[contains(@class,'submit')]"));
    }

}
