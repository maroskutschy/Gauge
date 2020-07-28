package gauge_maven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConnectLoginPage extends BasicActions {

//    @FindBy(xpath = "//a[@title='English (US)']")
//    private WebElement switchToEnglishLanguage;

    @FindBy(id = "Login")
    private WebElement userName;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//span[@data-automation-id='loginButton']")
    private WebElement signInButton;

    public ConnectLoginPage(WebDriver driver) {
        super(driver);
    }

    public void successfulLogin(String userName, String password) {
        populateUserNameOrEmailEditbox(userName);
        populatePasswordEditbox(password);
        clickOnSignInButton();
    }

    public void populateUserNameOrEmailEditbox(String userName) {
        clear(this.userName, "userName");
        sendKeys(this.userName, userName, "userName");
    }

    public void populatePasswordEditbox(String password) {
        clear(this.password, "password");
        sendKeys(this.password, password, "password");
    }

    public void clickOnSignInButton() {
        waitForVisibility(signInButton, "signInButton"  );
        click(signInButton, "signInButton");
    }



}
