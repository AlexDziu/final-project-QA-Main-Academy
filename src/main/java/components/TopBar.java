package components;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static pages.BasePage.getDriver;
import static utils.ScreenShotUtils.*;

@Slf4j
@Getter
public class TopBar {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//i[@class='material-icons expand-more']")
    private WebElement languagesButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']")
    private WebElement dropDownList;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-iso-code='uk']")
    private WebElement ukrVisible;

    public TopBar(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
        webDriver = driver;
        wait = new WebDriverWait(getDriver(), 15);
    }

    @Step("Click on languages button")
    public void clickOnLanguagesButton() {
        wait.until(ExpectedConditions.visibilityOf(languagesButton)).click();
        log.info("Click on languages button");
        makeScreenshot();
    }

    public int checkAmountLanguages() {
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        log.info("Check amount languages");
        return webElementList.size();

    }

    @Step("Check ukrainian language exist")
    public ArrayList<String> checkAllLanguageFromDropdown() {
        wait.until(ExpectedConditions.visibilityOf(dropDownList));
        ArrayList<String> listLanguages = new ArrayList<>();
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        for (WebElement element : webElementList) {
            String language = element.findElement(By.xpath("//a[@data-iso-code='uk']")).getText();
            listLanguages.add(language);
        }
        log.info("Check languages exist");
        makeScreenshot();
        return listLanguages;
    }

    @Step("Click on sign in")
    public void clickOnSignIn() {
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
        log.info("Click on Sign In");
        makeScreenshot();
    }

}
