package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement spinner;

    @FindBy(xpath = "//iframe[@id='framelive']")
    private WebElement iframe;

    @FindBy(xpath = "//div[@class='block_newsletter col-lg-8 col-md-12 col-sm-12']")
    private WebElement newsLetterText;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[@class='alert alert-danger block_newsletter_alert']")
    private WebElement errorMessage;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openMainPage() {
        getDriver().get("https://demo.prestashop.com/");
    }

    public boolean spinner() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(spinner));
            return spinner.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void findIframe() {
        getDriver().switchTo().frame(iframe);
    }

    public void scrollVisibleTextSubscribe() {
        waitUntilVisible(newsLetterText, 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", newsLetterText);
    }

    public void enterEmail(String email) {
        waitUntilVisible(emailField, 10);
        emailField.sendKeys(email);
        subscribeButton.click();
    }

    public String getErrorMessage() {
        waitUntilVisible(errorMessage, 10);
        return errorMessage.getText();
    }


}
