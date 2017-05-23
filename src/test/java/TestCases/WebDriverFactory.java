package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by oleg on 19.05.17.
 */
public class WebDriverFactory {
    
    public static WebDriver getDriverInstancne(String browserName) {
        WebDriver driver;
        switch (browserName){
            case BrowserType.CHROME:
                driver = setUpChromeInstance();
                break;
            case BrowserType.FIREFOX:
                driver = setUpFirefoxInstance();
                break;
            default:
                throw new IllegalArgumentException(String.format("%s is not valid browser name", browserName));
        }
        return driver;
    }

    private static WebDriver setUpChromeInstance() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                "/Users/oleg/Projects/AQA_Training/src/main/resources/Drivers/chromedriver");

        getChromeDesiredCapabilities();

       DesiredCapabilities chromeDesireCapabilities = getChromeDesiredCapabilities();

       return new ChromeDriver(chromeDesireCapabilities);
    }

    private static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("start-maximized");

       desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return desiredCapabilities;
    }

    private static WebDriver setUpFirefoxInstance(){
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,
                "/Users/oleg/Projects/AQA_Training/src/main/resources/Drivers/geckodriver");

        getFirefoxDesiredCapabilities();

        DesiredCapabilities firefoxDesireCapabilities = getFirefoxDesiredCapabilities();

        return new FirefoxDriver(firefoxDesireCapabilities);

    }

    private static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        return desiredCapabilities;
    }
}
