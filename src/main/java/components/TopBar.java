package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static pages.BasePage.getDriver;

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

    public void clickOnLanguagesButton() {
        wait.until(ExpectedConditions.visibilityOf(languagesButton)).click();
        System.out.println("Click on languages button");
    }

    public int checkAmountLanguages() {
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        System.out.println("Check amount languages");
        return webElementList.size();

    }

    public String checkUkrLanguageExist() {
        wait.until(ExpectedConditions.visibilityOf(dropDownList));
        BasePage.waitUntilVisible(ukrVisible, 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", ukrVisible);
        System.out.println("Scroll page down");
        ArrayList<String> listLanguages = new ArrayList<>();
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        for (WebElement element : webElementList) {
            String ukrLanguage = element.findElement(By.xpath("//a[@data-iso-code='uk']")).getText();
            listLanguages.add(ukrLanguage);
        }
        System.out.println("Check languages exist");
        return String.valueOf(listLanguages);
    }

    public void clickOnSignIn() {
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
        System.out.println("Click on Sign In");
    }

}
