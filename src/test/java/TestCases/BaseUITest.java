package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by oleg on 19.05.17.
 */
public class BaseUITest {

    protected WebDriver driver;

    @BeforeMethod
    public void testSetup(){
        String browserName = System.getProperty("browser.name");

        if(browserName == null){
            throw new IllegalArgumentException("Browser name is null");
        }

       driver = WebDriverFactory.getDriverInstancne(browserName);
    }

    @AfterMethod
    public void testTearDown(){
        driver.quit();
    }

}
