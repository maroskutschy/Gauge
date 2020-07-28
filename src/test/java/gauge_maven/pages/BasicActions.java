package gauge_maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicActions {

    // Time out in seconds
    public static final int TIME_OUT = 5;

    public WebDriver driver;

    public WebDriverWait wait;

    public static final Logger LOGGER = LoggerFactory.getLogger(BasicActions.class);

    public BasicActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIME_OUT), this);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    public void clear(WebElement element, String elementName) {
        System.out.println("Clearing Element : " + elementName + ".");
        element.clear();
        System.out.println("Done");
    }

    public void click(WebElement element, String elementName) {
        System.out.println("Clicking on Element : " + elementName + ".");
        element.click();
        System.out.println("Done");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void sendKeys(WebElement element, String fillWith, String elementName) {
        System.out.println("Sending keys: " + fillWith + " into element : " + elementName + ".");
        element.sendKeys(fillWith);
        System.out.println("Done.");
    }

    public void waitForVisibility(WebElement element, String elementName) {
        LOGGER.info("Waiting for visibility of element : " + elementName + ".");
        wait.until(ExpectedConditions.visibilityOf(element));
        LOGGER.info("Done.");
    }

}
