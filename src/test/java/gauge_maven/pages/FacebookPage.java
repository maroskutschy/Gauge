package gauge_maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class FacebookPage extends BasicActions {

    @FindBy(css = "span[class=_36rj] a")
    private WebElement clickToSeeCommentEditOptions;

    @FindBy(css = "span[class=_54nh]")
    private List<WebElement> modifyComment;

    @FindBy(css = "a[action=cancel]")
    private List<WebElement> deleteCommentActions;

    @FindBy(css = "div[data-testid=ufi_comment_composer]")
    private WebElement commentText;

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    public FacebookPage editComment(String comment) throws InterruptedException {
        Thread.sleep(3000);
        clickToEditComment();
        Thread.sleep(3000);
        updateComment(comment);
        Thread.sleep(3000);
        return new FacebookPage(driver);
    }

    public void deleteComment() throws InterruptedException {
        Thread.sleep(3000);
        clickToEditComment();
        Thread.sleep(3000);
        modifyComment.get(1).click();
        Thread.sleep(3000);
        deleteCommentConfirmation("delete");
    }


    private void updateComment(String comment) {
        wait.until(ExpectedConditions.elementToBeClickable(modifyComment.get(1)));
        modifyComment.get(0).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(commentText, comment);
        actions.sendKeys(ENTER);
        actions.perform();
    }


    private void clickToEditComment() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class=_36rj] a")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        clickToSeeCommentEditOptions.click();
    }

    public void deleteCommentConfirmation(String action) {
        if (action.equalsIgnoreCase("cancel")) deleteCommentActions.get(0).click();
        else if (action.equalsIgnoreCase("delete")) deleteCommentActions.get(1).click();
    }


}
