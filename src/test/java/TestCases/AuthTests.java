package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by oleg on 19.05.17.
 */
public class AuthTests extends BaseUITest {

    @Test
    public void UserShouldBeLoginToAdmin(){
        driver.get("https://demostore.x-cart.com/admin/admin.php?target=login");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.name("login"));
        login.clear();
        login.sendKeys("bit-bucket@x-cart.com");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("master");

        password.submit();
    }

}
