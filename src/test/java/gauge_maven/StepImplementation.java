package gauge_maven;

import com.thoughtworks.gauge.*;
import gauge_maven.pages.*;
import org.openqa.selenium.WebDriver;

public class StepImplementation {

    public static WebDriver driver;
    private FacebookLoginPage facebookLoginPage;
    private FacebookWelcomePage facebookWelcomePage;
    private FacebookMakePostPage facebookMakePostPage;
    private FacebookPage facebookPage;
    private FacebookApi facebookApi;
    private ConnectLoginPage connectLoginPage;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(".BEFORE SUITE.");
    }

    @BeforeSpec
    public void beforeSpec() {
        System.out.println(".BEFORE SPEC.");
    }

    @BeforeScenario
    public void openBrowserWithLink() throws Throwable {
        System.out.println(".BEFORE SCENARIO.");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(System.getenv("LINK"));
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println(".BEFORE STEP.");
    }

    /// CONNECT ///

    @Step("In Connect, I populate value <userName> in Username or email address editbox")
    public void inConnectpopulateUserNameOrEmailEditbox(String userName) {
        connectLoginPage = new ConnectLoginPage(driver);
        connectLoginPage.populateUserNameOrEmailEditbox(userName);
    }

    @Step("In Connect, I populate value <password> in Password editbox")
    public void inConnectpopulatePasswordEditbox(String password) {
        connectLoginPage = new ConnectLoginPage(driver);
        connectLoginPage.populatePasswordEditbox(password);
    }

    @Step("In Connect, I click on Sign In button")
    public void clickOnSignInButton() {
        connectLoginPage = new ConnectLoginPage(driver);
        connectLoginPage.clickOnSignInButton();
    }

    @Step("I login to Connect with user <userName> and password <password> without concept steps")
    public void loginToConnectWithoutConceptSteps(String userName, String password) throws Throwable {
        inConnectpopulateUserNameOrEmailEditbox(userName);
        inConnectpopulatePasswordEditbox(password);
        clickOnSignInButton();
        //        connectLoginPage = new ConnectLoginPage(driver);
        //        connectLoginPage.successfulLogin(userName, password);
    }

    /// CONNECT ///


    @Step("In Facebook app, I successfully login to facebook with email <email> and password <password>")
    public void successfulLoginToFacebookWithCredentials(String email, String password) throws Throwable {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookWelcomePage = facebookLoginPage.successfulLogin(email, password);
    }


    @Step("In Facebook app, I navigate to the Nessathon2018 page")
    public void navigateToMyPage() {
        facebookWelcomePage = new FacebookWelcomePage(driver);
        facebookPage = facebookWelcomePage.openPage();

    }

    @ContinueOnFailure
    @Step("In Facebook app, I edit my last comment <message>")
    public void updateComment(String message) throws InterruptedException {
        facebookApi = new FacebookApi(driver);
        facebookPage.editComment(" "+message);
    }

    @ContinueOnFailure
    @Step("In Facebook app, I delete my last comment")
    public void deleteComment() throws InterruptedException {
        facebookApi = new FacebookApi(driver);
        facebookPage.deleteComment();
    }

    @Step("I populate value <email> in Email or Phone editbox")
    public void populateEmailOrPhoneEditbox(String name) {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.populateEmailOrPhoneEditbox(name);
    }

    @Step("I populate value <password> in Password editbox")
    public void populatePasswordEditbox(String password) {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.populatePasswordEditbox(password);
    }

    @Step("I click on Log In button")
    public void clickOnLoginButton() {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookWelcomePage = facebookLoginPage.clickOnLoginButton();

    }


    //  Facebook API steps
    @Step("Using Facebook Graph API, I post on Nessathon2018's page feed <message>")
    public void postFeedApi(String message) {
        facebookApi = new FacebookApi(driver);
        facebookApi.postFeedForMyPage(message);
    }

    @Step("Using Facebook Graph API, I make a comment <message>")
    public void postCommentForFeed(String message) {
        facebookApi = new FacebookApi(driver);
        facebookApi.postCommentForFeed(message);
    }

    @Step("Using Facebook Graph API, I remove post")
    public void removeFeed() {
        facebookApi.removeFeed();
    }

    @Step("In Facebook app, I verify that comment is correct")
    public void implementation1() {
        //TO DO
    }


    @Step("In Facebook app, I verify that comment was deleted")
    public void implementation2() {
        //TO DO
    }

    @AfterStep
    public void afterStep() {
        System.out.println(".BEFORE STEP.");
    }

    @AfterScenario
    public void closeBrowser() {
        System.out.println(".AFTER SCENARIO.");
        driver.quit();
    }

    @AfterSpec
    public void afterSpec() {
        System.out.println(".AFTER SPEC.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(".AFTER SUITE.");
    }

}
