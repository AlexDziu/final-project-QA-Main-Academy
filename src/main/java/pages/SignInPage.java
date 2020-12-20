package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenShotUtils.*;

@Slf4j
@Getter
public class SignInPage extends BasePage {

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement createAccountLink;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("I click on create account")
    public void clickOnCreateAccount() {
        waitUntilVisible(createAccountLink, 10).click();
        log.info("Click on create account");
        makeScreenshot();
    }
}
