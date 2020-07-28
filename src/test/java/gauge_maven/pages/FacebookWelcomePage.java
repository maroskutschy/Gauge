package gauge_maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookWelcomePage extends BasicActions {

    @FindBy (xpath = "//a[@data-testid='left_nav_item_Welcome']//div[contains(., 'Welcome')]")
    private WebElement welcomeLabel;

    @FindBy (xpath = "//a[contains(.,'News Feed')]")
    private WebElement newsFeed;

    @FindBy (xpath = "//span//span[contains(., 'Make Post')]")
    private WebElement makePostButton;

    public FacebookWelcomePage(WebDriver driver) {
        super( driver );
    }

    public FacebookPage openPage () {
        driver.get("https://www.facebook.com/Nessathon2018-492041324645402/");
        return new FacebookPage(driver);
    }

}
