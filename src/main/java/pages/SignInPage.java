package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignInPage extends BasePage {

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement createAccountLink;

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickOnCreateAccount() {
        waitUntilVisible(createAccountLink, 10).click();
        System.out.println("Click on create account");
    }
}
