package components;

import lombok.Getter;
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

    public TopBar(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
        webDriver = driver;
        wait = new WebDriverWait(getDriver(), 15);
    }

    public void clickOnLanguagesButton() {
        wait.until(ExpectedConditions.visibilityOf(languagesButton)).click();
    }

    public int checkAmountLanguages() {
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        return webElementList.size();
    }

    public String checkUkrLanguageExist() {
        wait.until(ExpectedConditions.visibilityOf(dropDownList));
        ArrayList<String> listLanguages = new ArrayList<>();
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        for (WebElement element : webElementList) {
            String ukrLanguage = element.findElement(By.xpath("//a[@data-iso-code='uk']")).getText();
            listLanguages.add(ukrLanguage);
        }
        return String.valueOf(listLanguages);
    }

    public void clickOnSignIn() {
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
    }

}
