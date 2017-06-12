package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by oleg on 09.06.17.
 */
public class AQACourseLogger extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LogUtils.info(String.format("Searching for [%s]", by));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LogUtils.info(String.format("Clicking on [%s],", element.toString()));
    }
}
