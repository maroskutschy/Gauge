package gauge_maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookMakePostPage extends BasicActions {

    @FindBy (xpath = "//div[@data-block='true']")
    private WebElement postTextArea;

    @FindBy (xpath = "//button[@data-testid='react-composer-post-button']//span[contains(., 'Post')]")
    private WebElement postButton;

    public FacebookMakePostPage(WebDriver driver) {
        super(driver);
    }


}
