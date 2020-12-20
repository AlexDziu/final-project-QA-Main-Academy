package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.ScreenShotUtils.*;

@Slf4j
@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement spinner;

    @FindBy(xpath = "//div[@class='block_newsletter col-lg-8 col-md-12 col-sm-12']")
    private WebElement newsLetterText;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[@class='alert alert-danger block_newsletter_alert']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='_desktop_logo']")
    private WebElement myStore;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("Open main page")
    public void openMainPage() {
        log.info("Opening main page of the application");
        getDriver().get("https://demo.prestashop.com/");
        waitingSpinner();
        switchIframe();
        waitUntilVisible(myStore, 15);
        makeScreenshot();
    }

    public boolean waitingSpinner() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(spinner));
            log.info("Spinner displayed");
            return spinner.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void scrollVisibleTextSubscribe() {
        waitUntilVisible(newsLetterText, 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", newsLetterText);
        log.info("Scroll page down");
    }

    @Step("Enter email and see error message ")
    public void enterEmail(String email) {
        Actions actions = new Actions(getDriver());
        waitUntilVisible(emailField, 10);
        emailField.sendKeys(email);
        waitUntilVisible(subscribeButton, 10);
        actions.doubleClick(subscribeButton).build().perform();
        log.info("Enter email");
        makeScreenshot();

    }

    public String getErrorMessage() {
        waitUntilVisible(errorMessage, 15);
        log.info("get error message");
        return errorMessage.getText();
    }


}
